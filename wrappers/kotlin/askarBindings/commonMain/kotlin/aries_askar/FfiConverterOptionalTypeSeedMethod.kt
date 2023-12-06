package aries_askar

import okio.Buffer

object FfiConverterOptionalTypeSeedMethod: FfiConverterRustBuffer<SeedMethod?> {
    override fun read(source: NoCopySource): SeedMethod? {
        if (source.readByte().toInt() == 0) {
            return null
        }
        return FfiConverterTypeSeedMethod.read(source)
    }

    override fun allocationSize(value: SeedMethod?): Int {
        if (value == null) {
            return 1
        } else {
            return 1 + FfiConverterTypeSeedMethod.allocationSize(value)
        }
    }

    override fun write(value: SeedMethod?, buf: Buffer) {
        if (value == null) {
            buf.writeByte(0)
        } else {
            buf.writeByte(1)
            FfiConverterTypeSeedMethod.write(value, buf)
        }
    }
}