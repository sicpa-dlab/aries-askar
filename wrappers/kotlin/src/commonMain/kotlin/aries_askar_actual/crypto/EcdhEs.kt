package aries_askar_actual.crypto

import aries_askar.AskarKeyAlg
import aries_askar.EncryptedBuffer

class EcdhEs(
    private val algId: String,
    private val apu: String,
    private val apv: String
) {
    private val askarEcdhEs = aries_askar.AskarEcdhEs(algId, apu, apv)


    fun deriveKey(
        encAlg: AskarKeyAlg,
        ephemeralKey: Key,
        recipientKey: Key,
        receive: Boolean,
    ): Key {
        return Key(
            askarEcdhEs.deriveKey(
                encAlg, ephemeralKey.handle(), recipientKey.handle(), receive
            )
        )
    }

    fun encryptDirect(
        encAlg: AskarKeyAlg,
        ephemeralKey: Key,
        recipientKey: Key,
        message: String,
        nonce: ByteArray? = null,
        aad: String? = null,
    ): EncryptedBuffer {
        val derived = this.deriveKey(encAlg, ephemeralKey, recipientKey, false)
        val encryptedBuffer = derived.aeadEncrypt(message, aad = aad?: "", nonce = nonce?: ByteArray(0))
        derived.free()
        return encryptedBuffer
    }

    fun encryptDirect(
        encAlg: AskarKeyAlg,
        ephemeralKey: Jwk,
        recipientKey: Jwk,
        message: String,
        nonce: ByteArray? = null,
        aad: String? = null,
    ): EncryptedBuffer {
        val derived = this.deriveKey(encAlg, Key.fromJwk(ephemeralKey), Key.fromJwk(recipientKey), false)
        val encryptedBuffer = derived.aeadEncrypt(message, aad = aad?: "", nonce = nonce?: ByteArray(1))
        derived.free()
        return encryptedBuffer
    }

    fun decryptDirect(
        encAlg: AskarKeyAlg,
        ephemeralKey: Key,
        recipientKey: Key,
        cipherText: ByteArray,
        nonce: ByteArray,
        aad: String? = null,
        tag: ByteArray,
    ): ByteArray {
        val derived = this.deriveKey(encAlg, ephemeralKey, recipientKey, false)
        val encryptedBuffer = derived.aeadDecrypt(cipherText, aad = aad?: "", tag = tag, nonce = nonce)
        derived.free()
        return encryptedBuffer
    }

    fun decryptDirect(
        encAlg: AskarKeyAlg,
        ephemeralKey: Jwk,
        recipientKey: Jwk,
        cipherText: ByteArray,
        nonce: ByteArray,
        aad: String? = null,
        tag: ByteArray,
    ): ByteArray {
        val derived = this.deriveKey(encAlg, Key.fromJwk(ephemeralKey), Key.fromJwk(recipientKey),  false)
        val encryptedBuffer = derived.aeadDecrypt(cipherText, aad = aad?: "", tag = tag, nonce = nonce)
        derived.free()
        return encryptedBuffer
    }

    fun senderWrapKey(
        wrapAlg: AskarKeyAlg,
        ephemeralKey: Key,
        recipientKey: Key,
        cek: Key,
    ): EncryptedBuffer {
        val derived = this.deriveKey(wrapAlg, ephemeralKey, recipientKey, false)
        val encryptedBuffer = derived.wrapKey(cek)
        derived.free()
        return encryptedBuffer
    }

    fun senderWrapKey(
        wrapAlg: AskarKeyAlg,
        ephemeralKey: Jwk,
        recipientKey: Jwk,
        cek: Key,
    ): EncryptedBuffer {
        val derived = this.deriveKey(wrapAlg, Key.fromJwk(ephemeralKey), Key.fromJwk(recipientKey), false)
        val encryptedBuffer = derived.wrapKey(cek)
        derived.free()
        return encryptedBuffer
    }

    fun receiverUnwrapKey(
        wrapAlg: AskarKeyAlg,
        encAlg: AskarKeyAlg,
        ephemeralKey: Key,
        recipientKey: Key,
        cipherText: ByteArray,
        nonce: ByteArray = byteArrayOf(),
        tag: String = "",
    ): Key {
        val derived = this.deriveKey(wrapAlg, ephemeralKey, recipientKey,true)
        val encryptedBuffer = derived.unwrapKey(encAlg, tag, cipherText, nonce)
        derived.free()
        return encryptedBuffer
    }

    fun receiverUnwrapKey(
        wrapAlg: AskarKeyAlg,
        encAlg: AskarKeyAlg,
        ephemeralKey: Jwk,
        recipientKey: Jwk,
        cipherText: ByteArray,
        nonce: ByteArray = byteArrayOf(),
        tag: String = "",
    ): Key {
        val derived = this.deriveKey(wrapAlg, Key.fromJwk(ephemeralKey), Key.fromJwk(recipientKey),true)
        val encryptedBuffer = derived.unwrapKey(encAlg, tag, cipherText, nonce)
        derived.free()
        return encryptedBuffer
    }

}