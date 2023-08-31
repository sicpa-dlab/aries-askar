package aries_askar

import okio.Buffer

object FfiConverterSequenceString: FfiConverterRustBuffer<List<String>> {
    override fun read(source: NoCopySource): List<String> {
        val len = source.readInt()
        return List<String>(len) {
            FfiConverterString.read(source)
        }
    }

    override fun allocationSize(value: List<String>): Int {
        val sizeForLength = 4
        val sizeForItems = value.map { FfiConverterString.allocationSize(it) }.sum()
        return sizeForLength + sizeForItems
    }

    override fun write(value: List<String>, buf: Buffer) {
        buf.writeInt(value.size)
        value.forEach {
            FfiConverterString.write(it, buf)
        }
    }
}