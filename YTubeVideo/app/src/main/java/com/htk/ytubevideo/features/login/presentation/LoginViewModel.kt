package com.htk.ytubevideo.features.login.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.htk.ytubevideo.core.base.BaseViewModel
import com.htk.ytubevideo.core.base.UIState
import com.htk.ytubevideo.core.extensions.launchScopedFun
import com.htk.ytubevideo.core.navigation.RouterNavigation
import com.htk.ytubevideo.core.navigation.RouterNavigationEnum
import com.htk.ytubevideo.features.login.data.model.LoginAuthenticateCredentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

class LoginViewModel(
    private val routerNavigation: RouterNavigation,
    private val loginProvider: LoginProvider
) :
    BaseViewModel<LoginAction, LoginState>(routerNavigation, LoginState()) {

    var userNameInputText = mutableStateOf<String>(value = "")

    var passwordInputText = mutableStateOf<String>(value = "")

    fun submitLogin(email: String, password: String) {
        viewModelScope.launchScopedFun(
            data = loginProvider.signInAuthenticateFirebaseUseCase(email, password),
            onStart = ::showLoading,
            onCollect = ::saveCredentialsAndNavigateToHome,
            onCatch = ::handleError,
        )
    }

    fun handleError(throwable: Throwable?) {
        hideLoading()

        sendAction {
            LoginAction.ShowMessageErrorSignIn
        }
    }

    fun saveCredentialsAndNavigateToHome(loginAuthenticateCredentials: LoginAuthenticateCredentials) {
        hideLoading()
        sendAction { LoginAction.NavigateToHome }
    }

    fun onValidateUsernameAndPassword() {}

    fun redirectToHomeScreen() =
        routerNavigation.navigateTo(RouterNavigationEnum.HOME_SCREEN)


    private fun hideLoading() {
        setState {
            LoginState(showLoading = false)
        }
    }

    private fun showLoading() {
        setState {
            LoginState(showLoading = true)
        }
    }
}