package aries_askar

import okio.Buffer

object FfiConverterOptionalSequenceTypeAskarEntry: FfiConverterRustBuffer<List<AskarEntry>?> {
    override fun read(source: NoCopySource): List<AskarEntry>? {
        if (source.readByte().toInt() == 0) {
            return null
        }
        return FfiConverterSequenceTypeAskarEntry.read(source)
    }

    override fun allocationSize(value: List<AskarEntry>?): Int {
        if (value == null) {
            return 1
        } else {
            return 1 + FfiConverterSequenceTypeAskarEntry.allocationSize(value)
        }
    }

    override fun write(value: List<AskarEntry>?, buf: Buffer) {
        if (value == null) {
            buf.writeByte(0)
        } else {
            buf.writeByte(1)
            FfiConverterSequenceTypeAskarEntry.write(value, buf)
        }
    }
}