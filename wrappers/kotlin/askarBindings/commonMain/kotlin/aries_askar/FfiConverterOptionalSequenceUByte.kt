package aries_askar

import okio.Buffer

object FfiConverterOptionalSequenceUByte: FfiConverterRustBuffer<List<UByte>?> {
    override fun read(source: NoCopySource): List<UByte>? {
        if (source.readByte().toInt() == 0) {
            return null
        }
        return FfiConverterSequenceUByte.read(source)
    }

    override fun allocationSize(value: List<UByte>?): Int {
        if (value == null) {
            return 1
        } else {
            return 1 + FfiConverterSequenceUByte.allocationSize(value)
        }
    }

    override fun write(value: List<UByte>?, buf: Buffer) {
        if (value == null) {
            buf.writeByte(0)
        } else {
            buf.writeByte(1)
            FfiConverterSequenceUByte.write(value, buf)
        }
    }
}