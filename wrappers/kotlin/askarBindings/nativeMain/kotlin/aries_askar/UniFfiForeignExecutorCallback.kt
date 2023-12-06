package aries_askar

import kotlinx.cinterop.CFunction
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.invoke
import kotlinx.cinterop.staticCFunction
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

typealias UniFfiRustTaskCallback = CPointer<CFunction<(Pointer?) -> Unit>>

@Suppress("ACTUAL_WITHOUT_EXPECT", "ACTUAL_TYPE_ALIAS_WITH_COMPLEX_SUBSTITUTION")
actual typealias UniFfiForeignExecutorCallback = CPointer<CFunction<(ULong, UInt, UniFfiRustTaskCallback?, Pointer?) -> Unit>>

// TODO find a way to unify this with the JVM source? The issue is that with JNA, UniFfiRustTaskCallback is (must be?)
//      an interface implementing jna.Callback. On Native, it is (must be?) a CPointer which is a class, not an interface
//      `expect typealias UniFfiRustTaskCallback` could be a solution but that is currently not allowed
fun invokeUniFfiForeignExecutorCallback(
    handle: ULong,
    delayMs: Int,
    rustTask: UniFfiRustTaskCallback?,
    rustTaskData: Pointer?
) {
    if (rustTask == null) {
        FfiConverterForeignExecutor.drop(handle)
    } else {
        val coroutineScope = FfiConverterForeignExecutor.lift(handle)
        coroutineScope.launch {
            if (delayMs > 0) {
                delay(delayMs.toLong())
            }
            rustTask.invoke(rustTaskData)
        }
    }
}

actual fun createUniFfiForeignExecutorCallback(): UniFfiForeignExecutorCallback =
    staticCFunction { handle, delayMs, rustTask, rustTaskData ->
        // FIXME the rusty delayMs is an u32, so Int was probalby the wrong type all along?
        //       fix the java types so no negative values are created here
        invokeUniFfiForeignExecutorCallback(handle, delayMs.toInt(), rustTask, rustTaskData)
    }