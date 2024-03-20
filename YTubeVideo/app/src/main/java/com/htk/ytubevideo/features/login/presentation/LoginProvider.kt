package com.htk.ytubevideo.features.login.presentation

import com.htk.ytubevideo.features.login.domain.usecase.SignInAuthenticateFirebaseUseCase

data class LoginProvider(val signInAuthenticateFirebaseUseCase: SignInAuthenticateFirebaseUseCase)
