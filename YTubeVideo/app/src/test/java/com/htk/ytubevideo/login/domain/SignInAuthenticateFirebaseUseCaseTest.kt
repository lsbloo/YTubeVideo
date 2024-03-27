package com.htk.ytubevideo.login.domain

import com.htk.ytubevideo.features.login.data.model.LoginAuthenticateCredentials
import com.htk.ytubevideo.features.login.domain.usecase.SignInAuthenticateFirebaseUseCase
import com.htk.ytubevideo.utils.verifyCollect
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SignInAuthenticateFirebaseUseCaseTest {

    private val signInAuthenticateFirebaseUseCase: SignInAuthenticateFirebaseUseCase =
        mockk(relaxed = true)


    @Test
    fun `when signInAuthenticateFirebaseUseCase return successful then result is credentials dto`() =
        runBlocking {
            // Given
            val email = "osvaldooutlook@outlook.com"
            val password = "1232134214"
            val mockLoginAuthenticate = LoginAuthenticateCredentials(uid = "123123123")

            coEvery {
                signInAuthenticateFirebaseUseCase(email, password)
            } returns flow {
                emit(mockLoginAuthenticate)
            }

            // When
            val result = signInAuthenticateFirebaseUseCase.invoke(email, password)

            // Then
            result.verifyCollect(mockLoginAuthenticate)
        }
}