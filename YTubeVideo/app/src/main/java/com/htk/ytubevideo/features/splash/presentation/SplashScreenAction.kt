package com.htk.ytubevideo.features.splash.presentation

import com.htk.ytubevideo.core.base.UIAction

sealed class SplashScreenAction : UIAction {
    object NavigateToLogin: SplashScreenAction()
}