#!/bin/sh

set -eo pipefail

NAME="aries_askar"
VERSION=$(cargo generate-lockfile && cargo pkgid | sed -e "s/^.*#//")
BUNDLE_IDENTIFIER="org.hyperledger.$NAME"
LIBRARY_NAME="lib$NAME.a"
FRAMEWORK_LIBRARY_NAME=${NAME}FFI
HEADER_NAME="${NAME}FFI.h"
OUT_PATH="kotlinOut"
WRAPPER_PATH="wrappers/kotlin/Askar/Sources/Askar"

AARCH64_LINUX_ANDROID="./target/aarch64-linux-android/release"
ARMV7_LINUX_ANDROIDEABI="./target/armv7-linux-androideabi/release"
I686_LINUX_ANDROID="./target/i686-linux-android/release"
X86_64_LINUX_ANDROID="./target/x86_64-linux-android/release"

targets=("aarch64-linux-android" "armv7-linux-androideabi" "i686-linux-android" "x86_64-linux-android")

cargo install cross --git https://github.com/cross-rs/cross
# Build for all targets
for target in "${targets[@]}"; do
  echo "Building for $target..."
  rustup toolchain install 1.65.0 --target $target --no-self-update
  cross build --features uffi --target $target 
done

# Generate kotlin wrapper
echo "Generating kotlin wrapper..."
mkdir -p $OUT_PATH
CURRENT_ARCH=$(rustc --version --verbose | grep host | cut -f2 -d' ')
cargo run --features uffi --bin uniffi-bindgen generate uniffi/askar.udl --language kotlin -o $OUT_PATH --lib-file ./target/$CURRENT_ARCH/release/$LIBRARY_NAME
