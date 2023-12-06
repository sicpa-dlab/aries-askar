package aries_askar


import okio.Buffer

interface AskarLocalKeyInterface {
    
    @Throws(ErrorCode::class)
    fun `toPublicBytes`(): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `toSecretBytes`(): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `toKeyExchange`(`alg`: AskarKeyAlg, `pk`: AskarLocalKey): AskarLocalKey
    
    fun `algorithm`(): AskarKeyAlg
    
    @Throws(ErrorCode::class)
    fun `toJwkPublic`(`alg`: AskarKeyAlg?): String
    
    @Throws(ErrorCode::class)
    fun `toJwkSecret`(): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `toJwkThumbprint`(`alg`: AskarKeyAlg?): String
    
    @Throws(ErrorCode::class)
    fun `toJwkThumbprints`(): List<String>
    
    @Throws(ErrorCode::class)
    fun `convertKey`(`alg`: AskarKeyAlg): AskarLocalKey
    
    @Throws(ErrorCode::class)
    fun `aeadParams`(): AeadParams
    
    fun `aeadPadding`(`msgLen`: Int): Int
    
    @Throws(ErrorCode::class)
    fun `aeadRandomNonce`(): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `aeadEncrypt`(`message`: List<UByte>, `nonce`: List<UByte>?, `aad`: List<UByte>?): EncryptedBuffer
    
    @Throws(ErrorCode::class)
    fun `aeadDecrypt`(`ciphertext`: List<UByte>, `tag`: List<UByte>?, `nonce`: List<UByte>, `aad`: List<UByte>?): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `signMessage`(`message`: List<UByte>, `sigType`: String?): List<UByte>
    
    @Throws(ErrorCode::class)
    fun `verifySignature`(`message`: List<UByte>, `signature`: List<UByte>, `sigType`: String?): Boolean
    
    @Throws(ErrorCode::class)
    fun `wrapKey`(`key`: AskarLocalKey, `nonce`: List<UByte>?): EncryptedBuffer
    
    @Throws(ErrorCode::class)
    fun `unwrapKey`(`alg`: AskarKeyAlg, `ciphertext`: List<UByte>, `tag`: List<UByte>?, `nonce`: List<UByte>?): AskarLocalKey
    
}

class AskarLocalKey(
    pointer: Pointer
) : FFIObject(pointer), AskarLocalKeyInterface {

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_askarlocalkey(this.pointer, status)
        }
    }

    
    @Throws(ErrorCode::class)override fun `toPublicBytes`(): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_to_public_bytes(it,  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `toSecretBytes`(): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_to_secret_bytes(it,  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `toKeyExchange`(`alg`: AskarKeyAlg, `pk`: AskarLocalKey): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_to_key_exchange(it, FfiConverterTypeAskarKeyAlg.lower(`alg`), FfiConverterTypeAskarLocalKey.lower(`pk`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    override fun `algorithm`(): AskarKeyAlg =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_algorithm(it,  _status)
}
        }.let {
            FfiConverterTypeAskarKeyAlg.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `toJwkPublic`(`alg`: AskarKeyAlg?): String =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_public(it, FfiConverterOptionalTypeAskarKeyAlg.lower(`alg`),  _status)
}
        }.let {
            FfiConverterString.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `toJwkSecret`(): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_secret(it,  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `toJwkThumbprint`(`alg`: AskarKeyAlg?): String =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_thumbprint(it, FfiConverterOptionalTypeAskarKeyAlg.lower(`alg`),  _status)
}
        }.let {
            FfiConverterString.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `toJwkThumbprints`(): List<String> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_thumbprints(it,  _status)
}
        }.let {
            FfiConverterSequenceString.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `convertKey`(`alg`: AskarKeyAlg): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_convert_key(it, FfiConverterTypeAskarKeyAlg.lower(`alg`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `aeadParams`(): AeadParams =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_aead_params(it,  _status)
}
        }.let {
            FfiConverterTypeAeadParams.lift(it)
        }
    
    override fun `aeadPadding`(`msgLen`: Int): Int =
        callWithPointer {
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_aead_padding(it, FfiConverterInt.lower(`msgLen`),  _status)
}
        }.let {
            FfiConverterInt.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `aeadRandomNonce`(): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_aead_random_nonce(it,  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `aeadEncrypt`(`message`: List<UByte>, `nonce`: List<UByte>?, `aad`: List<UByte>?): EncryptedBuffer =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_aead_encrypt(it, FfiConverterSequenceUByte.lower(`message`), FfiConverterOptionalSequenceUByte.lower(`nonce`), FfiConverterOptionalSequenceUByte.lower(`aad`),  _status)
}
        }.let {
            FfiConverterTypeEncryptedBuffer.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `aeadDecrypt`(`ciphertext`: List<UByte>, `tag`: List<UByte>?, `nonce`: List<UByte>, `aad`: List<UByte>?): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_aead_decrypt(it, FfiConverterSequenceUByte.lower(`ciphertext`), FfiConverterOptionalSequenceUByte.lower(`tag`), FfiConverterSequenceUByte.lower(`nonce`), FfiConverterOptionalSequenceUByte.lower(`aad`),  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `signMessage`(`message`: List<UByte>, `sigType`: String?): List<UByte> =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_sign_message(it, FfiConverterSequenceUByte.lower(`message`), FfiConverterOptionalString.lower(`sigType`),  _status)
}
        }.let {
            FfiConverterSequenceUByte.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `verifySignature`(`message`: List<UByte>, `signature`: List<UByte>, `sigType`: String?): Boolean =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_verify_signature(it, FfiConverterSequenceUByte.lower(`message`), FfiConverterSequenceUByte.lower(`signature`), FfiConverterOptionalString.lower(`sigType`),  _status)
}
        }.let {
            FfiConverterBoolean.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `wrapKey`(`key`: AskarLocalKey, `nonce`: List<UByte>?): EncryptedBuffer =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_wrap_key(it, FfiConverterTypeAskarLocalKey.lower(`key`), FfiConverterOptionalSequenceUByte.lower(`nonce`),  _status)
}
        }.let {
            FfiConverterTypeEncryptedBuffer.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `unwrapKey`(`alg`: AskarKeyAlg, `ciphertext`: List<UByte>, `tag`: List<UByte>?, `nonce`: List<UByte>?): AskarLocalKey =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarlocalkey_unwrap_key(it, FfiConverterTypeAskarKeyAlg.lower(`alg`), FfiConverterSequenceUByte.lower(`ciphertext`), FfiConverterOptionalSequenceUByte.lower(`tag`), FfiConverterOptionalSequenceUByte.lower(`nonce`),  _status)
}
        }.let {
            FfiConverterTypeAskarLocalKey.lift(it)
        }
    
    

    
}

object FfiConverterTypeAskarLocalKey: FfiConverter<AskarLocalKey, Pointer> {
    override fun lower(value: AskarLocalKey): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): AskarLocalKey {
        return AskarLocalKey(value)
    }

    override fun read(source: NoCopySource): AskarLocalKey {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: AskarLocalKey) = 8

    override fun write(value: AskarLocalKey, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}