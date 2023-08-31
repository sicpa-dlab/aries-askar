package aries_askar


import kotlinx.coroutines.coroutineScope
import okio.Buffer
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface AskarSessionInterface {
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `close`()
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `count`(`category`: String, `tagFilter`: String?): Long
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `fetch`(`category`: String, `name`: String, `forUpdate`: Boolean): AskarEntry?
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `fetchAll`(`category`: String, `tagFilter`: String?, `limit`: Long?, `forUpdate`: Boolean): List<AskarEntry>
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `update`(`operation`: AskarEntryOperation, `category`: String, `name`: String, `value`: List<UByte>, `tags`: String?, `expiryMs`: Long?)
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `removeAll`(`category`: String, `tagFilter`: String?): Long
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `insertKey`(`name`: String, `key`: AskarLocalKey, `metadata`: String?, `tags`: String?, `expiryMs`: Long?)
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `fetchKey`(`name`: String, `forUpdate`: Boolean): AskarKeyEntry?
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `fetchAllKeys`(`algorithm`: String?, `thumbprint`: String?, `tagFilter`: String?, `limit`: Long?, `forUpdate`: Boolean): List<AskarKeyEntry>
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `removeKey`(`name`: String)
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `updateKey`(`name`: String, `metadata`: String?, `tags`: String?, `expiryMs`: Long?)
    
}

class AskarSession(
    pointer: Pointer
) : FFIObject(pointer), AskarSessionInterface {

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_askarsession(this.pointer, status)
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
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_close(
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
    override suspend fun `count`(`category`: String, `tagFilter`: String?) : Long {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandleri64_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandleri64_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_count(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`category`), FfiConverterOptionalString.lower(`tagFilter`),
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
    override suspend fun `fetch`(`category`: String, `name`: String, `forUpdate`: Boolean) : AskarEntry? {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerOptionalTypeAskarEntry_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_fetch(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`category`), FfiConverterString.lower(`name`), FfiConverterBoolean.lower(`forUpdate`),
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
    override suspend fun `fetchAll`(`category`: String, `tagFilter`: String?, `limit`: Long?, `forUpdate`: Boolean) : List<AskarEntry> {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerSequenceTypeAskarEntry_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_fetch_all(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`category`), FfiConverterOptionalString.lower(`tagFilter`), FfiConverterOptionalLong.lower(`limit`), FfiConverterBoolean.lower(`forUpdate`),
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
    override suspend fun `update`(`operation`: AskarEntryOperation, `category`: String, `name`: String, `value`: List<UByte>, `tags`: String?, `expiryMs`: Long?) {
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
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_update(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterTypeAskarEntryOperation.lower(`operation`), FfiConverterString.lower(`category`), FfiConverterString.lower(`name`), FfiConverterSequenceUByte.lower(`value`), FfiConverterOptionalString.lower(`tags`), FfiConverterOptionalLong.lower(`expiryMs`),
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
    override suspend fun `removeAll`(`category`: String, `tagFilter`: String?) : Long {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandleri64_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandleri64_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_remove_all(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`category`), FfiConverterOptionalString.lower(`tagFilter`),
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
    override suspend fun `insertKey`(`name`: String, `key`: AskarLocalKey, `metadata`: String?, `tags`: String?, `expiryMs`: Long?) {
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
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_insert_key(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`name`), FfiConverterTypeAskarLocalKey.lower(`key`), FfiConverterOptionalString.lower(`metadata`), FfiConverterOptionalString.lower(`tags`), FfiConverterOptionalLong.lower(`expiryMs`),
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
    override suspend fun `fetchKey`(`name`: String, `forUpdate`: Boolean) : AskarKeyEntry? {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerOptionalTypeAskarKeyEntry_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_fetch_key(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`name`), FfiConverterBoolean.lower(`forUpdate`),
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
    override suspend fun `fetchAllKeys`(`algorithm`: String?, `thumbprint`: String?, `tagFilter`: String?, `limit`: Long?, `forUpdate`: Boolean) : List<AskarKeyEntry> {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerSequenceTypeAskarKeyEntry_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_fetch_all_keys(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterOptionalString.lower(`algorithm`), FfiConverterOptionalString.lower(`thumbprint`), FfiConverterOptionalString.lower(`tagFilter`), FfiConverterOptionalLong.lower(`limit`), FfiConverterBoolean.lower(`forUpdate`),
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
    override suspend fun `removeKey`(`name`: String) {
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
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_remove_key(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`name`),
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
    override suspend fun `updateKey`(`name`: String, `metadata`: String?, `tags`: String?, `expiryMs`: Long?) {
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
                                UniFFILib.uniffi_aries_askar_fn_method_askarsession_update_key(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`name`), FfiConverterOptionalString.lower(`metadata`), FfiConverterOptionalString.lower(`tags`), FfiConverterOptionalLong.lower(`expiryMs`),
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

object FfiConverterTypeAskarSession: FfiConverter<AskarSession, Pointer> {
    override fun lower(value: AskarSession): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): AskarSession {
        return AskarSession(value)
    }

    override fun read(source: NoCopySource): AskarSession {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: AskarSession) = 8

    override fun write(value: AskarSession, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}