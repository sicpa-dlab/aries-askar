package aries_askar


import okio.Buffer

interface LocalKeyFactoryInterface {
    
    @Throws(ErrorCode::class)
    fun `generate`(`alg`: AskarKeyAlg, `ephemeral`: Boolean): AskarLocalKey
    
    @Throws(ErrorCode::class)
    fun `fromSeed`(`alg`: AskarKeyAlg, `seed`: List<UByte>, `method`: SeedMethod?): AskarLocalKey
    
    @Throws(ErrorCode::class)
    fun `fromJwkSlice`(`jwk`: List<UByte>): AskarLocalKey
    
    @Throws(ErrorCode::class)
    fun `fromJwk`(`jwk`: String): AskarLocalKey
    
    @Throws(ErrorCode::class)
    fun `fromPublicBytes`(`alg`: AskarKeyAlg, `bytes`: List<UByte>): AskarLocalKey
    
    @Throws(ErrorCode::class)
    fun `fromSecretBytes`(`alg`: AskarKeyAlg, `bytes`: List<UByte>): AskarLocalKey
    
}

class LocalKeyFactory(
    pointer: Pointer
) : FFIObject(pointer), LocalKeyFactoryInterface {
    constructor() :
        this(
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_constructor_localkeyfactory_new( _status)
})

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_localkeyfactory(this.pointer, status)
        }
    }

    
    @Throws(ErrorCode::class)override fun `generate`(`alg`: AskarKeyAlg, `ephemeral`: Boolean): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_localkeyfactory_generate(it, FfiConverterTypeAskarKeyAlg.lower(`alg`), FfiConverterBoolean.lower(`ephemeral`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `fromSeed`(`alg`: AskarKeyAlg, `seed`: List<UByte>, `method`: SeedMethod?): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_localkeyfactory_from_seed(it, FfiConverterTypeAskarKeyAlg.lower(`alg`), FfiConverterSequenceUByte.lower(`seed`), FfiConverterOptionalTypeSeedMethod.lower(`method`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `fromJwkSlice`(`jwk`: List<UByte>): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_localkeyfactory_from_jwk_slice(it, FfiConverterSequenceUByte.lower(`jwk`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `fromJwk`(`jwk`: String): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_localkeyfactory_from_jwk(it, FfiConverterString.lower(`jwk`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `fromPublicBytes`(`alg`: AskarKeyAlg, `bytes`: List<UByte>): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_localkeyfactory_from_public_bytes(it, FfiConverterTypeAskarKeyAlg.lower(`alg`), FfiConverterSequenceUByte.lower(`bytes`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `fromSecretBytes`(`alg`: AskarKeyAlg, `bytes`: List<UByte>): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_localkeyfactory_from_secret_bytes(it, FfiConverterTypeAskarKeyAlg.lower(`alg`), FfiConverterSequenceUByte.lower(`bytes`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    

    
}

object FfiConverterTypeLocalKeyFactory: FfiConverter<LocalKeyFactory, Pointer> {
    override fun lower(value: LocalKeyFactory): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): LocalKeyFactory {
        return LocalKeyFactory(value)
    }

    override fun read(source: NoCopySource): LocalKeyFactory {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: LocalKeyFactory) = 8

    override fun write(value: LocalKeyFactory, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}