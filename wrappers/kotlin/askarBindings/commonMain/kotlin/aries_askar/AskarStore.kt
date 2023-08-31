package aries_askar


import kotlinx.coroutines.coroutineScope
import okio.Buffer
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface AskarStoreInterface {
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `getProfileName`(): String
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `createProfile`(`profile`: String?): String
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `removeProfile`(`profile`: String): Boolean
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `rekey`(`keyMethod`: String?, `passKey`: String?)
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `close`()
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `scan`(`profile`: String?, `categogy`: String, `tagFilter`: String?, `offset`: Long?, `limit`: Long?): AskarScan
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `session`(`profile`: String?): AskarSession
    
}

class AskarStore(
    pointer: Pointer
) : FFIObject(pointer), AskarStoreInterface {

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_askarstore(this.pointer, status)
        }
    }

    
    @Throws(ErrorCode::class, CancellationException::class)
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    override suspend fun `getProfileName`() : String {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerstring_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerstring_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarstore_get_profile_name(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    
                                    FfiConverterForeignExecutor.lower(scope),
                                    callbackData.resultHandler,
                                    callbackData.continuationRef,
                                    status,
                                )
                            }
                        }
                    } catch (e: Exception) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        } finally {
           callbackDataHolder?.dropHandle?.dropIt()
        }
    }
    
    @Throws(ErrorCode::class, CancellationException::class)
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    override suspend fun `createProfile`(`profile`: String?) : String {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerstring_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerstring_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarstore_create_profile(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterOptionalString.lower(`profile`),
                                    FfiConverterForeignExecutor.lower(scope),
                                    callbackData.resultHandler,
                                    callbackData.continuationRef,
                                    status,
                                )
                            }
                        }
                    } catch (e: Exception) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        } finally {
           callbackDataHolder?.dropHandle?.dropIt()
        }
    }
    
    @Throws(ErrorCode::class, CancellationException::class)
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    override suspend fun `removeProfile`(`profile`: String) : Boolean {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerbool_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerbool_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarstore_remove_profile(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`profile`),
                                    FfiConverterForeignExecutor.lower(scope),
                                    callbackData.resultHandler,
                                    callbackData.continuationRef,
                                    status,
                                )
                            }
                        }
                    } catch (e: Exception) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        } finally {
           callbackDataHolder?.dropHandle?.dropIt()
        }
    }
    
    @Throws(ErrorCode::class, CancellationException::class)
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    override suspend fun `rekey`(`keyMethod`: String?, `passKey`: String?) {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerVoid_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerVoid_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarstore_rekey(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterOptionalString.lower(`keyMethod`), FfiConverterOptionalString.lower(`passKey`),
                                    FfiConverterForeignExecutor.lower(scope),
                                    callbackData.resultHandler,
                                    callbackData.continuationRef,
                                    status,
                                )
                            }
                        }
                    } catch (e: Exception) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        } finally {
           callbackDataHolder?.dropHandle?.dropIt()
        }
    }
    
    @Throws(ErrorCode::class, CancellationException::class)
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    override suspend fun `close`() {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerVoid_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerVoid_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarstore_close(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    
                                    FfiConverterForeignExecutor.lower(scope),
                                    callbackData.resultHandler,
                                    callbackData.continuationRef,
                                    status,
                                )
                            }
                        }
                    } catch (e: Exception) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        } finally {
           callbackDataHolder?.dropHandle?.dropIt()
        }
    }
    
    @Throws(ErrorCode::class, CancellationException::class)
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    override suspend fun `scan`(`profile`: String?, `categogy`: String, `tagFilter`: String?, `offset`: Long?, `limit`: Long?) : AskarScan {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerTypeAskarScan_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarstore_scan(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterOptionalString.lower(`profile`), FfiConverterString.lower(`categogy`), FfiConverterOptionalString.lower(`tagFilter`), FfiConverterOptionalLong.lower(`offset`), FfiConverterOptionalLong.lower(`limit`),
                                    FfiConverterForeignExecutor.lower(scope),
                                    callbackData.resultHandler,
                                    callbackData.continuationRef,
                                    status,
                                )
                            }
                        }
                    } catch (e: Exception) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        } finally {
           callbackDataHolder?.dropHandle?.dropIt()
        }
    }
    
    @Throws(ErrorCode::class, CancellationException::class)
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    override suspend fun `session`(`profile`: String?) : AskarSession {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerTypeAskarSession_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarstore_session(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterOptionalString.lower(`profile`),
                                    FfiConverterForeignExecutor.lower(scope),
                                    callbackData.resultHandler,
                                    callbackData.continuationRef,
                                    status,
                                )
                            }
                        }
                    } catch (e: Exception) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        } finally {
           callbackDataHolder?.dropHandle?.dropIt()
        }
    }
    

    
}

object FfiConverterTypeAskarStore: FfiConverter<AskarStore, Pointer> {
    override fun lower(value: AskarStore): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): AskarStore {
        return AskarStore(value)
    }

    override fun read(source: NoCopySource): AskarStore {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: AskarStore) = 8

    override fun write(value: AskarStore, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}