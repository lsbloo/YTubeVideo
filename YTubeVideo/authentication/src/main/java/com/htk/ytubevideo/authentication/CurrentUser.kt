package com.htk.ytubevideo.authentication

import android.net.Uri

data class CurrentUser(
    var displayName: String? = null,
    var email: String? = null,
    var profilePhoto: Uri? = null,
    var isEmailVerified: Boolean? = null,
    var uid: String? = null,
    var signInMethod: String? = null
) {

    companion object {
        fun build(block: CurrentUser.() -> Unit): CurrentUser {
            val currentUser = CurrentUser()
            currentUser.block()
            return currentUser
        }
    }
}
