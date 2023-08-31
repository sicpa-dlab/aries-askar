package aries_askar

// Async return type handlers

import kotlin.coroutines.Continuation

// FFI type for callback handlers
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackUInt8
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackInt8
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackInt32
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackInt64
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustArcPtrAskarCrypto
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustArcPtrAskarEcdh1PU
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustArcPtrAskarEcdhEs
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustArcPtrAskarLocalKey
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustArcPtrAskarScan
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustArcPtrAskarSession
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustArcPtrAskarStore
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustArcPtrAskarStoreManager
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustArcPtrEncryptedBuffer
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustArcPtrLocalKeyFactory
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class UniFfiFutureCallbackRustBuffer

// Callback handlers for an async call.  These are invoked by Rust when the future is ready.
// They lift the return value or error and resume the suspended function.
expect fun createUniFfiFutureCallbackHandlerVoid_TypeErrorCodeData(continuation: Continuation<Unit>)
                      : UniFfiFutureCallbackHandlerVoid_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerVoid_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackUInt8,
    val dropHandle: DropHandle<
            Unit
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandleri32Data(continuation: Continuation<Int>)
                      : UniFfiFutureCallbackHandleri32Data

data class UniFfiFutureCallbackHandleri32Data(
    val resultHandler: UniFfiFutureCallbackInt32,
    val dropHandle: DropHandle<
            Int
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandleri64_TypeErrorCodeData(continuation: Continuation<Long>)
                      : UniFfiFutureCallbackHandleri64_TypeErrorCodeData

data class UniFfiFutureCallbackHandleri64_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackInt64,
    val dropHandle: DropHandle<
            Long
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerboolData(continuation: Continuation<Boolean>)
                      : UniFfiFutureCallbackHandlerboolData

data class UniFfiFutureCallbackHandlerboolData(
    val resultHandler: UniFfiFutureCallbackInt8,
    val dropHandle: DropHandle<
            Boolean
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerbool_TypeErrorCodeData(continuation: Continuation<Boolean>)
                      : UniFfiFutureCallbackHandlerbool_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerbool_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackInt8,
    val dropHandle: DropHandle<
            Boolean
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerstringData(continuation: Continuation<String>)
                      : UniFfiFutureCallbackHandlerstringData

data class UniFfiFutureCallbackHandlerstringData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            String
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerstring_TypeErrorCodeData(continuation: Continuation<String>)
                      : UniFfiFutureCallbackHandlerstring_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerstring_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            String
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeAskarCryptoData(continuation: Continuation<AskarCrypto>)
                      : UniFfiFutureCallbackHandlerTypeAskarCryptoData

data class UniFfiFutureCallbackHandlerTypeAskarCryptoData(
    val resultHandler: UniFfiFutureCallbackRustArcPtrAskarCrypto,
    val dropHandle: DropHandle<
            AskarCrypto
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeAskarEcdh1PUData(continuation: Continuation<AskarEcdh1Pu>)
                      : UniFfiFutureCallbackHandlerTypeAskarEcdh1PUData

data class UniFfiFutureCallbackHandlerTypeAskarEcdh1PUData(
    val resultHandler: UniFfiFutureCallbackRustArcPtrAskarEcdh1PU,
    val dropHandle: DropHandle<
            AskarEcdh1Pu
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeAskarEcdhEsData(continuation: Continuation<AskarEcdhEs>)
                      : UniFfiFutureCallbackHandlerTypeAskarEcdhEsData

data class UniFfiFutureCallbackHandlerTypeAskarEcdhEsData(
    val resultHandler: UniFfiFutureCallbackRustArcPtrAskarEcdhEs,
    val dropHandle: DropHandle<
            AskarEcdhEs
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCodeData(continuation: Continuation<AskarLocalKey>)
                      : UniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustArcPtrAskarLocalKey,
    val dropHandle: DropHandle<
            AskarLocalKey
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData(continuation: Continuation<AskarScan>)
                      : UniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustArcPtrAskarScan,
    val dropHandle: DropHandle<
            AskarScan
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData(continuation: Continuation<AskarSession>)
                      : UniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustArcPtrAskarSession,
    val dropHandle: DropHandle<
            AskarSession
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData(continuation: Continuation<AskarStore>)
                      : UniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustArcPtrAskarStore,
    val dropHandle: DropHandle<
            AskarStore
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeAskarStoreManagerData(continuation: Continuation<AskarStoreManager>)
                      : UniFfiFutureCallbackHandlerTypeAskarStoreManagerData

data class UniFfiFutureCallbackHandlerTypeAskarStoreManagerData(
    val resultHandler: UniFfiFutureCallbackRustArcPtrAskarStoreManager,
    val dropHandle: DropHandle<
            AskarStoreManager
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCodeData(continuation: Continuation<EncryptedBuffer>)
                      : UniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustArcPtrEncryptedBuffer,
    val dropHandle: DropHandle<
            EncryptedBuffer
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeLocalKeyFactoryData(continuation: Continuation<LocalKeyFactory>)
                      : UniFfiFutureCallbackHandlerTypeLocalKeyFactoryData

data class UniFfiFutureCallbackHandlerTypeLocalKeyFactoryData(
    val resultHandler: UniFfiFutureCallbackRustArcPtrLocalKeyFactory,
    val dropHandle: DropHandle<
            LocalKeyFactory
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCodeData(continuation: Continuation<AeadParams>)
                      : UniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            AeadParams
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerTypeAskarKeyAlgData(continuation: Continuation<AskarKeyAlg>)
                      : UniFfiFutureCallbackHandlerTypeAskarKeyAlgData

data class UniFfiFutureCallbackHandlerTypeAskarKeyAlgData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            AskarKeyAlg
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerOptionalstringData(continuation: Continuation<String?>)
                      : UniFfiFutureCallbackHandlerOptionalstringData

data class UniFfiFutureCallbackHandlerOptionalstringData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            String?
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData(continuation: Continuation<AskarEntry?>)
                      : UniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            AskarEntry?
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData(continuation: Continuation<AskarKeyEntry?>)
                      : UniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            AskarKeyEntry?
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData(continuation: Continuation<List<AskarEntry>?>)
                      : UniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            List<AskarEntry>?
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerSequenceu8Data(continuation: Continuation<List<UByte>>)
                      : UniFfiFutureCallbackHandlerSequenceu8Data

data class UniFfiFutureCallbackHandlerSequenceu8Data(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            List<UByte>
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerSequenceu8_TypeErrorCodeData(continuation: Continuation<List<UByte>>)
                      : UniFfiFutureCallbackHandlerSequenceu8_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerSequenceu8_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            List<UByte>
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerSequencestring_TypeErrorCodeData(continuation: Continuation<List<String>>)
                      : UniFfiFutureCallbackHandlerSequencestring_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerSequencestring_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            List<String>
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData(continuation: Continuation<List<AskarEntry>>)
                      : UniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            List<AskarEntry>
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData(continuation: Continuation<List<AskarKeyEntry>>)
                      : UniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData

data class UniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            List<AskarKeyEntry>
    >,
    val continuationRef: Pointer
)
expect fun createUniFfiFutureCallbackHandlerMapStringStringData(continuation: Continuation<Map<String, String>>)
                      : UniFfiFutureCallbackHandlerMapStringStringData

data class UniFfiFutureCallbackHandlerMapStringStringData(
    val resultHandler: UniFfiFutureCallbackRustBuffer,
    val dropHandle: DropHandle<
            Map<String, String>
    >,
    val continuationRef: Pointer
)

expect class DropHandle<T> {
    fun dropIt()
}