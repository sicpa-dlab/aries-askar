package aries_askar


import kotlinx.coroutines.coroutineScope
import okio.Buffer
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface AskarScanInterface {
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `next`(): List<AskarEntry>?
    
    @Throws(ErrorCode::class, CancellationException::class)
    suspend fun `fetchAll`(): List<AskarEntry>
    
}

class AskarScan(
    pointer: Pointer
) : FFIObject(pointer), AskarScanInterface {

    override protected fun freeRustArcPtr() {
        rustCall() { status ->
            UniFFILib.uniffi_aries_askar_fn_free_askarscan(this.pointer, status)
        }
    }

    
    @Throws(ErrorCode::class, CancellationException::class)
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    override suspend fun `next`() : List<AskarEntry>? {
        // Create a new `CoroutineScope` for this operation, suspend the coroutine, and call the
        // scaffolding function, passing it one of the callback handlers from `AsyncTypes.kt`.
        //
        // Make sure to retain a reference to the callback handler to ensure that it's not GCed before
        // it's invoked
        var callbackDataHolder: UniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData? = null
        try {
            return coroutineScope {
                val scope = this
                return@coroutineScope suspendCoroutine { continuation ->
                    try {
                        val callbackData = createUniFfiFutureCallbackHandlerOptionalSequenceTypeAskarEntry_TypeErrorCodeData(continuation)
                        callbackDataHolder = callbackData
                        callWithPointer { thisPtr ->
                            rustCall { status ->
                                UniFFILib.uniffi_aries_askar_fn_method_askarscan_next(
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
    override suspend fun `fetchAll`() : List<AskarEntry> {
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
                                UniFFILib.uniffi_aries_askar_fn_method_askarscan_fetch_all(
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
    

    
}

object FfiConverterTypeAskarScan: FfiConverter<AskarScan, Pointer> {
    override fun lower(value: AskarScan): Pointer = value.callWithPointer { it }

    override fun lift(value: Pointer): AskarScan {
        return AskarScan(value)
    }

    override fun read(source: NoCopySource): AskarScan {
        return lift(source.readLong().toPointer())
    }

    override fun allocationSize(value: AskarScan) = 8

    override fun write(value: AskarScan, buf: Buffer) {
        buf.writeLong(lower(value).toLong())
    }
}