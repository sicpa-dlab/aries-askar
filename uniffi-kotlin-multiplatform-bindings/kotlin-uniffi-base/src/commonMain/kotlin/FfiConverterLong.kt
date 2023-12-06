import okio.Buffer

object FfiConverterLong : FfiConverter<Long, Long> {
    override fun lift(value: Long): Long = value

    override fun read(source: NoCopySource): Long = source.readLong()

    override fun lower(value: Long): Long = value

    override fun allocationSize(value: Long) = 8

    override fun write(value: Long, buf: Buffer) {
        buf.writeLong(value)
    }
}
