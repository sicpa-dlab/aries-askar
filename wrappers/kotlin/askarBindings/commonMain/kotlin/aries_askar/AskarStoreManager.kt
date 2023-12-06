package aries_askar


import kotlinx.coroutines.coroutineScope
import okio.Buffer
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface AskarStoreManagerInterface {
    
    @Throws(ErrorCode::class)
    fun `generateRawStoreKey`(`seed`: String?): String
    
    @Throws(ErrorCode::class)
    fun `setDefaultLogger`()
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `provision`(`specUri`: String, `keyMethod`: String?, `passKey`: String?, `profile`: String?, `recreate`: Boolean): AskarStore
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `open`(`specUri`: String, `keyMethod`: String?, `passKey`: String?, `profile`: String?): AskarStore
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `remove`(`specUri`: String): Boolean
    
}

class AskarStoreManager(
    pointer: Pointer
) : FFIObject(pointer), AskarStoreManagerInterface {
    constructor() :
        this(
    rustCall() { _status ->
    UniFFILib.uniffi_aries_askar_fn_constructor_askarstoremanager_new( _status)
})

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_askarstoremanager(this.pointer, status)
        }
    }

    
    @Throws(ErrorCode::class)override fun `generateRawStoreKey`(`seed`: String?): String =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarstoremanager_generate_raw_store_key(it, FfiConverterOptionalString.lower(`seed`),  _status)
}
        }.let {
            FfiConverterString.lift(it)
        }
    
    
    @Throws(ErrorCode::class)override fun `setDefaultLogger`() =
        callWithPointer {
    rustCallWithError(ErrorCode) { _status ->
    UniFFILib.uniffi_aries_askar_fn_method_askarstoremanager_set_default_logger(it,  _status)
}
        }
    
    
    
    @Throws(ErrorCode::class, CancellationException::class)
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    override suspend fun `provision`(`specUri`: String, `keyMethod`: String?, `passKey`: String?, `profile`: String?, `recreate`: Boolean) : AskarStore {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarstoremanager_provision(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`specUri`), FfiConverterOptionalString.lower(`keyMethod`), FfiConverterOptionalString.lower(`passKey`), FfiConverterOptionalString.lower(`profile`), FfiConverterBoolean.lower(`recreate`),
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
    override suspend fun `open`(`specUri`: String, `keyMethod`: String?, `passKey`: String?, `profile`: String?) : AskarStore {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerTypeAskarStore_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarstoremanager_open(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`specUri`), FfiConverterOptionalString.lower(`keyMethod`), FfiConverterOptionalString.lower(`passKey`), FfiConverterOptionalString.lower(`profile`),
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
    override suspend fun `remove`(`specUri`: String) : Boolean {
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
                                UniFFILib.uniffi_aries_askar_fn_method_askarstoremanager_remove(
                                    thisPtr,
                                    // FIXME create macro that handles the comma
                                    FfiConverterString.lower(`specUri`),
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

object FfiConverterTypeAskarStoreManager: FfiConverter<AskarStoreManager, Pointer> {
    override fun lower(value: AskarStoreManager): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): AskarStoreManager {
        return AskarStoreManager(value)
    }

    override fun read(source: NoCopySource): AskarStoreManager {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: AskarStoreManager) = 8

    override fun write(value: AskarStoreManager, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}