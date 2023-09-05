package askar.aries_askar_actual

import kotlin.experimental.ExperimentalNativeApi

class NativePlatform: aries_askar_actual.Platform {

    @OptIn(ExperimentalNativeApi::class)
    override val name: String = "$Platform"
}

actual fun getPlatform(): aries_askar_actual.Platform {
    return NativePlatform()
}