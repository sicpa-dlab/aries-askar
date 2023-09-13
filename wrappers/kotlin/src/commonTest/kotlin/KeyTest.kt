import aries_askar.AskarKeyAlg
import aries_askar.SeedMethod
import askar.crypto.Key
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class KeyTest {

    fun List<UByte>.toByteArray(): ByteArray {
      return this.toUByteArray().toByteArray()
    }

    /**
     * aes cbc hmac
     */
    @Test
    fun aesAlgTest() {
        runBlocking {
            val key = Key.generate(AskarKeyAlg.A128_CBC_HS256)
            assertEquals(key.algorithm(), AskarKeyAlg.A128_CBC_HS256)
            val message = "test message"
            val aeadNonce = key.aeadRandomNonce()
            val params = key.aeadParams()
            assertEquals(16, params.nonceLength)
            assertEquals(16, params.tagLength)
            val enc = key.aeadEncrypt(message = message, nonce = aeadNonce)
            val dec = key.aeadDecrypt(enc.ciphertext().toByteArray(), nonce = enc.nonce().toByteArray(), tag = enc.tag().toByteArray())
            assertEquals(message, dec.decodeToString())
        }
    }

    @Test
    fun blsG2KeyGen() {
        val seed = "testseed000000000000000000000001"
        val key = Key.fromSeed(algorithm = AskarKeyAlg.BLS12_381G2, seed = seed)

        val jwk = key.jwkPublic()

        assertEquals("BLS12381_G2", jwk.crv)
        assertEquals("OKP", jwk.kty)
        assertEquals(
            "lH6hIRPzjlKW6LvPm0sHqyEbGqf8ag7UWpA_GFfefwq_kzDXSHmls9Yoza_be23zEw-pSOmKI_MGR1DahBa7Jbho2BGwDNV_QmyhxMYBwTH12Ltk_GLyPD4AP6pQVgge",
            jwk.x
        )

        key.handle().destroy()
    }

    @Test
    fun blsG1KeyGen() {
        val seed = "testseed000000000000000000000001"
        val key = Key.fromSeed(algorithm = AskarKeyAlg.BLS12_381G1, seed = seed)

        val jwk = key.jwkPublic()

        assertEquals("BLS12381_G1", jwk.crv)
        assertEquals("OKP", jwk.kty)
        assertEquals(
            "hsjb9FSBUJXuB1fCluEcUBLeAPgIbnZGfxPKyeN3LVjQaKFWzXfNtMFAY8VL-eu-",
            jwk.x
        )

        key.handle().destroy()
    }

    @Test
    fun blsG1G2KeyGen() {
        val seed = "testseed000000000000000000000001"
        val key = Key.fromSeed(algorithm = AskarKeyAlg.BLS12_381G1G2, seed = seed, method = SeedMethod.BLS_KEY_GEN)

        val jwk = key.jwkPublic()

        assertEquals("BLS12381_G1G2", jwk.crv)
        assertEquals("OKP", jwk.kty)
        assertEquals(
            "h56eYI8Qkq5hitICb-ik8wRTzcn6Fd4iY8aDNVc9q1xoPS3lh4DB_B4wNtar1HrViZIOsO6BgLV72zCrBE2ym3DEhDYcghnUMO4O8IVVD8yS-C_zu6OA3L-ny-AO4rbkAo-WuApZEjn83LY98UtoKpTufn4PCUFVQZzJNH_gXWHR3oDspJaCbOajBfm5qj6d"
            ,jwk.x
        )

        key.handle().destroy()
    }

    @Test
    fun ed25519() {
        val key = Key.generate(AskarKeyAlg.ED25519)
        assertEquals(key.algorithm(), AskarKeyAlg.ED25519)
        val message = "Test Message"
        val signature = key.signMessage(message)
        assertTrue(key.verifySignature(message, signature))

        val messageBuffer = message.encodeToByteArray()
        val byteSignature = key.signMessage(messageBuffer)
        assertTrue(key.verifySignature(messageBuffer, byteSignature))

        val x25519Key = key.convertKey(AskarKeyAlg.X25519)
        val x25519Key2 = Key.generate(AskarKeyAlg.X25519)

        val kex = x25519Key.fromKeyExchange(AskarKeyAlg.XC20P, x25519Key2)
        assertIs<Key>(kex)

        val jwkPub = key.jwkPublic()
        val jwkSec = key.jwkSecret()

        assertEquals("OKP", jwkPub.kty)
        assertEquals("Ed25519", jwkPub.crv)

        assertEquals("OKP", jwkSec.kty)
        assertEquals("Ed25519", jwkSec.crv)

        key.handle().destroy()
        x25519Key.handle().destroy()
        x25519Key2.handle().destroy()
        kex.handle().destroy()
    }

}


