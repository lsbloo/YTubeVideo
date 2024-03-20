package com.htk.ytubevideo.features.login.domain.usecase

import com.htk.ytubevideo.features.login.data.repository.LoginRepositoryImp

class SignInAuthenticateFirebaseUseCase(private val loginRepositoryImp: LoginRepositoryImp) {

    operator fun invoke(email: String, password: String) =
        loginRepositoryImp.onSignInEmailAndPassword(email, password)
}