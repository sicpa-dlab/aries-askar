package aries_askar


import kotlinx.coroutines.coroutineScope
import okio.Buffer
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface AskarEcdhEsInterface {
    
    @Throws(ErrorCode::class)
    fun `deriveKey`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `receive`: Boolean): AskarLocalKey
    
    @Throws(ErrorCode::class)
    fun `encryptDirect`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `message`: List<UByte>, `nonce`: List<UByte>?, `aad`: List<UByte>?): EncryptedBuffer
    
    @Throws(ErrorCode::class)
    fun `decryptDirect`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `ciphertext`: List<UByte>, `tag`: List<UByte>?, `nonce`: List<UByte>, `aad`: List<UByte>?): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `senderWrapKey`(`wrapAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `cek`: AskarLocalKey): EncryptedBuffer
    
    @Throws(ErrorCode::class)
    fun `receiverUnwrapKey`(`wrapAlg`: AskarKeyAlg, `encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `ciphertext`: List<UByte>, `nonce`: List<UByte>?, `tag`: List<UByte>?): AskarLocalKey
    
}

class AskarEcdhEs(
    pointer: Pointer
) : FFIObject(pointer), AskarEcdhEsInterface {
    constructor(`algId`: String, `apu`: String, `apv`: String) :
        this(
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_constructor_askarecdhes_new(FfiConverterString.lower(`algId`), FfiConverterString.lower(`apu`), FfiConverterString.lower(`apv`), _status)
})

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_askarecdhes(this.pointer, status)
        }
    }

    
    @Throws(ErrorCode::class)override fun `deriveKey`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `receive`: Boolean): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarecdhes_derive_key(it, FfiConverterTypeAskarKeyAlg.lower(`encAlg`), FfiConverterTypeAskarLocalKey.lower(`ephemeralKey`), FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterBoolean.lower(`receive`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `encryptDirect`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `message`: List<UByte>, `nonce`: List<UByte>?, `aad`: List<UByte>?): EncryptedBuffer =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarecdhes_encrypt_direct(it, FfiConverterTypeAskarKeyAlg.lower(`encAlg`), FfiConverterTypeAskarLocalKey.lower(`ephemeralKey`), FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterSequenceUByte.lower(`message`), FfiConverterOptionalSequenceUByte.lower(`nonce`), FfiConverterOptionalSequenceUByte.lower(`aad`),  _status)
}
        }.let {
            FfiConverterTypeEncryptedBuffer.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `decryptDirect`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `ciphertext`: List<UByte>, `tag`: List<UByte>?, `nonce`: List<UByte>, `aad`: List<UByte>?): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarecdhes_decrypt_direct(it, FfiConverterTypeAskarKeyAlg.lower(`encAlg`), FfiConverterTypeAskarLocalKey.lower(`ephemeralKey`), FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterSequenceUByte.lower(`ciphertext`), FfiConverterOptionalSequenceUByte.lower(`tag`), FfiConverterSequenceUByte.lower(`nonce`), FfiConverterOptionalSequenceUByte.lower(`aad`),  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `senderWrapKey`(`wrapAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `cek`: AskarLocalKey): EncryptedBuffer =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarecdhes_sender_wrap_key(it, FfiConverterTypeAskarKeyAlg.lower(`wrapAlg`), FfiConverterTypeAskarLocalKey.lower(`ephemeralKey`), FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterTypeAskarLocalKey.lower(`cek`),  _status)
}
        }.let {
            FfiConverterTypeEncryptedBuffer.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `receiverUnwrapKey`(`wrapAlg`: AskarKeyAlg, `encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `ciphertext`: List<UByte>, `nonce`: List<UByte>?, `tag`: List<UByte>?): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarecdhes_receiver_unwrap_key(it, FfiConverterTypeAskarKeyAlg.lower(`wrapAlg`), FfiConverterTypeAskarKeyAlg.lower(`encAlg`), FfiConverterTypeAskarLocalKey.lower(`ephemeralKey`), FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterSequenceUByte.lower(`ciphertext`), FfiConverterOptionalSequenceUByte.lower(`nonce`), FfiConverterOptionalSequenceUByte.lower(`tag`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    

    
}

object FfiConverterTypeAskarEcdhEs: FfiConverter<AskarEcdhEs, Pointer> {
    override fun lower(value: AskarEcdhEs): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): AskarEcdhEs {
        return AskarEcdhEs(value)
    }

    override fun read(source: NoCopySource): AskarEcdhEs {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: AskarEcdhEs) = 8

    override fun write(value: AskarEcdhEs, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}