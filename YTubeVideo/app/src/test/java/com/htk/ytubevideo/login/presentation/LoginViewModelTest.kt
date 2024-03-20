package com.htk.ytubevideo.login.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.htk.ytubevideo.core.navigation.RouterNavigation
import com.htk.ytubevideo.features.login.data.model.LoginAuthenticateCredentials
import com.htk.ytubevideo.features.login.presentation.LoginAction
import com.htk.ytubevideo.features.login.presentation.LoginProvider
import com.htk.ytubevideo.features.login.presentation.LoginViewModel
import com.htk.ytubevideo.utils.BaseUnitTest
import com.htk.ytubevideo.utils.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest : BaseUnitTest<LoginViewModel>() {

    private val routerNavigation: RouterNavigation = mockk(relaxed = true)
    private val loginProvider: LoginProvider = mockk(relaxed = true)

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = spyk(LoginViewModel(routerNavigation, loginProvider))
    }

    @Test
    fun `when signInAuthenticateFirebaseUseCase has successful then submitLogin should call saveCredentialsAndNavigateHome`() =
        runBlocking {
            // Given
            val someEmail = "aosdksoadk@hotmail.com"
            val somePassword = "13213213412424"
            val mockCredentials = LoginAuthenticateCredentials(uid = "123213214214")

            coEvery {
                loginProvider.signInAuthenticateFirebaseUseCase.invoke(someEmail, somePassword)
            } returns flow {
                emit(mockCredentials)
            }

            // When
            viewModel.submitLogin(someEmail, somePassword)

            // Then
            verify {
                viewModel.saveCredentialsAndNavigateToHome(mockCredentials)
            }
        }

    @Test
    fun `when signInAuthenticateFirebaseUseCase has successful then submitLogin should call LoginActionNavigateToHome`() =
        runBlocking {
            // Given
            val someEmail = "aosdksoadk@hotmail.com"
            val somePassword = "13213213412424"
            val mockCredentials = LoginAuthenticateCredentials(uid = "123213214214")

            coEvery {
                loginProvider.signInAuthenticateFirebaseUseCase.invoke(someEmail, somePassword)
            } returns flow {
                emit(mockCredentials)
            }

            // When
            viewModel.submitLogin(someEmail, somePassword)

            // Then
            viewModel.action.onChangedTest(LoginAction.NavigateToHome)
        }

    @Test
    fun `when signInAuthenticateFirebaseUseCase has error then submitLogin should call handleError`() {
        // Given
        val someEmail = "aosdksoadk@hotmail.com"
        val somePassword = "13213213412424"
        val mockThrowable = Throwable(message = "any error")

        coEvery {
            loginProvider.signInAuthenticateFirebaseUseCase.invoke(someEmail, somePassword)
        } returns flow {
            throw mockThrowable
        }

        // When
        viewModel.submitLogin(someEmail, somePassword)

        // Then
        verify {
            viewModel.handleError(mockThrowable)
        }
    }

    @Test
    fun `when signInAuthenticateFirebaseUseCase has error then submitLogin should call LoginActionShowMessageErrorSignIn`() {
        // Given
        val someEmail = "aosdksoadk@hotmail.com"
        val somePassword = "13213213412424"
        val mockThrowable = Throwable(message = "any error")

        coEvery {
            loginProvider.signInAuthenticateFirebaseUseCase.invoke(someEmail, somePassword)
        } returns flow {
            throw mockThrowable
        }

        // When
        viewModel.submitLogin(someEmail, somePassword)

        // Then
        viewModel.action.onChangedTest(LoginAction.ShowMessageErrorSignIn)
    }
}