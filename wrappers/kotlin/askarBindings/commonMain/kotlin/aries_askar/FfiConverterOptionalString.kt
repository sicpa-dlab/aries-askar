package aries_askar

import okio.Buffer

object FfiConverterOptionalString: FfiConverterRustBuffer<String?> {
    override fun read(source: NoCopySource): String? {
        if (source.readByte().toInt() == 0) {
            return null
        }
        return FfiConverterString.read(source)
    }

    override fun allocationSize(value: String?): Int {
        if (value == null) {
            return 1
        } else {
            return 1 + FfiConverterString.allocationSize(value)
        }
    }

    override fun write(value: String?, buf: Buffer) {
        if (value == null) {
            buf.writeByte(0)
        } else {
            buf.writeByte(1)
            FfiConverterString.write(value, buf)
        }
    }
}