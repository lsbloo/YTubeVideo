package com.htk.ytubevideo.authentication

class EmailAndPasswordCredentials : Credentials {

    override lateinit var email: String

    override lateinit var password: String

    companion object {
        fun createCredentials(block: EmailAndPasswordCredentials.() -> Unit) =
            EmailAndPasswordCredentials().apply { block() }
    }
}