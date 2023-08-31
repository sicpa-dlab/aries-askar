package aries_askar

import okio.Buffer

object FfiConverterSequenceUByte: FfiConverterRustBuffer<List<UByte>> {
    override fun read(source: NoCopySource): List<UByte> {
        val len = source.readInt()
        return List<UByte>(len) {
            FfiConverterUByte.read(source)
        }
    }

    override fun allocationSize(value: List<UByte>): Int {
        val sizeForLength = 4
        val sizeForItems = value.map { FfiConverterUByte.allocationSize(it) }.sum()
        return sizeForLength + sizeForItems
    }

    override fun write(value: List<UByte>, buf: Buffer) {
        buf.writeInt(value.size)
        value.forEach {
            FfiConverterUByte.write(it, buf)
        }
    }
}