import aries_askar.AskarEntry
import aries_askar.AskarKeyAlg
import aries_askar.AskarStoreManager
import askar.crypto.Key
import askar.store.KdfMethod
import askar.store.Store
import askar.toUbyteList
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import kotlin.test.*
import kotlin.test.Test


expect fun databaseUri(): String

class AskarTest {


    private var store: Store? = null

    @BeforeTest
    fun beforeEach() {
        runBlocking {
            store = setupWallet()
        }
    }

    @AfterTest
    fun afterEach() {
        runBlocking {
            store?.close()
        }
    }

    @Test
    fun argon2imod() {
        runBlocking {
            val argonStore = Store.provision(
                recreate = true,
                passkey = "abc",
                uri = testStoreUri + "1", //Cannot have duplicate URI otherwise error is thrown
                keyMethod = KdfMethod.Argon2IMod,
                profile = "test"
            )

            assertEquals(testStoreUri + "1", argonStore.uri())

            val session = argonStore.openSession()
            val entry = session.fetch("unknownCategory", "unknownKey")
            assertNull(entry)
            session.close()
            argonStore.close()
        }
    }

    @Test
    fun argon2iint() {
        runBlocking {
            val argonStore = Store.provision(
                recreate = true,
                passkey = "abc",
                uri = testStoreUri + "1", //Cannot have duplicate URI otherwise error is thrown
                keyMethod = KdfMethod.Argon2IInt,
                profile = "test"
            )

            val session = argonStore.openSession()
            assertNull(session.fetch("unknownCategory", "unknownKey"))
            session.close()
            argonStore.close()
        }
    }

    @Test
    fun rekey() {
        runBlocking {
            val initialKey = Store.generateRawKey("1234")
            var newStore = Store.provision(
                recreate = true,
                profile = "rekey",
                uri = "sqlite://${databaseUri()}/rekey.db",
                keyMethod = KdfMethod.Raw,
                passkey = initialKey
            )
            val newKey = Store.generateRawKey("12345")
            newStore.rekey(KdfMethod.Raw, newKey)
            newStore.close()
            assertFails {
                Store.open(
                    profile = "rekey",
                    uri = "sqlite://${databaseUri()}/rekey.db",
                    keyMethod = KdfMethod.Raw,
                    passkey = initialKey
                )
            }
            println("store rekeyed")
            newStore = Store.open(
                profile = "rekey",
                uri = "sqlite://${databaseUri()}/rekey.db",
                keyMethod = KdfMethod.Raw,
                passkey = newKey
            )
            newStore.close(true)
        }
    }

