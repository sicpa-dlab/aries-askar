@file:OptIn(ExperimentalUnsignedTypes::class)

package askar.crypto

import aries_askar.AskarLocalKey

class CryptoBox {

    companion object {
        private val crypto = aries_askar.AskarCrypto()

        fun randomNonce(): ByteArray {
            val temp = crypto.randomNonce()
            return temp.toUByteArray().toByteArray()
        }

        fun cryptoBox(recipientKey: Key, senderKey: Key, message: String, nonce: ByteArray): ByteArray {
            val messageList = message.map{
                it.code.toUByte()
            }
            val nonceList = nonce.map{
                it.toUByte()
            }
            return crypto.cryptoBox(recipientKey.handle(), senderKey.handle(), messageList, nonceList).toUByteArray().toByteArray()
        }

        fun cryptoBox(recipientKey: Key, senderKey: Key, message: ByteArray, nonce: ByteArray): ByteArray {
            val messageList = message.map{
                it.toUByte()
            }
            val nonceList = nonce.map{
                it.toUByte()
            }
            return crypto.cryptoBox(recipientKey.handle(), senderKey.handle(), messageList, nonceList).toUByteArray().toByteArray()
        }

        fun open(recipientKey: Key, senderKey: Key, message: ByteArray, nonce: ByteArray): ByteArray {
            val messageList = message.map{
                it.toUByte()
            }
            val nonceList = nonce.map{
                it.toUByte()
            }
            return crypto.boxOpen(recipientKey.handle(), senderKey.handle(), messageList, nonceList).toUByteArray().toByteArray()
        }

        fun seal(recipientKey: Key, message: ByteArray): ByteArray {
            val messageList = message.map   {
                it.toUByte()
            }
            return crypto.boxSeal(recipientKey.handle(), messageList).toUByteArray().toByteArray()
        }

        fun seal(recipientKey: Key, message: String): ByteArray {
            val messageList = message.map   {
                it.code.toUByte()
            }
            return crypto.boxSeal(recipientKey.handle(), messageList).toUByteArray().toByteArray()
        }

        fun sealOpen(recipientKey: Key, cipherText: ByteArray): ByteArray {
            val cipherList = cipherText.map {
                it.toUByte()
            }
            return crypto.boxSealOpen(recipientKey.handle(), cipherList).toUByteArray().toByteArray()
        }



    }
}