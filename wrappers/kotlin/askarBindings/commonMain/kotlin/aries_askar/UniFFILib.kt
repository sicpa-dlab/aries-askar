package aries_askar



expect object UniFFILib {
    fun uniffi_aries_askar_fn_free_askarentry(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarentry_category(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarentry_name(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarentry_tags(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarentry_value(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_free_askarkeyentry(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarkeyentry_algorithm(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarkeyentry_metadata(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarkeyentry_name(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarkeyentry_is_local(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Byte

    fun uniffi_aries_askar_fn_method_askarkeyentry_tags(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarkeyentry_load_local_key(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_free_askarscan(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarscan_next(`ptr`: Pointer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarscan_fetch_all(`ptr`: Pointer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_free_askarsession(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_close(`ptr`: Pointer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_count(`ptr`: Pointer,`category`: RustBuffer,`tagFilter`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackInt64,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_fetch(`ptr`: Pointer,`category`: RustBuffer,`name`: RustBuffer,`forUpdate`: Byte,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_fetch_all(`ptr`: Pointer,`category`: RustBuffer,`tagFilter`: RustBuffer,`limit`: RustBuffer,`forUpdate`: Byte,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_update(`ptr`: Pointer,`operation`: RustBuffer,`category`: RustBuffer,`name`: RustBuffer,`value`: RustBuffer,`tags`: RustBuffer,`expiryMs`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_remove_all(`ptr`: Pointer,`category`: RustBuffer,`tagFilter`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackInt64,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_insert_key(`ptr`: Pointer,`name`: RustBuffer,`key`: Pointer,`metadata`: RustBuffer,`tags`: RustBuffer,`expiryMs`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_fetch_key(`ptr`: Pointer,`name`: RustBuffer,`forUpdate`: Byte,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_fetch_all_keys(`ptr`: Pointer,`algorithm`: RustBuffer,`thumbprint`: RustBuffer,`tagFilter`: RustBuffer,`limit`: RustBuffer,`forUpdate`: Byte,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_remove_key(`ptr`: Pointer,`name`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarsession_update_key(`ptr`: Pointer,`name`: RustBuffer,`metadata`: RustBuffer,`tags`: RustBuffer,`expiryMs`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_free_askarstore(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarstore_get_profile_name(`ptr`: Pointer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarstore_create_profile(`ptr`: Pointer,`profile`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustBuffer,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarstore_remove_profile(`ptr`: Pointer,`profile`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarstore_rekey(`ptr`: Pointer,`keyMethod`: RustBuffer,`passKey`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarstore_close(`ptr`: Pointer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackUInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarstore_scan(`ptr`: Pointer,`profile`: RustBuffer,`categogy`: RustBuffer,`tagFilter`: RustBuffer,`offset`: RustBuffer,`limit`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustArcPtrAskarScan,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarstore_session(`ptr`: Pointer,`profile`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustArcPtrAskarSession,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_free_askarlocalkey(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarlocalkey_to_public_bytes(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_to_secret_bytes(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_to_key_exchange(`ptr`: Pointer,`alg`: RustBuffer,`pk`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarlocalkey_algorithm(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_public(`ptr`: Pointer,`alg`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_secret(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_thumbprint(`ptr`: Pointer,`alg`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_to_jwk_thumbprints(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_convert_key(`ptr`: Pointer,`alg`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarlocalkey_aead_params(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_aead_padding(`ptr`: Pointer,`msgLen`: Int,_uniffi_out_err: RustCallStatus, 
    ): Int

    fun uniffi_aries_askar_fn_method_askarlocalkey_aead_random_nonce(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_aead_encrypt(`ptr`: Pointer,`message`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarlocalkey_aead_decrypt(`ptr`: Pointer,`ciphertext`: RustBuffer,`tag`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_sign_message(`ptr`: Pointer,`message`: RustBuffer,`sigType`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarlocalkey_verify_signature(`ptr`: Pointer,`message`: RustBuffer,`signature`: RustBuffer,`sigType`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Byte

    fun uniffi_aries_askar_fn_method_askarlocalkey_wrap_key(`ptr`: Pointer,`key`: Pointer,`nonce`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarlocalkey_unwrap_key(`ptr`: Pointer,`alg`: RustBuffer,`ciphertext`: RustBuffer,`tag`: RustBuffer,`nonce`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_free_encryptedbuffer(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_encryptedbuffer_ciphertext(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_encryptedbuffer_nonce(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_encryptedbuffer_tag(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_encryptedbuffer_ciphertext_tag(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_free_localkeyfactory(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_constructor_localkeyfactory_new(_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_localkeyfactory_generate(`ptr`: Pointer,`alg`: RustBuffer,`ephemeral`: Byte,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_localkeyfactory_from_seed(`ptr`: Pointer,`alg`: RustBuffer,`seed`: RustBuffer,`method`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_localkeyfactory_from_jwk_slice(`ptr`: Pointer,`jwk`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_localkeyfactory_from_jwk(`ptr`: Pointer,`jwk`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_localkeyfactory_from_public_bytes(`ptr`: Pointer,`alg`: RustBuffer,`bytes`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_localkeyfactory_from_secret_bytes(`ptr`: Pointer,`alg`: RustBuffer,`bytes`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_free_askarstoremanager(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_constructor_askarstoremanager_new(_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarstoremanager_generate_raw_store_key(`ptr`: Pointer,`seed`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarstoremanager_set_default_logger(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarstoremanager_provision(`ptr`: Pointer,`specUri`: RustBuffer,`keyMethod`: RustBuffer,`passKey`: RustBuffer,`profile`: RustBuffer,`recreate`: Byte,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustArcPtrAskarStore,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarstoremanager_open(`ptr`: Pointer,`specUri`: RustBuffer,`keyMethod`: RustBuffer,`passKey`: RustBuffer,`profile`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackRustArcPtrAskarStore,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_method_askarstoremanager_remove(`ptr`: Pointer,`specUri`: RustBuffer,`uniffiExecutor`: ULong,`uniffiCallback`: UniFfiFutureCallbackInt8,`uniffiCallbackData`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_free_askarcrypto(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_constructor_askarcrypto_new(_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarcrypto_random_nonce(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarcrypto_crypto_box(`ptr`: Pointer,`receiverKey`: Pointer,`senderKey`: Pointer,`message`: RustBuffer,`nonce`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarcrypto_box_open(`ptr`: Pointer,`receiverKey`: Pointer,`senderKey`: Pointer,`message`: RustBuffer,`nonce`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarcrypto_box_seal(`ptr`: Pointer,`receiverKey`: Pointer,`message`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarcrypto_box_seal_open(`ptr`: Pointer,`receiverKey`: Pointer,`ciphertext`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_free_askarecdhes(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_constructor_askarecdhes_new(`algId`: RustBuffer,`apu`: RustBuffer,`apv`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarecdhes_derive_key(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`receiverKey`: Pointer,`receive`: Byte,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarecdhes_encrypt_direct(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`receiverKey`: Pointer,`message`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarecdhes_decrypt_direct(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`receiverKey`: Pointer,`ciphertext`: RustBuffer,`tag`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarecdhes_sender_wrap_key(`ptr`: Pointer,`wrapAlg`: RustBuffer,`ephemeralKey`: Pointer,`receiverKey`: Pointer,`cek`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarecdhes_receiver_unwrap_key(`ptr`: Pointer,`wrapAlg`: RustBuffer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`receiverKey`: Pointer,`ciphertext`: RustBuffer,`nonce`: RustBuffer,`tag`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_free_askarecdh1pu(`ptr`: Pointer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun uniffi_aries_askar_fn_constructor_askarecdh1pu_new(`algId`: RustBuffer,`apu`: RustBuffer,`apv`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarecdh1pu_derive_key(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`senderKey`: Pointer,`receiverKey`: Pointer,`ccTag`: RustBuffer,`receive`: Byte,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarecdh1pu_encrypt_direct(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`senderKey`: Pointer,`receiverKey`: Pointer,`message`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarecdh1pu_decrypt_direct(`ptr`: Pointer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`senderKey`: Pointer,`receiverKey`: Pointer,`ciphertext`: RustBuffer,`tag`: RustBuffer,`nonce`: RustBuffer,`aad`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_fn_method_askarecdh1pu_sender_wrap_key(`ptr`: Pointer,`wrapAlg`: RustBuffer,`ephemeralKey`: Pointer,`senderKey`: Pointer,`receiverKey`: Pointer,`cek`: Pointer,`ccTag`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun uniffi_aries_askar_fn_method_askarecdh1pu_receiver_unwrap_key(`ptr`: Pointer,`wrapAlg`: RustBuffer,`encAlg`: RustBuffer,`ephemeralKey`: Pointer,`senderKey`: Pointer,`receiverKey`: Pointer,`ciphertext`: RustBuffer,`ccTag`: RustBuffer,`nonce`: RustBuffer,`tag`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Pointer

    fun ffi_aries_askar_rustbuffer_alloc(`size`: Int,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun ffi_aries_askar_rustbuffer_from_bytes(`bytes`: ForeignBytes,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun ffi_aries_askar_rustbuffer_free(`buf`: RustBuffer,_uniffi_out_err: RustCallStatus, 
    ): Unit

    fun ffi_aries_askar_rustbuffer_reserve(`buf`: RustBuffer,`additional`: Int,_uniffi_out_err: RustCallStatus, 
    ): RustBuffer

    fun uniffi_aries_askar_checksum_method_askarentry_category(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarentry_name(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarentry_tags(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarentry_value(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarkeyentry_algorithm(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarkeyentry_metadata(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarkeyentry_name(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarkeyentry_is_local(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarkeyentry_tags(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarkeyentry_load_local_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarscan_next(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarscan_fetch_all(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_close(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_count(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_fetch(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_fetch_all(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_update(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_remove_all(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_insert_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_fetch_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_fetch_all_keys(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_remove_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarsession_update_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstore_get_profile_name(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstore_create_profile(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstore_remove_profile(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstore_rekey(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstore_close(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstore_scan(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstore_session(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_to_public_bytes(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_to_secret_bytes(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_to_key_exchange(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_algorithm(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_public(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_secret(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_thumbprint(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_to_jwk_thumbprints(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_convert_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_aead_params(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_aead_padding(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_aead_random_nonce(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_aead_encrypt(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_aead_decrypt(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_sign_message(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_verify_signature(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_wrap_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarlocalkey_unwrap_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_encryptedbuffer_ciphertext(
    ): UShort

    fun uniffi_aries_askar_checksum_method_encryptedbuffer_nonce(
    ): UShort

    fun uniffi_aries_askar_checksum_method_encryptedbuffer_tag(
    ): UShort

    fun uniffi_aries_askar_checksum_method_encryptedbuffer_ciphertext_tag(
    ): UShort

    fun uniffi_aries_askar_checksum_method_localkeyfactory_generate(
    ): UShort

    fun uniffi_aries_askar_checksum_method_localkeyfactory_from_seed(
    ): UShort

    fun uniffi_aries_askar_checksum_method_localkeyfactory_from_jwk_slice(
    ): UShort

    fun uniffi_aries_askar_checksum_method_localkeyfactory_from_jwk(
    ): UShort

    fun uniffi_aries_askar_checksum_method_localkeyfactory_from_public_bytes(
    ): UShort

    fun uniffi_aries_askar_checksum_method_localkeyfactory_from_secret_bytes(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstoremanager_generate_raw_store_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstoremanager_set_default_logger(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstoremanager_provision(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstoremanager_open(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarstoremanager_remove(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarcrypto_random_nonce(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarcrypto_crypto_box(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarcrypto_box_open(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarcrypto_box_seal(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarcrypto_box_seal_open(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarecdhes_derive_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarecdhes_encrypt_direct(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarecdhes_decrypt_direct(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarecdhes_sender_wrap_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarecdhes_receiver_unwrap_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarecdh1pu_derive_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarecdh1pu_encrypt_direct(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarecdh1pu_decrypt_direct(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarecdh1pu_sender_wrap_key(
    ): UShort

    fun uniffi_aries_askar_checksum_method_askarecdh1pu_receiver_unwrap_key(
    ): UShort

    fun uniffi__checksum_constructor_localkeyfactory_new(
    ): UShort

    fun uniffi__checksum_constructor_askarstoremanager_new(
    ): UShort

    fun uniffi__checksum_constructor_askarcrypto_new(
    ): UShort

    fun uniffi__checksum_constructor_askarecdhes_new(
    ): UShort

    fun uniffi__checksum_constructor_askarecdh1pu_new(
    ): UShort

    fun uniffi_foreign_executor_callback_set(`callback`: UniFfiForeignExecutorCallback,
    ): Unit

    fun ffi_aries_askar_uniffi_contract_version(
    ): UInt

    
}