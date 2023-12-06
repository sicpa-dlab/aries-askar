package askar

import aries_askar.AskarKeyAlg
import askar.crypto.Jwk
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class ProtectedJson(val alg: String, val enc: String, val apu: String, val apv: String, val epk: Jwk) {

    constructor(alg: String, enc: AskarKeyAlg, apu: String, apv: String, epk: Jwk) : this(alg, enc.name, apu, apv, epk)

    override fun toString(): String {
        return Json.encodeToString(this)
    }
}