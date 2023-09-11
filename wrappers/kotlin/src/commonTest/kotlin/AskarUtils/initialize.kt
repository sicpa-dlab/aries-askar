


import aries_askar.AskarEntry
import askar.store.KdfMethod
import askar.store.Store
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

fun getRawKey(): String {
    return Store.generateRawKey("00000000000000000000000000000My1")
}

//val firstEntry = AskarEntry("category-one", "test-entry", tags =
//mapOf(
//    Pair("~plaintag", JsonPrimitive("a")),
//    Pair("enctag", JsonPrimitive("b"))
//).mapToJsonObject().toString() , value = "foo"
//)


//val secondEntry = EntryObject("category-one", "secondEntry", tags =
//mapOf(
//    Pair("~plaintag", JsonPrimitive("a")),
//    Pair("enctag",JsonPrimitive("b"))
//).mapToJsonObject().toString(), value = buildJsonObject {
//    put("foo", "bar")
//}.toString())


//     const thirdEntry = {
//        category: 'category-one',
//        name: 'thirdEntry',
//        value: { foo: 'baz' },
//        tags: { '~plaintag': 'a', enctag: 'b' },
//    }


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

