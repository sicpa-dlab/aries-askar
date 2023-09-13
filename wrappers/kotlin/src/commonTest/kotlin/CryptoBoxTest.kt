import aries_askar.AskarKeyAlg
import askar.crypto.CryptoBox
import askar.crypto.Key

import kotlin.test.Test
import kotlin.test.assertEquals

class CryptoBoxTest {

    @Test
    fun seal() {
        val x25519Key = Key.generate(AskarKeyAlg.X25519)

        val message = "foobar"
        val sealed = CryptoBox.seal(x25519Key, message)

        val opened = CryptoBox.sealOpen(x25519Key, sealed)
        assertEquals(message, opened.decodeToString())

        x25519Key.handle().destroy()
    }
}