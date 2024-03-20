package com.htk.ytubevideo.koin

import com.htk.ytubevideo.core.config.YTubeKoinModules
import com.htk.ytubevideo.core.navigation.di.NavigationInject
import com.htk.ytubevideo.features.splash.di.SplashInject
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import kotlin.test.assertEquals

class AppKoinTest : KoinTest {

    @Before
    fun setUp() {
        startKoin {
            printLogger()
            modules(YTubeKoinModules.appModules)
        }
    }

    @Test
    fun checkAllModules() {
        assertEquals(true,NavigationInject.navigationModule.isLoaded)
        assertEquals(true, SplashInject.get()[0].isLoaded)
        assertEquals(true, SplashInject.get()[1].isLoaded)
    }

    @After
    fun tearDown() {
        stopKoin()
    }
}