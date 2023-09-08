package askar

import aries_askar.AskarCrypto
import aries_askar.AskarKeyAlg
import aries_askar.LocalKeyFactory
import org.junit.jupiter.api.Test

class JVMGreetingTest {

    @Test
    fun testExample() {
        println("Load askar")

        println("Yeet")
        val keyFactory = LocalKeyFactory()
        val crypto = AskarCrypto()

        val key = keyFactory.generate(alg = AskarKeyAlg.X25519, ephemeral = false)
    }
}
