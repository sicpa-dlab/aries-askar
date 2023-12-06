package aries_askar


import okio.Buffer

enum class AskarEntryOperation {
    INSERT,REPLACE,REMOVE;
}

object FfiConverterTypeAskarEntryOperation: FfiConverterRustBuffer<AskarEntryOperation> {
    override fun read(source: NoCopySource) = try {
        AskarEntryOperation.values()[source.readInt() - 1]
    } catch (e: IndexOutOfBoundsException) {
        throw RuntimeException("invalid enum value, something is very wrong!!", e)
    }

    override fun allocationSize(value: AskarEntryOperation) = 4

    override fun write(value: AskarEntryOperation, buf: Buffer) {
        buf.writeInt(value.ordinal + 1)
    }
}

