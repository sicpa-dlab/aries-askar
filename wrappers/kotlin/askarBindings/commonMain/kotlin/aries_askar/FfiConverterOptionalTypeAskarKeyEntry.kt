package aries_askar

import okio.Buffer

object FfiConverterOptionalTypeAskarKeyEntry: FfiConverterRustBuffer<AskarKeyEntry?> {
    override fun read(source: NoCopySource): AskarKeyEntry? {
        if (source.readByte().toInt() == 0) {
            return null
        }
        return FfiConverterTypeAskarKeyEntry.read(source)
    }

    override fun allocationSize(value: AskarKeyEntry?): Int {
        if (value == null) {
            return 1
        } else {
            return 1 + FfiConverterTypeAskarKeyEntry.allocationSize(value)
        }
    }

    override fun write(value: AskarKeyEntry?, buf: Buffer) {
        if (value == null) {
            buf.writeByte(0)
        } else {
            buf.writeByte(1)
            FfiConverterTypeAskarKeyEntry.write(value, buf)
        }
    }
}