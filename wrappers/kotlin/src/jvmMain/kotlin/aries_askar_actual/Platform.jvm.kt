package aries_askar_actual

class JVMPlatform: Platform{

    override val name: String = "JVM"

}

actual fun getPlatform(): Platform {
    return JVMPlatform()
}