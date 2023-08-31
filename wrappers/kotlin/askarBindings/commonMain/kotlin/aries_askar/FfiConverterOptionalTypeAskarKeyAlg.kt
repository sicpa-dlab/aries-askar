package aries_askar

import okio.Buffer

object FfiConverterOptionalTypeAskarKeyAlg: FfiConverterRustBuffer<AskarKeyAlg?> {
    override fun read(source: NoCopySource): AskarKeyAlg? {
        if (source.readByte().toInt() == 0) {
            return null
        }
        return FfiConverterTypeAskarKeyAlg.read(source)
    }

    override fun allocationSize(value: AskarKeyAlg?): Int {
        if (value == null) {
            return 1
        } else {
            return 1 + FfiConverterTypeAskarKeyAlg.allocationSize(value)
        }
    }

    override fun write(value: AskarKeyAlg?, buf: Buffer) {
        if (value == null) {
            buf.writeByte(0)
        } else {
            buf.writeByte(1)
            FfiConverterTypeAskarKeyAlg.write(value, buf)
        }
    }
}