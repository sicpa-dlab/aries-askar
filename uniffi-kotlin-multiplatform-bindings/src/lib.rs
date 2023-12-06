use std::collections::HashMap;
use std::{fs};
use std::fs::File;
use std::io::Write;

use anyhow::Result;
use camino::{Utf8Path, Utf8PathBuf};
use include_dir::{include_dir, Dir};
use serde::{Deserialize, Serialize};
use uniffi_bindgen::backend::TemplateExpression;
use uniffi_bindgen::{BindingGenerator, BindingGeneratorConfig, ComponentInterface, macro_metadata};

pub use gen_kotlin_multiplatform::generate_bindings;

pub mod gen_kotlin_multiplatform;

#[derive(Debug, Default, Clone, Serialize, Deserialize)]
pub struct Config {
    package_name: Option<String>,
    cdylib_name: Option<String>,
    #[serde(default)]
    custom_types: HashMap<String, CustomTypeConfig>,
    #[serde(default)]
    external_packages: HashMap<String, String>,
    library_file: Option<Utf8PathBuf>
}

// impl<'de> Deserialize<'de> for Config {
//     fn deserialize<D>(_deserializer: D) -> Result<Self, D::Error>
//         where D: serde::Deserializer<'de>,
//     {
//         _deserializer.deserialize_any()
//     }
// }

impl Config {
    pub fn package_name(&self) -> String {
        if let Some(package_name) = &self.package_name {
            package_name.clone()
        } else {
            "uniffi".into()
        }
    }

    pub fn cdylib_name(&self) -> String {
        if let Some(cdylib_name) = &self.cdylib_name {
            cdylib_name.clone()
        } else {
            "uniffi".into()
        }
    }
}

impl BindingGeneratorConfig for Config {
    fn get_entry_from_bindings_table(_bindings: &toml::value::Value) -> Option<toml::value::Value> {
        if let Some(table) = _bindings.as_table() {
            table.get("kotlin-native").map(|v| v.clone())
        } else {
            None
        }
    }

    fn get_config_defaults(ci: &ComponentInterface) -> Vec<(String, toml::value::Value)> {
        vec![
            ("package_name".to_string(), toml::value::Value::String(ci.namespace().to_string())),
            ("cdylib_name".to_string(), toml::value::Value::String(ci.namespace().to_string())),
        ]
    }
}

#[derive(Debug, Default, Clone, Serialize, Deserialize)]
pub struct CustomTypeConfig {
    imports: Option<Vec<String>>,
    type_name: Option<String>,
    into_custom: TemplateExpression,
    from_custom: TemplateExpression,
}

pub struct KotlinMultiplatformBindings {
    common: HashMap<String, String>,
    jvm: HashMap<String, String>,
    native: HashMap<String, String>,
    header: String,
}

pub struct KotlinBindingGenerator {}

impl BindingGenerator for KotlinBindingGenerator {
    type Config = Config;

    fn write_bindings(
        &self,
        ci: ComponentInterface,
        config: Self::Config,
        out_dir: &Utf8Path,
    ) -> Result<()> {
        let mut ci = ci;

        if let Some(library_file) = &config.library_file {
            
            let target_triple = if cfg!(all(target_os = "macos", target_arch = "x86_64")) {
                "x86_64-apple-darwin"
            } else if cfg!(all(target_os = "macos", target_arch = "aarch64")) {
                "aarch64-apple-darwin"
            } else if cfg!(all(target_os = "linux", target_arch = "x86_64")) {
                "x86_64-unknown-linux-gnu"
            } else {
                "unknown-target-triple"
            };

            if target_triple != String::from("unknown-target-triple"){
                let effective_library_file = library_file.to_string().replace("<cargo-target>", target_triple);
                macro_metadata::add_to_ci_from_library(&mut ci, Utf8Path::new(&effective_library_file))?;
            }else{
                let effective_library_file = library_file.to_string();
                macro_metadata::add_to_ci_from_library(&mut ci, Utf8Path::new(&effective_library_file))?;
            }
        }

        let bindings = generate_bindings(&config, &ci)?;

        create_target(&config, include_dir!("uniffi-kotlin-multiplatform-bindings/kotlin-uniffi-base/src/commonMain/kotlin"), out_dir, "commonMain", bindings.common);
        create_target(&config, include_dir!("uniffi-kotlin-multiplatform-bindings/kotlin-uniffi-base/src/jvmMain/kotlin"), out_dir, "jvmMain", bindings.jvm);
        create_target(&config, include_dir!("uniffi-kotlin-multiplatform-bindings/kotlin-uniffi-base/src/nativeMain/kotlin"), out_dir, "nativeMain", bindings.native);

        create_cinterop(&ci, out_dir, bindings.header);

        Ok(())
    }
}

fn create_target(config: &Config, base_dir: Dir, out_dir: &Utf8Path, name: &str, files: HashMap<String, String>) {
    let mut all_files: HashMap<String, String> = HashMap::new();
    for base_file in base_dir.files() {
        let file_name = base_file.path().file_name().unwrap().to_str().unwrap().to_string();
        let file_content = base_file.contents_utf8().unwrap().to_string();
        all_files.insert(file_name, file_content);
    }
    all_files.extend(files);

    let package_path: Utf8PathBuf = config.package_name().split(".").collect();
    let dst_dir = Utf8PathBuf::from(out_dir).join(&name).join("kotlin").join(package_path);
    fs::create_dir_all(&dst_dir).unwrap();
    for (file_name, file_content) in all_files {
        let file_path = Utf8PathBuf::from(&dst_dir).join(file_name);
        let mut f = File::create(&file_path).unwrap();
        writeln!(f, "package {}", config.package_name()).unwrap();
        writeln!(f, "").unwrap();
        write!(f, "{}", file_content).unwrap();
    }
}

fn create_cinterop(ci: &ComponentInterface, out_dir: &Utf8Path, content: String) {
    let dst_dir = Utf8PathBuf::from(out_dir).join("nativeInterop").join("cinterop").join("headers").join(ci.namespace());
    fs::create_dir_all(&dst_dir).unwrap();
    let file_path = Utf8PathBuf::from(dst_dir).join(format!("{}.h", ci.namespace()));
    let mut f = File::create(&file_path).unwrap();
    write!(f, "{}", content).unwrap();
}