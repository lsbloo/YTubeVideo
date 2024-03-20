package com.htk.ytubevideo.features.splash.presentation

import android.os.Handler
import androidx.compose.runtime.mutableFloatStateOf
import androidx.lifecycle.viewModelScope
import com.htk.ytubevideo.core.base.ActionViewModel
import com.htk.ytubevideo.core.extensions.launchScopedFun
import com.htk.ytubevideo.core.navigation.RouterNavigation
import com.htk.ytubevideo.core.navigation.RouterNavigationEnum
import com.htk.ytubevideo.features.splash.constants.SplashScreenConstants.TIME_MIILS_REDIRECT_LOGIN
import com.htk.ytubevideo.features.splash.domain.SplashScreenRotateUseCase

class SplashViewModel(
    private val routerNavigation: RouterNavigation,
    private val splashScreenRotateUseCase: SplashScreenRotateUseCase
) : ActionViewModel<SplashScreenAction>(routerNavigation) {

    var mutablateStateOffset = mutableFloatStateOf(0f)

    fun rotateSplashPlayerAnimated() {
        viewModelScope
            .launchScopedFun(
                data = splashScreenRotateUseCase.getEmitterStatesSplashPlayer(),
                onCollect = {
                    mutablateStateOffset.value = it
                },
                onCompletion = {
                    Handler().postDelayed({
                        setAction {
                            SplashScreenAction.NavigateToLogin
                        }
                    }, TIME_MIILS_REDIRECT_LOGIN)
                }
            )
    }

    fun navigateToLogin() {
        routerNavigation.navigateAndPop(dest = RouterNavigationEnum.LOGIN_SCREEN)
    }
}