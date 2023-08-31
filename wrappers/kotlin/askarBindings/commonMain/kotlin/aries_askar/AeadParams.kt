package aries_askar


import okio.Buffer

data class AeadParams (
    var `nonceLength`: Int, 
    var `tagLength`: Int
) {
    
}

object FfiConverterTypeAeadParams: FfiConverterRustBuffer<AeadParams> {
    override fun read(source: NoCopySource): AeadParams {
        return AeadParams(
            FfiConverterInt.read(source),
            FfiConverterInt.read(source),
        )
    }

    override fun allocationSize(value: AeadParams) = (
            FfiConverterInt.allocationSize(value.`nonceLength`) +
            FfiConverterInt.allocationSize(value.`tagLength`)
    )

    override fun write(value: AeadParams, buf: Buffer) {
            FfiConverterInt.write(value.`nonceLength`, buf)
            FfiConverterInt.write(value.`tagLength`, buf)
    }
}