package aries_askar_actual.store

import aries_askar.AskarKeyAlg
import aries_askar.AskarScan
import aries_askar.AskarStore
import aries_askar.AskarStoreManager

enum class KdfMethod(val method: String) {
    Raw("raw"),
    None("None"),
    Argon2IMod("kdf:argon2i:mod"),
    Argon2IInt("kdf:argon2i:int")
}

class Store(private val handle: AskarStore, private val uri: String) {
    private var opener: OpenSession? = null

    fun handle(): AskarStore {
        return handle
    }

    fun uri(): String {
        return uri
    }

    suspend fun removeProfile(name: String): Boolean {
        return handle.removeProfile(name)
    }

    suspend fun createProfile(name: String = ""): String {
        return handle.createProfile(name)
    }

    suspend fun rekey(keyMethod: KdfMethod = KdfMethod.Argon2IInt, passKey: String): Boolean {
        return try {
            handle.rekey(keyMethod.method, passKey)
            true
        } catch (_: Throwable) {
            false
        }
    }

    suspend fun close(remove: Boolean = false): Boolean {
        this.opener = null
        handle.close()
        return if (remove) remove(this.uri) else false
    }

    fun session(profile: String? = null): OpenSession {
        return OpenSession(handle, profile, false)
    }

    fun transaction(profile: String = "local"): OpenSession {
        return OpenSession(handle, profile, true)
    }

    suspend fun openSession(isTxn: Boolean = false): Session {
        this.opener = OpenSession(handle, isTxn = isTxn)
        return opener!!.open()
    }

    suspend fun scan(
        category: String,
        tagFilter: String? = null,
        offset: Long? = null,
        limit: Long? = null,
        profile: String? = null
    ): AskarScan {
        return handle.scan(profile, category, tagFilter, offset, limit)
    }

    companion object {
        private val storeManger = AskarStoreManager()

        fun generateRawKey(seed: String? = null): String {
            return storeManger.generateRawStoreKey(seed)
        }

        suspend fun provision(
            uri: String,
            keyMethod: KdfMethod? = null,
            passKey: String? = null,
            profile: String? = null,
            recreate: Boolean
        ): Store {
            val handle = storeManger.provision(uri, keyMethod?.method, passKey, profile, recreate)
            return Store(handle, uri)
        }

        suspend fun open(
            uri: String,
            keyMethod: KdfMethod? = null,
            passKey: String? = null,
            profile: String? = null
        ): Store {
            val handle = storeManger.open(uri, keyMethod?.method, passKey, profile)
            return Store(handle, uri)
        }

        suspend fun remove(uri: String): Boolean {
            return storeManger.remove(uri)
        }
    }

}