package aries_askar



actual object UniFFILib {
    init {
        FfiConverterForeignExecutor.register(this)
        
    }

    actual fun uniffi_aries_askar_fn_free_askarentry(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_askarentry(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarentry_category(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarentry_category(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarentry_name(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarentry_name(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarentry_tags(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarentry_tags(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarentry_value(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarentry_value(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_askarkeyentry(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_askarkeyentry(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarkeyentry_algorithm(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarkeyentry_algorithm(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarkeyentry_metadata(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarkeyentry_metadata(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarkeyentry_name(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarkeyentry_name(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarkeyentry_is_local(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Byte =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarkeyentry_is_local(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarkeyentry_tags(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarkeyentry_tags(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarkeyentry_load_local_key(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarkeyentry_load_local_key(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_askarscan(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_askarscan(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarscan_next(`ptr`: Pointer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarscan_next(`ptr`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarscan_fetch_all(`ptr`: Pointer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarscan_fetch_all(`ptr`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_askarsession(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_askarsession(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_close(`ptr`: Pointer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_close(`ptr`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_count(`ptr`: Pointer,`category`: RustBuffer,`tagFilter`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackInt64,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_count(`ptr`,`category`,`tagFilter`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_fetch(`ptr`: Pointer,`category`: RustBuffer,`name`: RustBuffer,`forUpdate`: Byte,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_fetch(`ptr`,`category`,`name`,`forUpdate`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_fetch_all(`ptr`: Pointer,`category`: RustBuffer,`tagFilter`: RustBuffer,`limit`: RustBuffer,`forUpdate`: Byte,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_fetch_all(`ptr`,`category`,`tagFilter`,`limit`,`forUpdate`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_update(`ptr`: Pointer,`operation`: RustBuffer,`category`: RustBuffer,`name`: RustBuffer,`value`: RustBuffer,`tags`: RustBuffer,`expiryMs`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_update(`ptr`,`operation`,`category`,`name`,`value`,`tags`,`expiryMs`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_remove_all(`ptr`: Pointer,`category`: RustBuffer,`tagFilter`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackInt64,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_remove_all(`ptr`,`category`,`tagFilter`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_insert_key(`ptr`: Pointer,`name`: RustBuffer,`key`: Pointer,`metadata`: RustBuffer,`tags`: RustBuffer,`expiryMs`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_insert_key(`ptr`,`name`,`key`,`metadata`,`tags`,`expiryMs`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_fetch_key(`ptr`: Pointer,`name`: RustBuffer,`forUpdate`: Byte,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_fetch_key(`ptr`,`name`,`forUpdate`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_fetch_all_keys(`ptr`: Pointer,`algorithm`: RustBuffer,`thumbprint`: RustBuffer,`tagFilter`: RustBuffer,`limit`: RustBuffer,`forUpdate`: Byte,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_fetch_all_keys(`ptr`,`algorithm`,`thumbprint`,`tagFilter`,`limit`,`forUpdate`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_remove_key(`ptr`: Pointer,`name`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_remove_key(`ptr`,`name`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarsession_update_key(`ptr`: Pointer,`name`: RustBuffer,`metadata`: RustBuffer,`tags`: RustBuffer,`expiryMs`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarsession_update_key(`ptr`,`name`,`metadata`,`tags`,`expiryMs`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_askarstore(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_askarstore(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstore_get_profile_name(`ptr`: Pointer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstore_get_profile_name(`ptr`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstore_create_profile(`ptr`: Pointer,`profile`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstore_create_profile(`ptr`,`profile`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstore_remove_profile(`ptr`: Pointer,`profile`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstore_remove_profile(`ptr`,`profile`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstore_rekey(`ptr`: Pointer,`keyMethod`: RustBuffer,`passKey`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstore_rekey(`ptr`,`keyMethod`,`passKey`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstore_close(`ptr`: Pointer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstore_close(`ptr`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstore_scan(`ptr`: Pointer,`profile`: RustBuffer,`categogy`: RustBuffer,`tagFilter`: RustBuffer,`offset`: RustBuffer,`limit`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustArcPtrAskarScan,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstore_scan(`ptr`,`profile`,`categogy`,`tagFilter`,`offset`,`limit`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstore_session(`ptr`: Pointer,`profile`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustArcPtrAskarSession,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstore_session(`ptr`,`profile`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_askarlocalkey(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_askarlocalkey(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_to_public_bytes(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_to_public_bytes(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_to_secret_bytes(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_to_secret_bytes(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_to_key_exchange(`ptr`: Pointer,`alg`: RustBuffer,`pk`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_to_key_exchange(`ptr`,`alg`,`pk`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_algorithm(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_algorithm(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_public(`ptr`: Pointer,`alg`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_public(`ptr`,`alg`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_secret(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_secret(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_thumbprint(`ptr`: Pointer,`alg`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_thumbprint(`ptr`,`alg`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_thumbprints(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_thumbprints(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_convert_key(`ptr`: Pointer,`alg`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_convert_key(`ptr`,`alg`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_aead_params(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_aead_params(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_aead_padding(`ptr`: Pointer,`msgLen`: Int,_uniffi_out_err: RustCallStatus, 
    ): Int =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_aead_padding(`ptr`,`msgLen`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_aead_random_nonce(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_aead_random_nonce(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_aead_encrypt(`ptr`: Pointer,`message`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_aead_encrypt(`ptr`,`message`,`nonce`,`aad`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_aead_decrypt(`ptr`: Pointer,`ciphertext`: RustBuffer,`tag`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_aead_decrypt(`ptr`,`ciphertext`,`tag`,`nonce`,`aad`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_sign_message(`ptr`: Pointer,`message`: RustBuffer,`sigType`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_sign_message(`ptr`,`message`,`sigType`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_verify_signature(`ptr`: Pointer,`message`: RustBuffer,`signature`: RustBuffer,`sigType`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Byte =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_verify_signature(`ptr`,`message`,`signature`,`sigType`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_wrap_key(`ptr`: Pointer,`key`: Pointer,`nonce`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_wrap_key(`ptr`,`key`,`nonce`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarlocalkey_unwrap_key(`ptr`: Pointer,`alg`: RustBuffer,`ciphertext`: RustBuffer,`tag`: RustBuffer,`nonce`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarlocalkey_unwrap_key(`ptr`,`alg`,`ciphertext`,`tag`,`nonce`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_encryptedbuffer(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_encryptedbuffer(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_encryptedbuffer_ciphertext(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_encryptedbuffer_ciphertext(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_encryptedbuffer_nonce(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_encryptedbuffer_nonce(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_encryptedbuffer_tag(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_encryptedbuffer_tag(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_encryptedbuffer_ciphertext_tag(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_encryptedbuffer_ciphertext_tag(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_localkeyfactory(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_localkeyfactory(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_constructor_localkeyfactory_new(_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_constructor_localkeyfactory_new(_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_localkeyfactory_generate(`ptr`: Pointer,`alg`: RustBuffer,`ephemeral`: Byte,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_localkeyfactory_generate(`ptr`,`alg`,`ephemeral`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_localkeyfactory_from_seed(`ptr`: Pointer,`alg`: RustBuffer,`seed`: RustBuffer,`method`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_localkeyfactory_from_seed(`ptr`,`alg`,`seed`,`method`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_localkeyfactory_from_jwk_slice(`ptr`: Pointer,`jwk`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_localkeyfactory_from_jwk_slice(`ptr`,`jwk`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_localkeyfactory_from_jwk(`ptr`: Pointer,`jwk`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_localkeyfactory_from_jwk(`ptr`,`jwk`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_localkeyfactory_from_public_bytes(`ptr`: Pointer,`alg`: RustBuffer,`bytes`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_localkeyfactory_from_public_bytes(`ptr`,`alg`,`bytes`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_localkeyfactory_from_secret_bytes(`ptr`: Pointer,`alg`: RustBuffer,`bytes`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_localkeyfactory_from_secret_bytes(`ptr`,`alg`,`bytes`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_askarstoremanager(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_askarstoremanager(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_constructor_askarstoremanager_new(_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_constructor_askarstoremanager_new(_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstoremanager_generate_raw_store_key(`ptr`: Pointer,`seed`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstoremanager_generate_raw_store_key(`ptr`,`seed`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstoremanager_set_default_logger(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstoremanager_set_default_logger(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstoremanager_provision(`ptr`: Pointer,`specUri`: RustBuffer,`keyMethod`: RustBuffer,`passKey`: RustBuffer,`profile`: RustBuffer,`recreate`: Byte,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustArcPtrAskarStore,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstoremanager_provision(`ptr`,`specUri`,`keyMethod`,`passKey`,`profile`,`recreate`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstoremanager_open(`ptr`: Pointer,`specUri`: RustBuffer,`keyMethod`: RustBuffer,`passKey`: RustBuffer,`profile`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustArcPtrAskarStore,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstoremanager_open(`ptr`,`specUri`,`keyMethod`,`passKey`,`profile`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarstoremanager_remove(`ptr`: Pointer,`specUri`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarstoremanager_remove(`ptr`,`specUri`,`uniffiExecutor`,`uniffiCallback`,`uniffiCallbackData`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_askarcrypto(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_askarcrypto(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_constructor_askarcrypto_new(_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_constructor_askarcrypto_new(_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarcrypto_random_nonce(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarcrypto_random_nonce(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarcrypto_crypto_box(`ptr`: Pointer,`receiverKey`: Pointer,`senderKey`: Pointer,`message`: RustBuffer,`nonce`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarcrypto_crypto_box(`ptr`,`receiverKey`,`senderKey`,`message`,`nonce`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarcrypto_box_open(`ptr`: Pointer,`receiverKey`: Pointer,`senderKey`: Pointer,`message`: RustBuffer,`nonce`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarcrypto_box_open(`ptr`,`receiverKey`,`senderKey`,`message`,`nonce`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarcrypto_box_seal(`ptr`: Pointer,`receiverKey`: Pointer,`message`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarcrypto_box_seal(`ptr`,`receiverKey`,`message`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarcrypto_box_seal_open(`ptr`: Pointer,`receiverKey`: Pointer,`ciphertext`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarcrypto_box_seal_open(`ptr`,`receiverKey`,`ciphertext`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_askarecdhes(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_askarecdhes(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_constructor_askarecdhes_new(`algId`: RustBuffer,`apu`: RustBuffer,`apv`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_constructor_askarecdhes_new(`algId`,`apu`,`apv`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarecdhes_derive_key(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`receiverKey`: Pointer,`receive`: Byte,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarecdhes_derive_key(`ptr`,`encAlg`,`ephemeralKey`,`receiverKey`,`receive`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarecdhes_encrypt_direct(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`receiverKey`: Pointer,`message`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarecdhes_encrypt_direct(`ptr`,`encAlg`,`ephemeralKey`,`receiverKey`,`message`,`nonce`,`aad`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarecdhes_decrypt_direct(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`receiverKey`: Pointer,`ciphertext`: RustBuffer,`tag`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarecdhes_decrypt_direct(`ptr`,`encAlg`,`ephemeralKey`,`receiverKey`,`ciphertext`,`tag`,`nonce`,`aad`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarecdhes_sender_wrap_key(`ptr`: Pointer,`wrapAlg`: RustBuffer,`ephemeralKey`: Pointer,`receiverKey`: Pointer,`cek`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarecdhes_sender_wrap_key(`ptr`,`wrapAlg`,`ephemeralKey`,`receiverKey`,`cek`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarecdhes_receiver_unwrap_key(`ptr`: Pointer,`wrapAlg`: RustBuffer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`receiverKey`: Pointer,`ciphertext`: RustBuffer,`nonce`: RustBuffer,`tag`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarecdhes_receiver_unwrap_key(`ptr`,`wrapAlg`,`encAlg`,`ephemeralKey`,`receiverKey`,`ciphertext`,`nonce`,`tag`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_free_askarecdh1pu(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_free_askarecdh1pu(`ptr`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_constructor_askarecdh1pu_new(`algId`: RustBuffer,`apu`: RustBuffer,`apv`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_constructor_askarecdh1pu_new(`algId`,`apu`,`apv`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarecdh1pu_derive_key(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`senderKey`: Pointer,`receiverKey`: Pointer,`ccTag`: RustBuffer,`receive`: Byte,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarecdh1pu_derive_key(`ptr`,`encAlg`,`ephemeralKey`,`senderKey`,`receiverKey`,`ccTag`,`receive`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarecdh1pu_encrypt_direct(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`senderKey`: Pointer,`receiverKey`: Pointer,`message`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarecdh1pu_encrypt_direct(`ptr`,`encAlg`,`ephemeralKey`,`senderKey`,`receiverKey`,`message`,`nonce`,`aad`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarecdh1pu_decrypt_direct(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`senderKey`: Pointer,`receiverKey`: Pointer,`ciphertext`: RustBuffer,`tag`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarecdh1pu_decrypt_direct(`ptr`,`encAlg`,`ephemeralKey`,`senderKey`,`receiverKey`,`ciphertext`,`tag`,`nonce`,`aad`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarecdh1pu_sender_wrap_key(`ptr`: Pointer,`wrapAlg`: RustBuffer,`ephemeralKey`: Pointer,`senderKey`: Pointer,`receiverKey`: Pointer,`cek`: Pointer,`ccTag`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarecdh1pu_sender_wrap_key(`ptr`,`wrapAlg`,`ephemeralKey`,`senderKey`,`receiverKey`,`cek`,`ccTag`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_fn_method_askarecdh1pu_receiver_unwrap_key(`ptr`: Pointer,`wrapAlg`: RustBuffer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`senderKey`: Pointer,`receiverKey`: Pointer,`ciphertext`: RustBuffer,`ccTag`: RustBuffer,`nonce`: RustBuffer,`tag`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_fn_method_askarecdh1pu_receiver_unwrap_key(`ptr`,`wrapAlg`,`encAlg`,`ephemeralKey`,`senderKey`,`receiverKey`,`ciphertext`,`ccTag`,`nonce`,`tag`,_uniffi_out_err
        ))

    actual fun ffi_aries_askar_rustbuffer_alloc(`size`: Int,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.ffi_aries_askar_rustbuffer_alloc(`size`,_uniffi_out_err
        ))

    actual fun ffi_aries_askar_rustbuffer_from_bytes(`bytes`: ForeignBytes,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.ffi_aries_askar_rustbuffer_from_bytes(`bytes`,_uniffi_out_err
        ))

    actual fun ffi_aries_askar_rustbuffer_free(`buf`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Unit =
        requireNotNull(aries_askar.cinterop.ffi_aries_askar_rustbuffer_free(`buf`,_uniffi_out_err
        ))

    actual fun ffi_aries_askar_rustbuffer_reserve(`buf`: RustBuffer,`additional`: Int,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer =
        requireNotNull(aries_askar.cinterop.ffi_aries_askar_rustbuffer_reserve(`buf`,`additional`,_uniffi_out_err
        ))

    actual fun uniffi_aries_askar_checksum_method_askarentry_category(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarentry_category(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarentry_name(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarentry_name(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarentry_tags(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarentry_tags(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarentry_value(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarentry_value(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarkeyentry_algorithm(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarkeyentry_algorithm(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarkeyentry_metadata(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarkeyentry_metadata(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarkeyentry_name(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarkeyentry_name(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarkeyentry_is_local(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarkeyentry_is_local(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarkeyentry_tags(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarkeyentry_tags(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarkeyentry_load_local_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarkeyentry_load_local_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarscan_next(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarscan_next(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarscan_fetch_all(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarscan_fetch_all(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_close(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_close(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_count(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_count(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_fetch(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_fetch(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_fetch_all(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_fetch_all(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_update(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_update(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_remove_all(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_remove_all(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_insert_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_insert_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_fetch_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_fetch_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_fetch_all_keys(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_fetch_all_keys(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_remove_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_remove_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarsession_update_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarsession_update_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstore_get_profile_name(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstore_get_profile_name(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstore_create_profile(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstore_create_profile(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstore_remove_profile(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstore_remove_profile(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstore_rekey(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstore_rekey(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstore_close(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstore_close(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstore_scan(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstore_scan(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstore_session(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstore_session(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_to_public_bytes(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_to_public_bytes(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_to_secret_bytes(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_to_secret_bytes(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_to_key_exchange(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_to_key_exchange(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_algorithm(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_algorithm(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_public(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_public(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_secret(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_secret(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_thumbprint(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_thumbprint(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_thumbprints(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_thumbprints(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_convert_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_convert_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_aead_params(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_aead_params(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_aead_padding(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_aead_padding(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_aead_random_nonce(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_aead_random_nonce(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_aead_encrypt(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_aead_encrypt(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_aead_decrypt(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_aead_decrypt(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_sign_message(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_sign_message(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_verify_signature(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_verify_signature(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_wrap_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_wrap_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarlocalkey_unwrap_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarlocalkey_unwrap_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_encryptedbuffer_ciphertext(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_encryptedbuffer_ciphertext(
        ))

    actual fun uniffi_aries_askar_checksum_method_encryptedbuffer_nonce(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_encryptedbuffer_nonce(
        ))

    actual fun uniffi_aries_askar_checksum_method_encryptedbuffer_tag(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_encryptedbuffer_tag(
        ))

    actual fun uniffi_aries_askar_checksum_method_encryptedbuffer_ciphertext_tag(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_encryptedbuffer_ciphertext_tag(
        ))

    actual fun uniffi_aries_askar_checksum_method_localkeyfactory_generate(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_localkeyfactory_generate(
        ))

    actual fun uniffi_aries_askar_checksum_method_localkeyfactory_from_seed(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_localkeyfactory_from_seed(
        ))

    actual fun uniffi_aries_askar_checksum_method_localkeyfactory_from_jwk_slice(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_localkeyfactory_from_jwk_slice(
        ))

    actual fun uniffi_aries_askar_checksum_method_localkeyfactory_from_jwk(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_localkeyfactory_from_jwk(
        ))

    actual fun uniffi_aries_askar_checksum_method_localkeyfactory_from_public_bytes(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_localkeyfactory_from_public_bytes(
        ))

    actual fun uniffi_aries_askar_checksum_method_localkeyfactory_from_secret_bytes(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_localkeyfactory_from_secret_bytes(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstoremanager_generate_raw_store_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstoremanager_generate_raw_store_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstoremanager_set_default_logger(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstoremanager_set_default_logger(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstoremanager_provision(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstoremanager_provision(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstoremanager_open(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstoremanager_open(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarstoremanager_remove(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarstoremanager_remove(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarcrypto_random_nonce(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarcrypto_random_nonce(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarcrypto_crypto_box(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarcrypto_crypto_box(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarcrypto_box_open(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarcrypto_box_open(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarcrypto_box_seal(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarcrypto_box_seal(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarcrypto_box_seal_open(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarcrypto_box_seal_open(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarecdhes_derive_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarecdhes_derive_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarecdhes_encrypt_direct(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarecdhes_encrypt_direct(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarecdhes_decrypt_direct(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarecdhes_decrypt_direct(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarecdhes_sender_wrap_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarecdhes_sender_wrap_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarecdhes_receiver_unwrap_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarecdhes_receiver_unwrap_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarecdh1pu_derive_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarecdh1pu_derive_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarecdh1pu_encrypt_direct(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarecdh1pu_encrypt_direct(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarecdh1pu_decrypt_direct(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarecdh1pu_decrypt_direct(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarecdh1pu_sender_wrap_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarecdh1pu_sender_wrap_key(
        ))

    actual fun uniffi_aries_askar_checksum_method_askarecdh1pu_receiver_unwrap_key(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi_aries_askar_checksum_method_askarecdh1pu_receiver_unwrap_key(
        ))

    actual fun uniffi__checksum_constructor_localkeyfactory_new(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi__checksum_constructor_localkeyfactory_new(
        ))

    actual fun uniffi__checksum_constructor_askarstoremanager_new(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi__checksum_constructor_askarstoremanager_new(
        ))

    actual fun uniffi__checksum_constructor_askarcrypto_new(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi__checksum_constructor_askarcrypto_new(
        ))

    actual fun uniffi__checksum_constructor_askarecdhes_new(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi__checksum_constructor_askarecdhes_new(
        ))

    actual fun uniffi__checksum_constructor_askarecdh1pu_new(
    ): UShort =
        requireNotNull(aries_askar.cinterop.uniffi__checksum_constructor_askarecdh1pu_new(
        ))

    actual fun uniffi_foreign_executor_callback_set(`callback`: UniFfiForeignExecutorCallback,
    ): Unit =
        requireNotNull(aries_askar.cinterop.uniffi_foreign_executor_callback_set(`callback`,
        ))

    actual fun ffi_aries_askar_uniffi_contract_version(
    ): UInt =
        requireNotNull(aries_askar.cinterop.ffi_aries_askar_uniffi_contract_version(
        ))

    
}