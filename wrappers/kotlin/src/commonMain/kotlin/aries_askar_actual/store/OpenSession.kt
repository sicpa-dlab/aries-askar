package aries_askar_actual.store

import aries_askar.AskarStore

class OpenSession(private val store: AskarStore, private val profile: String? = null, private val isTxn: Boolean) {
    private var session: Session? = null

    suspend fun open(): Session {
        if(session != null) throw Error("Session is already opened")
        val sessionHandle = store.session(profile)
        return Session(sessionHandle, isTxn)
    }
}