package aries_askar

import okio.Buffer
object FfiConverterMapStringString: FfiConverterRustBuffer<Map<String, String>> {
    override fun read(source: NoCopySource): Map<String, String> {
        val items : MutableMap<String, String> = mutableMapOf()
        val len = source.readInt()
        repeat(len) {
            val k = FfiConverterString.read(source)
            val v = FfiConverterString.read(source)
            items[k] = v
        }
        return items
    }

    override fun allocationSize(value: Map<String, String>): Int {
        val spaceForMapSize = 4
        val spaceForChildren = value.map { (k, v) ->
            FfiConverterString.allocationSize(k) +
            FfiConverterString.allocationSize(v)
        }.sum()
        return spaceForMapSize + spaceForChildren
    }

    override fun write(value: Map<String, String>, buf: Buffer) {
        buf.writeInt(value.size)
        value.forEach { (k, v) ->
            FfiConverterString.write(k, buf)
            FfiConverterString.write(v, buf)
        }
    }
}