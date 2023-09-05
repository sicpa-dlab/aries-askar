package aries_askar


import okio.Buffer

interface EncryptedBufferInterface {
    
    fun `ciphertext`(): List<UByte>
    
    fun `nonce`(): List<UByte>
    
    fun `tag`(): List<UByte>
    
    fun `ciphertextTag`(): List<UByte>
    
}

class EncryptedBuffer(
    pointer: Pointer
) : FFIObject(pointer), EncryptedBufferInterface {

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_encryptedbuffer(this.pointer, status)
        }
    }

    override fun `ciphertext`(): List<UByte> =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_encryptedbuffer_ciphertext(it,  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    override fun `nonce`(): List<UByte> =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_encryptedbuffer_nonce(it,  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    override fun `tag`(): List<UByte> =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_encryptedbuffer_tag(it,  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    override fun `ciphertextTag`(): List<UByte> =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_encryptedbuffer_ciphertext_tag(it,  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    

    
}

object FfiConverterTypeEncryptedBuffer: FfiConverter<EncryptedBuffer, Pointer> {
    override fun lower(value: EncryptedBuffer): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): EncryptedBuffer {
        return EncryptedBuffer(value)
    }

    override fun read(source: NoCopySource): EncryptedBuffer {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: EncryptedBuffer) = 8

    override fun write(value: EncryptedBuffer, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}