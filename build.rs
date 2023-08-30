use uniffi_kotlin_multiplatform::KotlinBindingGenerator;

fn main() {
    uniffi::generate_scaffolding("./uniffi/askar.udl").unwrap();
    uniffi_bindgen::generate_external_bindings(
        KotlinBindingGenerator{},
        "./uniffi/askar.udl",
        None::<&Utf8Path>,
        Some("./outKotlin")
    ).unwrap();
}