    @Test
    fun insert() {
        runBlocking {
            val session = store!!.openSession()
            session.insert(
                firstEntry.category,
                firstEntry.name,
                value = firstEntry.value,
                tags = Json.encodeToString(firstEntry.tags)
            )
            assertEquals(1, session.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))

            session.close()
        }
    }

    @Test
    fun replace() {
        runBlocking {
            val session = store!!.openSession()
            session.insert(
                firstEntry.category,
                firstEntry.name,
                value = firstEntry.value,
                tags = Json.encodeToString(firstEntry.tags)
            )
            assertEquals(1, session.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))

            val updatedEntry = TestEntry(
                firstEntry.category, firstEntry.name, value = "bar", tags = mapOf(Pair("foo", "bar"))
            )
            println(updatedEntry)
            session.replace(
                updatedEntry.category,
                updatedEntry.name,
                value = updatedEntry.value,
                tags = Json.encodeToString(updatedEntry.tags)
            )
            assertEquals(1, session.count(updatedEntry.category, Json.encodeToString(updatedEntry.tags)))
            session.close()
        }
    }

    @Test
    fun remove() {
        runBlocking {
            val session = store!!.openSession()
            session.insert(
                firstEntry.category,
                firstEntry.name,
                value = firstEntry.value,
                tags = Json.encodeToString(firstEntry.tags)
            )

            assertEquals(1, session.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))

            session.remove(firstEntry.category, firstEntry.name)

            assertEquals(0, session.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))

            session.close()
        }
    }

    @Test
    fun removeAll() {
        runBlocking {
            val session = store!!.openSession()
            session.insert(
                firstEntry.category,
                firstEntry.name,
                value = firstEntry.value,
                tags = Json.encodeToString(firstEntry.tags)
            )
            session.insert(
                secondEntry.category,
                secondEntry.name,
                value = secondEntry.value,
                tags = Json.encodeToString(secondEntry.tags)
            )

            assertEquals(2, session.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))

            session.removeAll(firstEntry.category)

            assertEquals(0, session.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))

            session.close()
        }
    }

    @Test
    fun scan() {
        runBlocking {
            val session = store!!.openSession()
            session.insert(
                firstEntry.category,
                firstEntry.name,
                value = firstEntry.value,
                tags = Json.encodeToString(firstEntry.tags)
            )
            session.insert(
                category = secondEntry.category,
                name = secondEntry.name,
                value = secondEntry.value,
                tags = Json.encodeToString(firstEntry.tags)
            )

            val found = store!!.scan(category = firstEntry.category).fetchAll()

            assertEquals(2, found.size)

            session.close()
        }
    }

    private fun compareEntry(askarEntry: AskarEntry, testEntry: TestEntry): Boolean {
        if (askarEntry.category() != testEntry.category) return false
        if (askarEntry.name() != testEntry.name) return false
        if (askarEntry.value() != testEntry.value.toUbyteList()) return false
        if (askarEntry.tags() != testEntry.tags) return false
        return true
    }


    @Test
    fun transactionBasic() {
        runBlocking {
            var txn = store!!.openSession(true)

            txn.insert(
                firstEntry.category,
                firstEntry.name,
                value = firstEntry.value,
                tags = Json.encodeToString(firstEntry.tags)
            )

            val count = txn.count(firstEntry.category, Json.encodeToString(firstEntry.tags))

            assertEquals(1, count)

            val ret = txn.fetch(firstEntry.category, firstEntry.name) ?: throw Error("should not happen")

            txn.commit()

            assertTrue(compareEntry(ret, firstEntry))

            txn = store!!.openSession(true)

            val found = txn.fetchAll(firstEntry.category)

            txn.commit()

            assertTrue(compareEntry(found[0], firstEntry))

            val session = store!!.openSession()

            val fetch = session.fetch(firstEntry.category, firstEntry.name) ?: throw Error("could not fetch entry")

            assertTrue(compareEntry(fetch, firstEntry))

            session.close()
        }
    }

    @Test
    fun keyStore() {
        runBlocking {
            var session = store!!.openSession()

            val key = Key.generate(AskarKeyAlg.ED25519)

            val keyName = "testKey"

            session.insertKey(keyName, key, metadata = "metadata", tags = Json.encodeToString(mapOf(Pair("a", "b"))))

            val fetchedKey = session.fetchKey(keyName) ?: throw Error("Key was not fetched")
            session.close()

            assertEquals(fetchedKey.algorithm(), AskarKeyAlg.ED25519.name.lowercase())
            assertEquals(fetchedKey.name(), keyName)
            assertEquals(fetchedKey.metadata(), "metadata")
            assertEquals(mapOf(Pair("a", "b")) , fetchedKey.tags())

            session = store!!.openSession()

            session.updateKey(
                keyName,
                "updated metadata",
                tags = Json.encodeToString(mapOf(Pair("a", "c")))
            )

            val updatedFetch = session.fetchKey(keyName)
            session.close()

            assertNotEquals(fetchedKey, updatedFetch)

            val ptr = fetchedKey.loadLocalKey()
            val newKey = Key(ptr)

            assertEquals(key.jwkThumbprint(), newKey.jwkThumbprint())

            session = store!!.openSession()

            val found = session.fetchAllKeys(
                AskarKeyAlg.ED25519,
                key.jwkThumbprint(),
                Json.encodeToString(mapOf(Pair("a", "c"))),
            )

            session.close()

            assertEquals(found[0].algorithm(), updatedFetch?.algorithm())
            assertEquals(found[0].tags(), updatedFetch?.tags())
            assertEquals(found[0].name(), updatedFetch?.name())
            assertEquals(found[0].metadata(), updatedFetch?.metadata())


            session = store!!.openSession()
            session.removeKey(keyName)

            assertNull(session.fetchKey(keyName))

            session.close()

            key.handle().destroy()
            newKey.handle().destroy()
            fetchedKey.destroy()
            updatedFetch?.destroy()
            found.forEach { entry -> entry.destroy() }
        }
    }


    @Test
    fun profile() {
        runBlocking {
            val session = store!!.openSession()
            session.insert(firstEntry.category, firstEntry.name, value = firstEntry.value, tags = Json.encodeToString(firstEntry.tags))
            session.close()

            val profile = store!!.createProfile()

            val session2 = store!!.session(profile).open()
            assertEquals(0, session2.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))
            session2.insert(firstEntry.category, firstEntry.name, value = firstEntry.value, tags = Json.encodeToString(firstEntry.tags))
            assertEquals(1, session2.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))
            session2.close()

            //TODO: Find out why this fails
//            if(!store.uri().contains(":memory:")){
//                val key = getRawKey()!!
//                val store2 = Store.open(testStoreUri, StoreKeyMethod(KdfMethod.Raw), passkey = key)
//                val session3 = store2.openSession()
//                assertEquals(0, session3.count(firstEntry.category, firstEntry.tags))
//                session3.close()
//                store2.close()
//            }

            assertFails { store!!.createProfile(profile) }

            val session4 = store!!.session(profile).open()
            assertEquals(1, session4.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))
            session4.close()

            store!!.removeProfile(profile)

            val session5 = store!!.session(profile).open()
            assertEquals(0, session5.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))
            session5.close()

            val session6 = store!!.session("unknown profile").open()
            assertFails { session6.count(firstEntry.category, Json.encodeToString(firstEntry.tags)) }
            session6.close()

            val session7 = store!!.session(profile).open()
            assertEquals(0, session7.count(firstEntry.category, Json.encodeToString(firstEntry.tags)))
            session7.close()
        }
    }
}