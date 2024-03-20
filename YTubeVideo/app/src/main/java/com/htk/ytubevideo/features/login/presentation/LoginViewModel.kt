package com.htk.ytubevideo.features.login.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.htk.ytubevideo.core.base.BaseViewModel
import com.htk.ytubevideo.core.base.UIState
import com.htk.ytubevideo.core.extensions.launchScopedFun
import com.htk.ytubevideo.core.navigation.RouterNavigation
import com.htk.ytubevideo.features.login.data.model.LoginAuthenticateCredentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

class LoginViewModel(
    private val routerNavigation: RouterNavigation,
    private val loginProvider: LoginProvider
) :
    BaseViewModel<LoginAction, UIState>(routerNavigation) {

    var userNameInputText = mutableStateOf<String>(value = "")

    var passwordInputText = mutableStateOf<String>(value = "")

    fun submitLogin(email: String, password: String) {
        viewModelScope.launchScopedFun(
            data = loginProvider.signInAuthenticateFirebaseUseCase(email, password),
            onCollect = {
            saveCredentialsAndNavigateToHome(it)
            },
            onCatch = {
                handleError(it)
            }
        )
    }

    fun handleError(throwable: Throwable?) {
        sendAction {
            LoginAction.ShowMessageErrorSignIn
        }
    }

    fun saveCredentialsAndNavigateToHome(loginAuthenticateCredentials: LoginAuthenticateCredentials) {
        sendAction { LoginAction.NavigateToHome }
    }

    fun onValidateUsernameAndPassword() {}

}