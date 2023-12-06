import aries_askar.AskarEntry
import askar.store.KdfMethod
import askar.store.Store
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

fun getRawKey(): String {
    return Store.generateRawKey("00000000000000000000000000000My1")
}

val firstEntry = TestEntry(
    "category-one",
    "test-entry",
    mapOf(Pair("plaintag", "a"), Pair("enctag", "b")),
    "foo"
)

val secondEntry = TestEntry(
    "category-one",
    "secondEntry",
    mapOf(
        Pair("plaintag", "a"),
        Pair("enctag", "b")
    ),
    buildJsonObject { put("foo", "bar") }.toString()
)

val thirdEntry = TestEntry(
    "category-one",
    "secondEntry",
    mapOf(
        Pair("~plaintag", "a"),
        Pair("enctag", "b")
    ),
    buildJsonObject { put("foo", "baz") }.toString()
)

@Serializable
class TestEntry(
    val category: String,
    val name: String,
    val tags: Map<String, String>,
    val value: String
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

val testStoreUri = "sqlite://${databaseUri()}/test.db"

suspend fun setupWallet(): Store {
    val key = getRawKey()
    return Store.provision(
        recreate = true,
        uri = testStoreUri,
        keyMethod = KdfMethod.Raw,
        passkey = key
    )
}

