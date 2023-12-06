package aries_askar

// Async return type handlers


import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

// FFI type for callback handlers
actual class UniFfiFutureCallbackUInt8(private val inner: (ULong, UByte, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: UByte, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackInt8(private val inner: (ULong, Byte, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Byte, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackInt32(private val inner: (ULong, Int, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Int, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackInt64(private val inner: (ULong, Long, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Long, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustArcPtrAskarCrypto(private val inner: (ULong, Pointer?, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustArcPtrAskarEcdh1PU(private val inner: (ULong, Pointer?, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustArcPtrAskarEcdhEs(private val inner: (ULong, Pointer?, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustArcPtrAskarLocalKey(private val inner: (ULong, Pointer?, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustArcPtrAskarScan(private val inner: (ULong, Pointer?, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustArcPtrAskarSession(private val inner: (ULong, Pointer?, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustArcPtrAskarStore(private val inner: (ULong, Pointer?, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustArcPtrAskarStoreManager(private val inner: (ULong, Pointer?, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustArcPtrEncryptedBuffer(private val inner: (ULong, Pointer?, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustArcPtrLocalKeyFactory(private val inner: (ULong, Pointer?, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }
actual class UniFfiFutureCallbackRustBuffer(private val inner: (ULong, RustBuffer, RustCallStatusByValue) -> Unit) : com.sun.jna.Callback {
    // Note: callbackData does not contain a valid pointer. We could pass Rust a pointer/usize to represent the
    // continuation, but with JNA it's easier to just store it in the callback handler.
    // FIXME nullifying pointers does not seem right, but otherwise it crashes (witnessed for a nullable UByte callback parameter)
    // on the other hand, nullifying pointers could be all that is needed because this covers all structs etc and
    // primitive types implement Default which is hopefully used
    // upstream, this reads \{\{ callback_param|ffi_type_name_by_value \}\}?
    fun invoke(_callbackData: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue) {
        inner(_callbackData, returnValue, callStatus)
}   }

// Callback handlers for an async call.  These are invoked by Rust when the future is ready.  They
// lift the return value or error and resume the suspended function.
actual fun createUniFfiFutureCallbackHandlerVoid_TypeErrorCodeData(continuation: Continuation<Unit>)
                      : UniFfiFutureCallbackHandlerVoid_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerVoid_TypeErrorCodeData(
        UniFfiFutureCallbackUInt8 { _: ULong, returnValue: UByte, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(Unit)
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandleri32Data(continuation: Continuation<Int>)
                      : UniFfiFutureCallbackHandleri32Data =
    UniFfiFutureCallbackHandleri32Data(
        UniFfiFutureCallbackInt32 { _: ULong, returnValue: Int, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterInt.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandleri64_TypeErrorCodeData(continuation: Continuation<Long>)
                      : UniFfiFutureCallbackHandleri64_TypeErrorCodeData =
    UniFfiFutureCallbackHandleri64_TypeErrorCodeData(
        UniFfiFutureCallbackInt64 { _: ULong, returnValue: Long, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterLong.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerboolData(continuation: Continuation<Boolean>)
                      : UniFfiFutureCallbackHandlerboolData =
    UniFfiFutureCallbackHandlerboolData(
        UniFfiFutureCallbackInt8 { _: ULong, returnValue: Byte, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterBoolean.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerbool_TypeErrorCodeData(continuation: Continuation<Boolean>)
                      : UniFfiFutureCallbackHandlerbool_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerbool_TypeErrorCodeData(
        UniFfiFutureCallbackInt8 { _: ULong, returnValue: Byte, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterBoolean.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerstringData(continuation: Continuation<String>)
                      : UniFfiFutureCallbackHandlerstringData =
    UniFfiFutureCallbackHandlerstringData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterString.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerstring_TypeErrorCodeData(continuation: Continuation<String>)
                      : UniFfiFutureCallbackHandlerstring_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerstring_TypeErrorCodeData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterString.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeAskarCryptoData(continuation: Continuation<AskarCrypto>)
                      : UniFfiFutureCallbackHandlerTypeAskarCryptoData =
    UniFfiFutureCallbackHandlerTypeAskarCryptoData(
        UniFfiFutureCallbackRustArcPtrAskarCrypto { _: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterTypeAskarCrypto.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeAskarEcdh1PUData(continuation: Continuation<AskarEcdh1Pu>)
                      : UniFfiFutureCallbackHandlerTypeAskarEcdh1PUData =
    UniFfiFutureCallbackHandlerTypeAskarEcdh1PUData(
        UniFfiFutureCallbackRustArcPtrAskarEcdh1PU { _: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterTypeAskarEcdh1Pu.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeAskarEcdhEsData(continuation: Continuation<AskarEcdhEs>)
                      : UniFfiFutureCallbackHandlerTypeAskarEcdhEsData =
    UniFfiFutureCallbackHandlerTypeAskarEcdhEsData(
        UniFfiFutureCallbackRustArcPtrAskarEcdhEs { _: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterTypeAskarEcdhEs.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCodeData(continuation: Continuation<AskarLocalKey>)
                      : UniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerTypeAskarLocalKey_TypeErrorCodeData(
        UniFfiFutureCallbackRustArcPtrAskarLocalKey { _: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterTypeAskarLocalKey.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData(continuation: Continuation<AskarScan>)
                      : UniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData(
        UniFfiFutureCallbackRustArcPtrAskarScan { _: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterTypeAskarScan.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData(continuation: Continuation<AskarSession>)
                      : UniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData(
        UniFfiFutureCallbackRustArcPtrAskarSession { _: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterTypeAskarSession.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData(continuation: Continuation<AskarStore>)
                      : UniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData(
        UniFfiFutureCallbackRustArcPtrAskarStore { _: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterTypeAskarStore.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeAskarStoreManagerData(continuation: Continuation<AskarStoreManager>)
                      : UniFfiFutureCallbackHandlerTypeAskarStoreManagerData =
    UniFfiFutureCallbackHandlerTypeAskarStoreManagerData(
        UniFfiFutureCallbackRustArcPtrAskarStoreManager { _: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterTypeAskarStoreManager.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCodeData(continuation: Continuation<EncryptedBuffer>)
                      : UniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerTypeEncryptedBuffer_TypeErrorCodeData(
        UniFfiFutureCallbackRustArcPtrEncryptedBuffer { _: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterTypeEncryptedBuffer.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeLocalKeyFactoryData(continuation: Continuation<LocalKeyFactory>)
                      : UniFfiFutureCallbackHandlerTypeLocalKeyFactoryData =
    UniFfiFutureCallbackHandlerTypeLocalKeyFactoryData(
        UniFfiFutureCallbackRustArcPtrLocalKeyFactory { _: ULong, returnValue: Pointer?, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterTypeLocalKeyFactory.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCodeData(continuation: Continuation<AeadParams>)
                      : UniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerTypeAeadParams_TypeErrorCodeData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterTypeAeadParams.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerTypeAskarKeyAlgData(continuation: Continuation<AskarKeyAlg>)
                      : UniFfiFutureCallbackHandlerTypeAskarKeyAlgData =
    UniFfiFutureCallbackHandlerTypeAskarKeyAlgData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterTypeAskarKeyAlg.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerOptionalstringData(continuation: Continuation<String?>)
                      : UniFfiFutureCallbackHandlerOptionalstringData =
    UniFfiFutureCallbackHandlerOptionalstringData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterOptionalString.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData(continuation: Continuation<AskarEntry?>)
                      : UniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterOptionalTypeAskarEntry.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData(continuation: Continuation<AskarKeyEntry?>)
                      : UniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterOptionalTypeAskarKeyEntry.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData(continuation: Continuation<List<AskarEntry>?>)
                      : UniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterOptionalSequenceTypeAskarEntry.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerSequenceu8Data(continuation: Continuation<List<UByte>>)
                      : UniFfiFutureCallbackHandlerSequenceu8Data =
    UniFfiFutureCallbackHandlerSequenceu8Data(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterSequenceUByte.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerSequenceu8_TypeErrorCodeData(continuation: Continuation<List<UByte>>)
                      : UniFfiFutureCallbackHandlerSequenceu8_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerSequenceu8_TypeErrorCodeData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterSequenceUByte.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerSequencestring_TypeErrorCodeData(continuation: Continuation<List<String>>)
                      : UniFfiFutureCallbackHandlerSequencestring_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerSequencestring_TypeErrorCodeData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterSequenceString.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData(continuation: Continuation<List<AskarEntry>>)
                      : UniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterSequenceTypeAskarEntry.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData(continuation: Continuation<List<AskarKeyEntry>>)
                      : UniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData =
    UniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(ErrorCode, callStatus)
                    continuation.resume(FfiConverterSequenceTypeAskarKeyEntry.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )
actual fun createUniFfiFutureCallbackHandlerMapStringStringData(continuation: Continuation<Map<String, String>>)
                      : UniFfiFutureCallbackHandlerMapStringStringData =
    UniFfiFutureCallbackHandlerMapStringStringData(
        UniFfiFutureCallbackRustBuffer { _: ULong, returnValue: RustBuffer, callStatus: RustCallStatusByValue ->
           try {
                    checkCallStatus(NullCallStatusErrorHandler, callStatus)
                    continuation.resume(FfiConverterMapStringString.lift(returnValue!!))
                } catch (e: Throwable) {
                    continuation.resumeWithException(e)
                }
        },
        DropHandle(),
        // on the JVM, the continuation is held by UniFfiFutureCallbackHandleru64 so we do not need handle native
        // pointers. The JVM does not let us pass a dummy Pointer.NULL, so we insert some garbage that
        // must not be touched instead
        Pointer.createConstant(0xCAFED00DL)
    )

actual class DropHandle<T> {
    actual fun dropIt() {
        // no-op on the JVM
    }
}