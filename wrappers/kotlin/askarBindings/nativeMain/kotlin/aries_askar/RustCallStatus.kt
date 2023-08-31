package aries_askar

import kotlinx.cinterop.*

// TODO remove suppress when https://youtrack.jetbrains.com/issue/KT-29819/New-rules-for-expect-actual-declarations-in-MPP is solved
@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias RustCallStatus = CPointer<aries_askar.cinterop.RustCallStatus>

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias RustCallStatusByValue = CValue<aries_askar.cinterop.RustCallStatus>

actual val RustCallStatus.statusCode: Byte
    get() = pointed.code
actual val RustCallStatus.errorBuffer: RustBuffer
    get() = pointed.errorBuf.readValue()

actual fun <T> withRustCallStatus(block: (RustCallStatus) -> T): T =
    memScoped {
        val allocated = alloc<aries_askar.cinterop.RustCallStatus>().ptr
        block(allocated)
    }

val RustCallStatusByValue.statusCode: Byte
    get() = useContents { code }