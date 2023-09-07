package aries_askar_actual.crypto

import aries_askar.*
import aries_askar_actual.toUbyteList
import kotlinx.serialization.json.Json

enum class SigAlgs (val alg: String) {
    EdDSA("eddsa"),
    ES256("es256"),
    ES256K("es256k")
}

class Key(private val localKey: AskarLocalKey) {

    companion object {
        private val localKeyFactory = LocalKeyFactory()

        fun generate(algorithm: AskarKeyAlg, ephemeral: Boolean = false): Key {
            return Key(localKeyFactory.generate(algorithm, ephemeral))
        }

        fun fromSeed(method: SeedMethod? = null, algorithm: AskarKeyAlg, seed: String): Key {
            val seedList = seed.map {
                it.code.toUByte()
            }
            return Key(localKeyFactory.fromSeed(algorithm, seedList, method))
        }

        fun fromSecretBytes(algorithm: AskarKeyAlg, secretKey: ByteArray): Key
        {
            val secretKeyList = secretKey.map {
                it.toUByte()
            }
            return Key(localKeyFactory.fromSecretBytes(algorithm, secretKeyList))
        }

        fun fromPublicBytes(algorithm: AskarKeyAlg, publicKey: ByteArray): Key {
            val publicKeyList = publicKey.map{
                it.toUByte()
            }
            return Key(localKeyFactory.fromPublicBytes(algorithm, publicKeyList))
        }

        fun fromJwk(jwk: Jwk): Key {
            return Key(localKeyFactory.fromJwk(jwk.toString()))
        }
    }

    fun handle(): AskarLocalKey {
        return this.localKey
    }

    fun convertKey(algorithm: AskarKeyAlg): Key {
        return Key(localKey.convertKey(algorithm))
    }

    fun fromKeyExchange(algorithm: AskarKeyAlg, publicKey: Key): Key {
       return Key(localKey.toKeyExchange(algorithm, publicKey.handle()))
    }

    fun algorithm(): AskarKeyAlg {
        return localKey.algorithm()
    }

//    fun ephemeral(): Boolean {
//        TODO("Implement this in a future version that Uniffi has this method")
//    }

    fun publicBytes(): ByteArray {
        return localKey.toPublicBytes().toUByteArray().toByteArray()
    }

    fun secretBytes(): ByteArray {
        return localKey.toSecretBytes().toUByteArray().toByteArray()
    }

    fun jwkPublic(): Jwk {
        val jwkStr = localKey.toJwkPublic(this.algorithm())
        return Json.decodeFromString<Jwk>(jwkStr)
    }

    fun jwkSecret(): Jwk {
        val jwkStr = localKey.toJwkSecret()
        return Json.decodeFromString<Jwk>(jwkStr.toString())
    }

    fun jwkThumbprint(): String {
        return localKey.toJwkThumbprint(this.algorithm())
    }

    fun aeadParams(): AeadParams {
        return localKey.aeadParams()
    }

    fun aeadRandomNonce(): ByteArray {
        return localKey.aeadRandomNonce().toUByteArray().toByteArray()
    }

    fun aeadEncrypt(
        message: String,
        nonce: ByteArray = ByteArray(0),
        aad: String = ""
    ): EncryptedBuffer {
        val messageList = message.map {
            it.code.toUByte()
        }
        val nonceList = nonce.map{
            it.toUByte()
        }
        val aadList = aad.map{
            it.code.toUByte()
        }
        return localKey.aeadEncrypt(messageList, nonceList, aadList)
    }

    fun aeadEncrypt(
        message: String,
        nonce: ByteArray = ByteArray(0),
        aad: ByteArray = ByteArray(0)
    ): EncryptedBuffer {
        val messageList = message.map {
            it.code.toUByte()
        }
        val nonceList = nonce.map{
            it.toUByte()
        }
        val aadList = aad.map{
            it.toUByte()
        }
        return localKey.aeadEncrypt(messageList, nonceList, aadList)
    }

    fun aeadDecrypt(
        cipherText: ByteArray,
        nonce: ByteArray = ByteArray(0),
        tag: ByteArray = ByteArray(0),
        aad: String = ""
    ): ByteArray {
        return localKey.aeadDecrypt(
            cipherText.toUbyteList(),
            nonce.toUbyteList(),
            tag.toUbyteList(),
            aad.toUbyteList()
        ).toUByteArray().toByteArray()
    }

    fun signMessage(message: String, sigType: SigAlgs? = null): ByteArray {
        return localKey.signMessage(message.toUbyteList(), sigType?.alg).toUByteArray().toByteArray()
    }

    fun signMessage(message: ByteArray, sigType: SigAlgs? = null): ByteArray {
        return localKey.signMessage(message.toUbyteList(), sigType?.alg).toUByteArray().toByteArray()
    }

    fun verifySignature(message: String, signature: ByteArray, sigType: SigAlgs? = null): Boolean {
        return localKey.verifySignature(message.toUbyteList(), signature.toUbyteList(), sigType?.alg)
    }

    fun verifySignature(message: ByteArray, signature: ByteArray, sigType: SigAlgs? = null): Boolean {
        return localKey.verifySignature(message.toUbyteList(), signature.toUbyteList(), sigType?.alg)
    }

    fun wrapKey(other: Key, nonce: String = ""): EncryptedBuffer {
        return localKey.wrapKey(other.handle(), nonce.toUbyteList())
    }

    fun unwrapKey(algorithm: AskarKeyAlg, tag: String? = null, cipherText: ByteArray = ByteArray(0), nonce: ByteArray? = null): Key {
        return Key(localKey.unwrapKey(algorithm, cipherText.toUbyteList(),tag?.toUbyteList(), nonce?.toUbyteList()))
    }

    fun free() {
        localKey.destroy()
    }


}