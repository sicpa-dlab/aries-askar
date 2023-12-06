package aries_askar


import okio.Buffer

enum class AskarKeyAlg {
    A128_GCM,A256_GCM,A128_CBC_HS256,A256_CBC_HS512,A128_KW,A256_KW,BLS12_381G1,BLS12_381G2,BLS12_381G1G2,C20P,XC20P,ED25519,X25519,K256,P256,P384;
}

object FfiConverterTypeAskarKeyAlg: FfiConverterRustBuffer<AskarKeyAlg> {
    override fun read(source: NoCopySource) = try {
        AskarKeyAlg.values()[source.readInt() - 1]
    } catch (e: IndexOutOfBoundsException) {
        throw RuntimeException("invalid enum value, something is very wrong!!", e)
    }

    override fun allocationSize(value: AskarKeyAlg) = 4

    override fun write(value: AskarKeyAlg, buf: Buffer) {
        buf.writeInt(value.ordinal + 1)
    }
}

