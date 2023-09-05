package aries_askar_actual

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform