package askar.crypto

import aries_askar.AskarKeyAlg
import aries_askar.EncryptedBuffer
import askar.toUbyteList

class Ecdh1PU(
    private val algId: String,
    private val apu: String,
    private val apv: String
) {

    private val askarEcdh1Pu = aries_askar.AskarEcdh1Pu(algId, apu, apv)

    fun deriveKey(
        encAlg: AskarKeyAlg,
        ephemeralKey: Key,
        recipientKey: Key,
        senderKey: Key,
        receive: Boolean,
        ccTag: ByteArray = byteArrayOf()
    ): Key {
        return Key(
            askarEcdh1Pu.deriveKey(
                encAlg,
                ephemeralKey.handle(),
                senderKey.handle(),
                recipientKey.handle(),
                ccTag.toUbyteList(),
                receive
            )
        )
    }

    fun encryptDirect(
        encAlg: AskarKeyAlg,
        ephemeralKey: Key,
        recipientKey: Key,
        senderKey: Key,
        message: String,
        nonce: ByteArray? = null,
        aad: String? = null,
    ): EncryptedBuffer {
        val derived = this.deriveKey(encAlg, ephemeralKey, recipientKey, senderKey, false, ccTag = byteArrayOf())
        val buf = derived.aeadEncrypt(message, nonce = nonce?: byteArrayOf(), aad = aad?: "")
        derived.free()
        return buf
    }

    fun decryptDirect(
        encAlg: AskarKeyAlg,
        ephemeralKey: Key,
        recipientKey: Key,
        senderKey: Key,
        cipherText: ByteArray,
        nonce: ByteArray,
        aad: String? = null,
        tag: ByteArray,
    ): ByteArray {
        val derived = this.deriveKey(encAlg, ephemeralKey, recipientKey, senderKey, false, ccTag = byteArrayOf())
        val encryptedBuffer = derived.aeadDecrypt(cipherText, aad = aad?: "", tag = tag, nonce = nonce)
        derived.free()
        return encryptedBuffer
    }

    fun senderWrapKey(
        wrapAlg: AskarKeyAlg,
        ephemeralKey: Key,
        recipientKey: Key,
        senderKey: Key,
        cek: Key,
        ccTag: ByteArray
    ):EncryptedBuffer {
        val derived = this.deriveKey(wrapAlg, ephemeralKey, recipientKey, senderKey, false, ccTag)
        val encryptedBuffer = derived.wrapKey(cek)
        derived.free()
        return encryptedBuffer
    }

    fun receiverUnwrapKey(
        wrapAlg: AskarKeyAlg,
        encAlg: AskarKeyAlg,
        ephemeralKey: Key,
        recipientKey: Key,
        senderKey: Key,
        cipherText: ByteArray,
        nonce: ByteArray = byteArrayOf(),
        tag: String = "",
        ccTag: ByteArray = byteArrayOf()
    ): Key {
        val derived = this.deriveKey(wrapAlg, ephemeralKey, recipientKey, senderKey, false, ccTag)
        val encryptedBuffer = derived.unwrapKey(encAlg, tag, cipherText, nonce)
        derived.free()
        return encryptedBuffer
    }


}