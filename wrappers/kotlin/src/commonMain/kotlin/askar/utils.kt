package askar


    internal fun String.toUbyteList(): List<UByte> {
        return this.map {
            it.code.toUByte()
        }
    }

    internal fun ByteArray.toUbyteList(): List<UByte> {
        return this.map{
            it.toUByte()
        }
    }
