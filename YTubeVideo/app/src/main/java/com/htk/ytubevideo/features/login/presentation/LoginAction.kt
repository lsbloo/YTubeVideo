package com.htk.ytubevideo.features.login.presentation

import com.htk.ytubevideo.core.base.UIAction

sealed class LoginAction : UIAction {
    object NavigateToHome : LoginAction()
    object ShowMessageErrorSignIn : LoginAction()
}