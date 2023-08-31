package aries_askar


import kotlinx.coroutines.coroutineScope
import okio.Buffer
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface AskarCryptoInterface {
    
    @Throws(ErrorCode::class)
    fun `randomNonce`(): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `cryptoBox`(`receiverKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `message`: List<UByte>, `nonce`: List<UByte>): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `boxOpen`(`receiverKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `message`: List<UByte>, `nonce`: List<UByte>): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `boxSeal`(`receiverKey`: AskarLocalKey, `message`: List<UByte>): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `boxSealOpen`(`receiverKey`: AskarLocalKey, `ciphertext`: List<UByte>): List<UByte>
    
}

class AskarCrypto(
    pointer: Pointer
) : FFIObject(pointer), AskarCryptoInterface {
    constructor() :
        this(
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_constructor_askarcrypto_new( _status)
})

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_askarcrypto(this.pointer, status)
        }
    }

    
    @Throws(ErrorCode::class)override fun `randomNonce`(): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarcrypto_random_nonce(it,  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `cryptoBox`(`receiverKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `message`: List<UByte>, `nonce`: List<UByte>): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarcrypto_crypto_box(it, FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterTypeAskarLocalKey.lower(`senderKey`), FfiConverterSequenceUByte.lower(`message`), FfiConverterSequenceUByte.lower(`nonce`),  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `boxOpen`(`receiverKey`: AskarLocalKey, `senderKey`: AskarLocalKey, `message`: List<UByte>, `nonce`: List<UByte>): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarcrypto_box_open(it, FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterTypeAskarLocalKey.lower(`senderKey`), FfiConverterSequenceUByte.lower(`message`), FfiConverterSequenceUByte.lower(`nonce`),  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `boxSeal`(`receiverKey`: AskarLocalKey, `message`: List<UByte>): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarcrypto_box_seal(it, FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterSequenceUByte.lower(`message`),  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `boxSealOpen`(`receiverKey`: AskarLocalKey, `ciphertext`: List<UByte>): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarcrypto_box_seal_open(it, FfiConverterTypeAskarLocalKey.lower(`receiverKey`), FfiConverterSequenceUByte.lower(`ciphertext`),  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    

    
}

object FfiConverterTypeAskarCrypto: FfiConverter<AskarCrypto, Pointer> {
    override fun lower(value: AskarCrypto): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): AskarCrypto {
        return AskarCrypto(value)
    }

    override fun read(source: NoCopySource): AskarCrypto {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: AskarCrypto) = 8

    override fun write(value: AskarCrypto, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}