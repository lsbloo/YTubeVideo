package com.htk.ytubevideo.features.login.data.repository

import com.htk.ytubevideo.authentication.EmailAndPasswordCredentials
import com.htk.ytubevideo.authentication.FirebaseAuthenticator
import com.htk.ytubevideo.features.login.data.mapper.LoginAuthenticateSignInMapper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow


class LoginRepositoryImp(
    private val firebaseAuthenticator: FirebaseAuthenticator,
    private val mapper: LoginAuthenticateSignInMapper
) {

    fun onSignInEmailAndPassword(email: String, password: String) =
        firebaseAuthenticator.signIn(credentials = EmailAndPasswordCredentials.createCredentials {
            this.email = email
            this.password = password
        }).flatMapConcat { currentUser ->
            flow {
                emit(currentUser.let { mapper.map(it) })
            }
        }
}