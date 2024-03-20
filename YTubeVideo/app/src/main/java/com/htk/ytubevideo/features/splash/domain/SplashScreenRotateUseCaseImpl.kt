package com.htk.ytubevideo.features.splash.domain

import com.htk.ytubevideo.features.splash.constants.SplashScreenConstants
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class SplashScreenRotateUseCaseImpl : SplashScreenRotateUseCase {

    override fun getEmitterStatesSplashPlayer() = flow {
        statesRotateSplashPlayer.forEach { states ->
            this.emit(states)
            delay(SplashScreenConstants.TIME_MILLIS_ROTATE_PLAYER)
        }
    }

    private val statesRotateSplashPlayer =
        listOf(0f, 10f, 20f, 30f, 40f, 50f, 60f, 70f, 80f, 90f, 100f, 0f)
}