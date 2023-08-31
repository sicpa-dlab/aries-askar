package aries_askar

import okio.Buffer

object FfiConverterOptionalLong: FfiConverterRustBuffer<Long?> {
    override fun read(source: NoCopySource): Long? {
        if (source.readByte().toInt() == 0) {
            return null
        }
        return FfiConverterLong.read(source)
    }

    override fun allocationSize(value: Long?): Int {
        if (value == null) {
            return 1
        } else {
            return 1 + FfiConverterLong.allocationSize(value)
        }
    }

    override fun write(value: Long?, buf: Buffer) {
        if (value == null) {
            buf.writeByte(0)
        } else {
            buf.writeByte(1)
            FfiConverterLong.write(value, buf)
        }
    }
}