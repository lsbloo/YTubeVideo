package com.htk.ytubevideo.authentication

interface OnAuthentication {
    fun onAuthenticationSuccessful(currentUser: CurrentUser)
    fun onAuthenticationFailure()
}