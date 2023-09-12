package aries_askar


import okio.Buffer

interface AskarEntryInterface {

    fun `category`(): String

    fun `name`(): String

    fun `tags`(): Map<String, String>

    fun `value`(): List<UByte>

}

class AskarEntry(
    pointer: Pointer
) : FFIObject(pointer), AskarEntryInterface {

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_askarentry(this.pointer, status)
        }
    }

    override fun `category`(): String =
        callWithPointer {
            rustCall() { _status ->
                UniFFILib.uniffi_aries_askar_fn_method_askarentry_category(it, _status)
            }
        }.let {
            FfiConverterString.lift(it)
        }

    override fun `name`(): String =
        callWithPointer {
            rustCall() { _status ->
                UniFFILib.uniffi_aries_askar_fn_method_askarentry_name(it, _status)
            }
        }.let {
            FfiConverterString.lift(it)
        }

    override fun `tags`(): Map<String, String> =
        callWithPointer {
            rustCall() { _status ->
                UniFFILib.uniffi_aries_askar_fn_method_askarentry_tags(it, _status)
            }
        }.let {
            FfiConverterMapStringString.lift(it)
        }

    override fun `value`(): List<UByte> =
        callWithPointer {
            rustCall() { _status ->
                UniFFILib.uniffi_aries_askar_fn_method_askarentry_value(it, _status)
            }
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }


}

object FfiConverterTypeAskarEntry : FfiConverter<AskarEntry, Pointer> {
    override fun lower(value: AskarEntry): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): AskarEntry {
        return AskarEntry(value)
    }

    override fun read(source: NoCopySource): AskarEntry {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: AskarEntry) = 8

    override fun write(value: AskarEntry, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}