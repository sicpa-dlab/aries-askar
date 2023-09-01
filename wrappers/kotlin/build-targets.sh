# BUILD IOS TARGETS
rustup toolchain install 1.65.0 --target aarch64-apple-ios 
cargo  build --release --features uffi --target aarch64-apple-ios 
rustup toolchain install 1.65.0 --target aarch64-apple-ios-sim 
cargo  build --release  --features uffi --target aarch64-apple-ios-sim 
rustup toolchain install 1.65.0 --target x86_64-apple-ios  
cargo  build --release  --features uffi --target x86_64-apple-ios 

# BUILD ANDROID TARGETS

#cargo install --bins --git https://github.com/rust-embedded/cross --tag v0.2.4 cross
cargo install cross --git https://github.com/cross-rs/cross

rustup toolchain install 1.65.0 --target aarch64-linux-android 
cross build --release --features uffi --target aarch64-linux-android 
rustup toolchain install 1.65.0 --target armv7-linux-androideabi 
cross build --release --features uffi --target armv7-linux-androideabi 
rustup toolchain install 1.65.0 --target i686-linux-android 
cross build --release --features uffi --target i686-linux-android 
rustup toolchain install 1.65.0 --target x86_64-linux-android 
cross build --release --features uffi --target x86_64-linux-android 

# BUILD MAC OS TARGETS
../../build-universal.sh