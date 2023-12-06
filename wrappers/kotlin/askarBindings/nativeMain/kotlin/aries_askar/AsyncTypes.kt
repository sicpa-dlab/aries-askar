package aries_askar

// Async return type handlers

import kotlinx.cinterop.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.test.assertNotNull

// For each result_type, there could be several handlers for different errors and one for the plain type without any error
// In upstream uniffi, UniFfiFutureCallback\{\{ callback_param.canonical_name() \}\} is a super interface that all the
// different handlers with and without error implement.
// This does not work well for Native where we have Pointer types typealiases for CPointer<T> for several T
// We define a single typealias for the handler that expects no error since the pointer type is identical, anyway
typealias UniFfiFutureCallbackUInt8 = CPointer<CFunction<(Pointer?, UByte, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackInt8 = CPointer<CFunction<(Pointer?, Byte, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackInt32 = CPointer<CFunction<(Pointer?, Int, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackInt64 = CPointer<CFunction<(Pointer?, Long, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustArcPtrAskarCrypto = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustArcPtrAskarEcdh1PU = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustArcPtrAskarEcdhEs = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustArcPtrAskarLocalKey = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustArcPtrAskarScan = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustArcPtrAskarSession = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustArcPtrAskarStore = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustArcPtrAskarStoreManager = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustArcPtrEncryptedBuffer = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustArcPtrLocalKeyFactory = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>
typealias UniFfiFutureCallbackRustBuffer = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>


// Callback handlers for an async call.  These are invoked by Rust when the future is ready.  They
// lift the return value or error and resume the suspended function.

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerVoid_TypeErrorCode = CPointer<CFunction<(Pointer?, UByte, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerVoid_TypeErrorCodeData(continuation: Continuation<Unit>)
                      : UniFfiFutureCallbackHandlerVoid_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerVoid_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerVoid_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerVoid_TypeErrorCode(): UniFfiFutureCallbackHandlerVoid_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, _: UByte, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<Unit>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(Unit)
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandleri32 = CPointer<CFunction<(Pointer?, Int, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandleri32Data(continuation: Continuation<Int>)
                      : UniFfiFutureCallbackHandleri32Data {
    val resultHandler = createUniFfiFutureCallbackHandleri32()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandleri32Data(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandleri32(): UniFfiFutureCallbackHandleri32 =
    staticCFunction { callbackData: Pointer?, returnValue: Int, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<Int>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterInt.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandleri64_TypeErrorCode = CPointer<CFunction<(Pointer?, Long, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandleri64_TypeErrorCodeData(continuation: Continuation<Long>)
                      : UniFfiFutureCallbackHandleri64_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandleri64_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandleri64_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandleri64_TypeErrorCode(): UniFfiFutureCallbackHandleri64_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: Long, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<Long>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterLong.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerbool = CPointer<CFunction<(Pointer?, Byte, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerboolData(continuation: Continuation<Boolean>)
                      : UniFfiFutureCallbackHandlerboolData {
    val resultHandler = createUniFfiFutureCallbackHandlerbool()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerboolData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerbool(): UniFfiFutureCallbackHandlerbool =
    staticCFunction { callbackData: Pointer?, returnValue: Byte, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<Boolean>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterBoolean.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerbool_TypeErrorCode = CPointer<CFunction<(Pointer?, Byte, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerbool_TypeErrorCodeData(continuation: Continuation<Boolean>)
                      : UniFfiFutureCallbackHandlerbool_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerbool_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerbool_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerbool_TypeErrorCode(): UniFfiFutureCallbackHandlerbool_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: Byte, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<Boolean>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterBoolean.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerstring = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerstringData(continuation: Continuation<String>)
                      : UniFfiFutureCallbackHandlerstringData {
    val resultHandler = createUniFfiFutureCallbackHandlerstring()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerstringData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerstring(): UniFfiFutureCallbackHandlerstring =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<String>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterString.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerstring_TypeErrorCode = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerstring_TypeErrorCodeData(continuation: Continuation<String>)
                      : UniFfiFutureCallbackHandlerstring_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerstring_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerstring_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerstring_TypeErrorCode(): UniFfiFutureCallbackHandlerstring_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<String>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterString.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeAskarCrypto = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeAskarCryptoData(continuation: Continuation<AskarCrypto>)
                      : UniFfiFutureCallbackHandlerTypeAskarCryptoData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeAskarCrypto()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeAskarCryptoData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeAskarCrypto(): UniFfiFutureCallbackHandlerTypeAskarCrypto =
    staticCFunction { callbackData: Pointer?, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarCrypto>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterTypeAskarCrypto.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeAskarEcdh1PU = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeAskarEcdh1PUData(continuation: Continuation<AskarEcdh1Pu>)
                      : UniFfiFutureCallbackHandlerTypeAskarEcdh1PUData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeAskarEcdh1PU()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeAskarEcdh1PUData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeAskarEcdh1PU(): UniFfiFutureCallbackHandlerTypeAskarEcdh1PU =
    staticCFunction { callbackData: Pointer?, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarEcdh1Pu>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterTypeAskarEcdh1Pu.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeAskarEcdhEs = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeAskarEcdhEsData(continuation: Continuation<AskarEcdhEs>)
                      : UniFfiFutureCallbackHandlerTypeAskarEcdhEsData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeAskarEcdhEs()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeAskarEcdhEsData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeAskarEcdhEs(): UniFfiFutureCallbackHandlerTypeAskarEcdhEs =
    staticCFunction { callbackData: Pointer?, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarEcdhEs>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterTypeAskarEcdhEs.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCode = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCodeData(continuation: Continuation<AskarLocalKey>)
                      : UniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCode(): UniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarLocalKey>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterTypeAskarLocalKey.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCode = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData(continuation: Continuation<AskarScan>)
                      : UniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCode(): UniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarScan>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterTypeAskarScan.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCode = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData(continuation: Continuation<AskarSession>)
                      : UniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCode(): UniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarSession>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterTypeAskarSession.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCode = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData(continuation: Continuation<AskarStore>)
                      : UniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCode(): UniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarStore>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterTypeAskarStore.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeAskarStoreManager = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeAskarStoreManagerData(continuation: Continuation<AskarStoreManager>)
                      : UniFfiFutureCallbackHandlerTypeAskarStoreManagerData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeAskarStoreManager()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeAskarStoreManagerData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeAskarStoreManager(): UniFfiFutureCallbackHandlerTypeAskarStoreManager =
    staticCFunction { callbackData: Pointer?, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarStoreManager>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterTypeAskarStoreManager.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCode = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCodeData(continuation: Continuation<EncryptedBuffer>)
                      : UniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCode(): UniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<EncryptedBuffer>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterTypeEncryptedBuffer.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeLocalKeyFactory = CPointer<CFunction<(Pointer?, Pointer?, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeLocalKeyFactoryData(continuation: Continuation<LocalKeyFactory>)
                      : UniFfiFutureCallbackHandlerTypeLocalKeyFactoryData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeLocalKeyFactory()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeLocalKeyFactoryData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeLocalKeyFactory(): UniFfiFutureCallbackHandlerTypeLocalKeyFactory =
    staticCFunction { callbackData: Pointer?, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<LocalKeyFactory>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterTypeLocalKeyFactory.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCode = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCodeData(continuation: Continuation<AeadParams>)
                      : UniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCode(): UniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AeadParams>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterTypeAeadParams.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerTypeAskarKeyAlg = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerTypeAskarKeyAlgData(continuation: Continuation<AskarKeyAlg>)
                      : UniFfiFutureCallbackHandlerTypeAskarKeyAlgData {
    val resultHandler = createUniFfiFutureCallbackHandlerTypeAskarKeyAlg()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerTypeAskarKeyAlgData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerTypeAskarKeyAlg(): UniFfiFutureCallbackHandlerTypeAskarKeyAlg =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarKeyAlg>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterTypeAskarKeyAlg.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerOptionalstring = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerOptionalstringData(continuation: Continuation<String?>)
                      : UniFfiFutureCallbackHandlerOptionalstringData {
    val resultHandler = createUniFfiFutureCallbackHandlerOptionalstring()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerOptionalstringData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerOptionalstring(): UniFfiFutureCallbackHandlerOptionalstring =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<String?>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterOptionalString.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCode = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData(continuation: Continuation<AskarEntry?>)
                      : UniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCode(): UniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarEntry?>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterOptionalTypeAskarEntry.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCode = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData(continuation: Continuation<AskarKeyEntry?>)
                      : UniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCode(): UniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<AskarKeyEntry?>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterOptionalTypeAskarKeyEntry.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCode = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData(continuation: Continuation<List<AskarEntry>?>)
                      : UniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCode(): UniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<List<AskarEntry>?>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterOptionalSequenceTypeAskarEntry.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerSequenceu8 = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerSequenceu8Data(continuation: Continuation<List<UByte>>)
                      : UniFfiFutureCallbackHandlerSequenceu8Data {
    val resultHandler = createUniFfiFutureCallbackHandlerSequenceu8()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerSequenceu8Data(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerSequenceu8(): UniFfiFutureCallbackHandlerSequenceu8 =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<List<UByte>>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterSequenceUByte.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerSequenceu8_TypeErrorCode = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerSequenceu8_TypeErrorCodeData(continuation: Continuation<List<UByte>>)
                      : UniFfiFutureCallbackHandlerSequenceu8_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerSequenceu8_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerSequenceu8_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerSequenceu8_TypeErrorCode(): UniFfiFutureCallbackHandlerSequenceu8_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<List<UByte>>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterSequenceUByte.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerSequencestring_TypeErrorCode = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerSequencestring_TypeErrorCodeData(continuation: Continuation<List<String>>)
                      : UniFfiFutureCallbackHandlerSequencestring_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerSequencestring_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerSequencestring_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerSequencestring_TypeErrorCode(): UniFfiFutureCallbackHandlerSequencestring_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<List<String>>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterSequenceString.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCode = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData(continuation: Continuation<List<AskarEntry>>)
                      : UniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCode(): UniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<List<AskarEntry>>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterSequenceTypeAskarEntry.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCode = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData(continuation: Continuation<List<AskarKeyEntry>>)
                      : UniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData {
    val resultHandler = createUniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCode()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCode(): UniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCode =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<List<AskarKeyEntry>>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(ErrorCode, callStatus)
            continuation.resume(FfiConverterSequenceTypeAskarKeyEntry.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiFutureCallbackHandlerMapStringString = CPointer<CFunction<(Pointer?, RustBuffer, RustCallStatusByValue) -> Unit>>

actual fun createUniFfiFutureCallbackHandlerMapStringStringData(continuation: Continuation<Map<String, String>>)
                      : UniFfiFutureCallbackHandlerMapStringStringData {
    val resultHandler = createUniFfiFutureCallbackHandlerMapStringString()
    // see https://kotlinlang.org/docs/native-c-interop.html#pass-user-data-to-callbacks
    val stableRef = StableRef.create(continuation)
    return UniFfiFutureCallbackHandlerMapStringStringData(
        resultHandler,
        DropHandle(stableRef),
        stableRef.asCPointer()
    )
}

private fun createUniFfiFutureCallbackHandlerMapStringString(): UniFfiFutureCallbackHandlerMapStringString =
    staticCFunction { callbackData: Pointer?, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
        assertNotNull(callbackData, "received no continuation to resume...")
        // the StableRef is disposed in the scope that held onto the DropHandler wrapper
        val stableRef = callbackData.asStableRef<Continuation<Map<String, String>>>()
        val continuation = stableRef.get()
        try {
            checkCallStatusByValue(NullCallStatusErrorHandler, callStatus)
            continuation.resume(FfiConverterMapStringString.lift(requireNotNull(returnValue)))
        }
        catch (e: Throwable) {
            continuation.resumeWithException(e)
        }
    }

actual class DropHandle<T>(private val stableRef: StableRef<Continuation<T>>) {
    actual fun dropIt() {
        stableRef.dispose()
    }
}

private inline fun aries_askar.cinterop.RustCallStatus.isSuccess(): Boolean = code == 0.toByte()
private inline fun aries_askar.cinterop.RustCallStatus.isError(): Boolean = code == 1.toByte()
private inline fun aries_askar.cinterop.RustCallStatus.isPanic(): Boolean = code == 2.toByte()

// TODO remove this crutch that is needed because on Native, RustCallStatusByValue does not extend RustCallStatus
//      and "just getting a pointer to the value" apparently requires copying to a special place and *then* getting
//      a pointer to that location
private fun<E: Exception> checkCallStatusByValue(errorHandler: CallStatusErrorHandler<E>, statusByValue: RustCallStatusByValue) {
    // no need to clean up the call status since the caller received it as a c parameter by value
    statusByValue.useContents {
        if (this.isSuccess()) {
            return
        } else if (isError()) {
            throw errorHandler.lift(errorBuf.readValue())
        } else if (isPanic()) {
            // when the rust code sees a panic, it tries to construct a rustbuffer
            // with the message.  but if that code panics, then it just sends back
            // an empty buffer.
            val errorBuffer = errorBuf.readValue()
            if (errorBuffer.dataSize > 0) {
                // TODO avoid additional copy
                throw InternalException(FfiConverterString.lift(errorBuffer))
            } else {
                throw InternalException("Rust panic")
            }
        } else {
            throw InternalException("Unknown rust call status: $statusByValue.code")
        }
    }
}