package aries_askar

import okio.Buffer

object FfiConverterSequenceTypeAskarKeyEntry: FfiConverterRustBuffer<List<AskarKeyEntry>> {
    override fun read(source: NoCopySource): List<AskarKeyEntry> {
        val len = source.readInt()
        return List<AskarKeyEntry>(len) {
            FfiConverterTypeAskarKeyEntry.read(source)
        }
    }

    override fun allocationSize(value: List<AskarKeyEntry>): Int {
        val sizeForLength = 4
        val sizeForItems = value.map { FfiConverterTypeAskarKeyEntry.allocationSize(it) }.sum()
        return sizeForLength + sizeForItems
    }

    override fun write(value: List<AskarKeyEntry>, buf: Buffer) {
        buf.writeInt(value.size)
        value.forEach {
            FfiConverterTypeAskarKeyEntry.write(it, buf)
        }
    }
}