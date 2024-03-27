package com.htk.ytubevideo.splash.presentation

import com.htk.ytubevideo.core.navigation.RouterNavigation
import com.htk.ytubevideo.features.splash.domain.SplashScreenRotateUseCase
import com.htk.ytubevideo.features.splash.presentation.SplashViewModel
import com.htk.ytubevideo.koin.BaseTest
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class SplashViewModelTest : BaseTest() {

    private val routerNavigation: RouterNavigation = mockk(relaxed = true)
    private val splashScreenRotateUseCase: SplashScreenRotateUseCase = mockk(relaxed = true)

    private var splashViewModel: SplashViewModel? = null

    @Test
    fun `validate splash rotate use case`() = runTest {
        // Given
        splashViewModel = createViewModel()

        // When
        coEvery { splashScreenRotateUseCase.getEmitterStatesSplashPlayer() } returns flow {
            emit(0f)
        }
        splashViewModel?.rotateSplashPlayerAnimated()

        // Then
        verify {
            splashViewModel?.rotateSplashPlayerAnimated()
        }
        assertEquals(0f, splashViewModel?.mutableStateOffset?.value)
    }

    @Test
    fun `when redirectToLogin called in viewModel router navigation has LOGIN_SCREEN `() {
        // Given
        splashViewModel = createViewModel()

        // When
        splashViewModel?.navigateToLogin()

        // Then
        verify {
            splashViewModel?.navigateToLogin()
        }

    }

    private fun createViewModel(): SplashViewModel {
        return SplashViewModel(routerNavigation, splashScreenRotateUseCase)
    }
}