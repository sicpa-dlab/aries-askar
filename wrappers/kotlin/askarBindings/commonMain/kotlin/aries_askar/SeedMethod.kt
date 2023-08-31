package aries_askar


import okio.Buffer

enum class SeedMethod {
    BLS_KEY_GEN;
}

object FfiConverterTypeSeedMethod: FfiConverterRustBuffer<SeedMethod> {
    override fun read(source: NoCopySource) = try {
        SeedMethod.values()[source.readInt() - 1]
    } catch (e: IndexOutOfBoundsException) {
        throw RuntimeException("invalid enum value, something is very wrong!!", e)
    }

    override fun allocationSize(value: SeedMethod) = 4

    override fun write(value: SeedMethod, buf: Buffer) {
        buf.writeInt(value.ordinal + 1)
    }
}

