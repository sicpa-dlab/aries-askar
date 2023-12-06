package aries_askar

import okio.Buffer

object FfiConverterOptionalTypeAskarEntry: FfiConverterRustBuffer<AskarEntry?> {
    override fun read(source: NoCopySource): AskarEntry? {
        if (source.readByte().toInt() == 0) {
            return null
        }
        return FfiConverterTypeAskarEntry.read(source)
    }

    override fun allocationSize(value: AskarEntry?): Int {
        if (value == null) {
            return 1
        } else {
            return 1 + FfiConverterTypeAskarEntry.allocationSize(value)
        }
    }

    override fun write(value: AskarEntry?, buf: Buffer) {
        if (value == null) {
            buf.writeByte(0)
        } else {
            buf.writeByte(1)
            FfiConverterTypeAskarEntry.write(value, buf)
        }
    }
}