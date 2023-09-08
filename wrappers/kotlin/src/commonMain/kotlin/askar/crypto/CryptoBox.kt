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

        fun cryptoBox(recipientKey: AskarLocalKey, senderKey: AskarLocalKey, message: String, nonce: ByteArray): ByteArray {
            val messageList = message.map{
                it.code.toUByte()
            }
            val nonceList = nonce.map{
                it.toUByte()
            }
            return crypto.cryptoBox(recipientKey, senderKey, messageList, nonceList).toUByteArray().toByteArray()
        }

        fun cryptoBox(recipientKey: AskarLocalKey, senderKey: AskarLocalKey, message: ByteArray, nonce: ByteArray): ByteArray {
            val messageList = message.map{
                it.toUByte()
            }
            val nonceList = nonce.map{
                it.toUByte()
            }
            return crypto.cryptoBox(recipientKey, senderKey, messageList, nonceList).toUByteArray().toByteArray()
        }

        fun open(recipientKey: AskarLocalKey, senderKey: AskarLocalKey, message: ByteArray, nonce: ByteArray): ByteArray {
            val messageList = message.map{
                it.toUByte()
            }
            val nonceList = nonce.map{
                it.toUByte()
            }
            return crypto.boxOpen(recipientKey, senderKey, messageList, nonceList).toUByteArray().toByteArray()
        }

        fun seal(recipientKey: AskarLocalKey, message: ByteArray): ByteArray {
            val messageList = message.map   {
                it.toUByte()
            }
            return crypto.boxSeal(recipientKey, messageList).toUByteArray().toByteArray()
        }

        fun seal(recipientKey: AskarLocalKey, message: String): ByteArray {
            val messageList = message.map   {
                it.code.toUByte()
            }
            return crypto.boxSeal(recipientKey, messageList).toUByteArray().toByteArray()
        }

        fun sealOpen(recipientKey: AskarLocalKey, cipherText: ByteArray): ByteArray {
            val cipherList = cipherText.map {
                it.toUByte()
            }
            return crypto.boxSealOpen(recipientKey, cipherList).toUByteArray().toByteArray()
        }



    }
}