package aries_askar


import kotlinx.coroutines.coroutineScope
import okio.Buffer
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface AskarKeyEntryInterface {
    
    fun `algorithm`(): String?
    
    fun `metadata`(): String?
    
    fun `name`(): String
    
    fun `isLocal`(): Boolean
    
    fun `tags`(): Map<String, String>
    
    @Throws(ErrorCode::class)
    fun `loadLocalKey`(): AskarLocalKey
    
}

class AskarKeyEntry(
    pointer: Pointer
) : FFIObject(pointer), AskarKeyEntryInterface {

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_askarkeyentry(this.pointer, status)
        }
    }

    override fun `algorithm`(): String? =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarkeyentry_algorithm(it,  _status)
}
        }.let {
            FfiConverterOptionalString.lift(it)
        }
    
    override fun `metadata`(): String? =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarkeyentry_metadata(it,  _status)
}
        }.let {
            FfiConverterOptionalString.lift(it)
        }
    
    override fun `name`(): String =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarkeyentry_name(it,  _status)
}
        }.let {
            FfiConverterString.lift(it)
        }
    
    override fun `isLocal`(): Boolean =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarkeyentry_is_local(it,  _status)
}
        }.let {
            FfiConverterBoolean.lift(it)
        }
    
    override fun `tags`(): Map<String, String> =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarkeyentry_tags(it,  _status)
}
        }.let {
            FfiConverterMapStringString.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `loadLocalKey`(): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarkeyentry_load_local_key(it,  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    

    
}

object FfiConverterTypeAskarKeyEntry: FfiConverter<AskarKeyEntry, Pointer> {
    override fun lower(value: AskarKeyEntry): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): AskarKeyEntry {
        return AskarKeyEntry(value)
    }

    override fun read(source: NoCopySource): AskarKeyEntry {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: AskarKeyEntry) = 8

    override fun write(value: AskarKeyEntry, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}