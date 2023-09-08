package askar.store

import aries_askar.*
import askar.crypto.Key
import askar.toUbyteList

class Session(private var handle: AskarSession?, private val isTxn: Boolean) {


    fun isTransaction(): Boolean {
        return this.isTxn
    }

    fun handle(): AskarSession? {
        return this.handle
    }

    private fun assertHandle() {
        if(this.handle == null)
            throw Error("Cannot operate on a closed Session")
    }

    suspend fun count(category: String, tagFilter: String): Long {
        assertHandle()
        return handle!!.count(category, tagFilter)
    }

    suspend fun fetch(
        category: String,
        name: String,
        forUpdate: Boolean = false
    ): AskarEntry? {
        assertHandle()
        return handle!!.fetch(category, name, forUpdate)
    }

    suspend fun fetchAll(
        category: String,
        tagFilter: String = "{}",
        forUpdate: Boolean = false,
        limit: Long? = null
    ): List<AskarEntry> {
        assertHandle()
        return handle!!.fetchAll(category, tagFilter, limit, forUpdate)
    }

    suspend fun insert(
        category: String,
        name: String,
        expiryMs: Long? = null,
        tags: String? = null,
        value: String
    ) {
        assertHandle()
        handle!!.update(AskarEntryOperation.INSERT, category, name, value.toUbyteList(), tags, expiryMs)
    }

    suspend fun replace(
        category: String,
        name: String,
        expiryMs: Long? = null,
        tags: String?,
        value: String
    ) {
        assertHandle()
        handle!!.update(AskarEntryOperation.REPLACE, category, name, value.toUbyteList(), tags, expiryMs)
    }

    suspend fun remove(category: String, name: String): Boolean {
        assertHandle()
        return try {
            handle!!.update(AskarEntryOperation.REMOVE, category, name, listOf(), null, null)
            true
        } catch (_: Throwable) {
            false
        }
    }

    suspend fun insertKey(
        name: String,
        key: Key,
        expiryMs: Long? = null,
        metadata: String? = null,
        tags: String? = null
    ): Boolean {
        assertHandle()
        return try {
            handle!!.insertKey(name, key.handle(), metadata, tags, expiryMs)
            true
        } catch (_: Throwable) {
            false
        }
    }

    suspend fun fetchKey(
        name: String,
        forUpdate: Boolean = false
    ): AskarKeyEntry? {
        assertHandle()
        return handle!!.fetchKey(name, forUpdate)
    }

    suspend fun fetchAllKeys(
        algorithm: AskarKeyAlg? = null,
        thumbprint: String? = null,
        tagFilter: String? = null,
        limit: Long? = null,
        forUpdate: Boolean = false
    ) {
        assertHandle()
        handle!!.fetchAllKeys(algorithm?.name, thumbprint, tagFilter, limit, forUpdate)
    }

    suspend fun updateKey(
        name: String,
        metadata: String? = null,
        tags: String? = null,
        expiryMs: Long? = null
    ): Boolean {
        assertHandle()
        return try {
            handle!!.updateKey(name, metadata, tags, expiryMs)
            true
        } catch (_: Throwable) {
            false
        }
    }

    suspend fun removeKey(name: String): Boolean {
        assertHandle()
        return try {
            handle!!.removeKey(name)
            true
        } catch (_: Throwable){
            false
        }
    }

    suspend fun commit(): Boolean {
        assertHandle()
        if(!isTxn) throw Error("Session is a transaction cannot commit")
        return try {
            handle!!.close()
            this.handle = null
            true
        } catch (_: Throwable) {
            false
        }
    }

    suspend fun close(): Boolean {
        if(handle == null) throw Error("Cannot close a session that is already closed")
        return try {
            handle!!.close()
            handle = null
            true
        } catch (_: Throwable) {
            false
        }
    }
}