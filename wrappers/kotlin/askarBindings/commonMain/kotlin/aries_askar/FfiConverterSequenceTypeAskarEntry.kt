package aries_askar

import okio.Buffer

object FfiConverterSequenceTypeAskarEntry: FfiConverterRustBuffer<List<AskarEntry>> {
    override fun read(source: NoCopySource): List<AskarEntry> {
        val len = source.readInt()
        return List<AskarEntry>(len) {
            FfiConverterTypeAskarEntry.read(source)
        }
    }

    override fun allocationSize(value: List<AskarEntry>): Int {
        val sizeForLength = 4
        val sizeForItems = value.map { FfiConverterTypeAskarEntry.allocationSize(it) }.sum()
        return sizeForLength + sizeForItems
    }

    override fun write(value: List<AskarEntry>, buf: Buffer) {
        buf.writeInt(value.size)
        value.forEach {
            FfiConverterTypeAskarEntry.write(it, buf)
        }
    }
}