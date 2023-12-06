use uniffi_kotlin_multiplatform::KotlinBindingGenerator;
use camino::Utf8Path;

fn main() {
    let out_dir = Utf8Path::new("target/kotlin");
    let config = Utf8Path::new("./uniffi.toml");
    uniffi_bindgen::generate_external_bindings(
        KotlinBindingGenerator {},
        "./uniffi/askar.udl",
        None::<&Utf8Path>,
        Some(out_dir)
    ).unwrap();
}
