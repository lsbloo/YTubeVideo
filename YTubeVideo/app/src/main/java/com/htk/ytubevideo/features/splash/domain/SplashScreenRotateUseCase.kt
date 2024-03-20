package com.htk.ytubevideo.features.splash.domain

import kotlinx.coroutines.flow.Flow

interface SplashScreenRotateUseCase {
    fun getEmitterStatesSplashPlayer(): Flow<Float>
}