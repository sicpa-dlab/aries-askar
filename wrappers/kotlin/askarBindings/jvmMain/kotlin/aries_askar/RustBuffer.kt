package aries_askar

import com.sun.jna.Structure
import com.sun.jna.ptr.ByReference
import okio.Buffer

@Structure.FieldOrder("capacity", "len", "data")
open class RustBufferStructure : Structure() {
    @JvmField
    var capacity: Int = 0

    @JvmField
    var len: Int = 0

    @JvmField
    var data: Pointer? = null
}

actual class RustBuffer : RustBufferStructure(), Structure.ByValue

actual class RustBufferPointer : ByReference(16) {
    fun setValueInternal(value: RustBuffer) {
        pointer.setInt(0, value.capacity)
        pointer.setInt(4, value.len)
        pointer.setPointer(8, value.data)
    }
}

actual fun RustBuffer.asSource(): NoCopySource = requireNotNull(data).asSource(len.toLong())

actual val RustBuffer.dataSize: Int
    get() = len

actual fun RustBuffer.free() =
    rustCall { status ->
        UniFFILib.ffi_aries_askar_rustbuffer_free(this, status)
    }

actual fun allocRustBuffer(buffer: Buffer): RustBuffer =
    rustCall { status ->
        val size = buffer.size
        UniFFILib.ffi_aries_askar_rustbuffer_alloc(size.toInt(), status).also { rustBuffer: RustBuffer ->
            val data = rustBuffer.data
                ?: throw RuntimeException("RustBuffer.alloc() returned null data pointer (size=${size})")
            rustBuffer.writeField("len", size.toInt())
            buffer.read(data.getByteBuffer(0, size))
        }
    }

actual fun RustBufferPointer.setValue(value: RustBuffer) = setValueInternal(value)

actual fun emptyRustBuffer(): RustBuffer = RustBuffer()