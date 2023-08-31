package aries_askar


import kotlinx.coroutines.coroutineScope
import okio.Buffer
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface AskarEcdh1PuInterface {
    
    @Throws(ErrorCode::class)
    fun `deriveKey`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `ccTag`: List<UByte>, `receive`: Boolean): AskarLocalKey
    
    @Throws(ErrorCode::class)
    fun `encryptDirect`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `message`: List<UByte>, `nonce`: List<UByte>?, `aad`: List<UByte>?): EncryptedBuffer
    
    @Throws(ErrorCode::class)
    fun `decryptDirect`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `ciphertext`: List<UByte>, `tag`: List<UByte>?, `nonce`: List<UByte>, `aad`: List<UByte>?): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `senderWrapKey`(`wrapAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `cek`: AskarLocalKey, `ccTag`: List<UByte>): EncryptedBuffer
    
    @Throws(ErrorCode::class)
    fun `receiverUnwrapKey`(`wrapAlg`: AskarKeyAlg, `encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `ciphertext`: List<UByte>, `ccTag`: List<UByte>, `nonce`: List<UByte>?, `tag`: List<UByte>?): AskarLocalKey
    
}

class AskarEcdh1Pu(
    pointer: Pointer
) : FFIObject(pointer), AskarEcdh1PuInterface {
    constructor(`algId`: String, `apu`: String, `apv`: String) :
        this(
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_constructor_askarecdh1pu_new(FfiConverterString.lower(`algId`), FfiConverterString.lower(`apu`), FfiConverterString.lower(`apv`), _status)
})

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_askarecdh1pu(this.pointer, status)
        }
    }

    
    @Throws(ErrorCode::class)override fun `deriveKey`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `ccTag`: List<UByte>, `receive`: Boolean): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarecdh1pu_derive_key(it, FfiConverterTypeAskarKeyAlg.lower(`encAlg`), FfiConverterTypeAskarLocalKey.lower(`ephemeralKey`), FfiConverterTypeAskarLocalKey.lower(`senderKey`), FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterSequenceUByte.lower(`ccTag`), FfiConverterBoolean.lower(`receive`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `encryptDirect`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `message`: List<UByte>, `nonce`: List<UByte>?, `aad`: List<UByte>?): EncryptedBuffer =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarecdh1pu_encrypt_direct(it, FfiConverterTypeAskarKeyAlg.lower(`encAlg`), FfiConverterTypeAskarLocalKey.lower(`ephemeralKey`), FfiConverterTypeAskarLocalKey.lower(`senderKey`), FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterSequenceUByte.lower(`message`), FfiConverterOptionalSequenceUByte.lower(`nonce`), FfiConverterOptionalSequenceUByte.lower(`aad`),  _status)
}
        }.let {
            FfiConverterTypeEncryptedBuffer.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `decryptDirect`(`encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `ciphertext`: List<UByte>, `tag`: List<UByte>?, `nonce`: List<UByte>, `aad`: List<UByte>?): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarecdh1pu_decrypt_direct(it, FfiConverterTypeAskarKeyAlg.lower(`encAlg`), FfiConverterTypeAskarLocalKey.lower(`ephemeralKey`), FfiConverterTypeAskarLocalKey.lower(`senderKey`), FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterSequenceUByte.lower(`ciphertext`), FfiConverterOptionalSequenceUByte.lower(`tag`), FfiConverterSequenceUByte.lower(`nonce`), FfiConverterOptionalSequenceUByte.lower(`aad`),  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `senderWrapKey`(`wrapAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `cek`: AskarLocalKey, `ccTag`: List<UByte>): EncryptedBuffer =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarecdh1pu_sender_wrap_key(it, FfiConverterTypeAskarKeyAlg.lower(`wrapAlg`), FfiConverterTypeAskarLocalKey.lower(`ephemeralKey`), FfiConverterTypeAskarLocalKey.lower(`senderKey`), FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterTypeAskarLocalKey.lower(`cek`), FfiConverterSequenceUByte.lower(`ccTag`),  _status)
}
        }.let {
            FfiConverterTypeEncryptedBuffer.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `receiverUnwrapKey`(`wrapAlg`: AskarKeyAlg, `encAlg`: AskarKeyAlg, `ephemeralKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `receiverKey`: AskarLocalKey, `ciphertext`: List<UByte>, `ccTag`: List<UByte>, `nonce`: List<UByte>?, `tag`: List<UByte>?): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarecdh1pu_receiver_unwrap_key(it, FfiConverterTypeAskarKeyAlg.lower(`wrapAlg`), FfiConverterTypeAskarKeyAlg.lower(`encAlg`), FfiConverterTypeAskarLocalKey.lower(`ephemeralKey`), FfiConverterTypeAskarLocalKey.lower(`senderKey`), FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterSequenceUByte.lower(`ciphertext`), FfiConverterSequenceUByte.lower(`ccTag`), FfiConverterOptionalSequenceUByte.lower(`nonce`), FfiConverterOptionalSequenceUByte.lower(`tag`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    

    
}

object FfiConverterTypeAskarEcdh1Pu: FfiConverter<AskarEcdh1Pu, Pointer> {
    override fun lower(value: AskarEcdh1Pu): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): AskarEcdh1Pu {
        return AskarEcdh1Pu(value)
    }

    override fun read(source: NoCopySource): AskarEcdh1Pu {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: AskarEcdh1Pu) = 8

    override fun write(value: AskarEcdh1Pu, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}