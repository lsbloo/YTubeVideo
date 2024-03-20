package com.htk.ytubevideo.features.login.di

import com.htk.ytubevideo.core.base.ScopedModule
import com.htk.ytubevideo.features.login.data.mapper.LoginAuthenticateSignInMapper
import com.htk.ytubevideo.features.login.data.repository.LoginRepositoryImp
import com.htk.ytubevideo.features.login.domain.usecase.SignInAuthenticateFirebaseUseCase
import com.htk.ytubevideo.features.login.presentation.LoginProvider
import com.htk.ytubevideo.features.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object LoginInject : ScopedModule() {

    override fun getPresentation() = module {
        viewModel {
            LoginViewModel(routerNavigation = get(), loginProvider = LoginProvider(get()))
        }
    }

    override fun getAdditionalModules() = module {
        factory {
            LoginRepositoryImp(
                firebaseAuthenticator = get(),
                mapper = LoginAuthenticateSignInMapper()
            )
        }
    }

    override fun getDomain() = module {
        factory {
            SignInAuthenticateFirebaseUseCase(get())
        }
    }


    override fun get() = listOf(getPresentation(), getAdditionalModules(), getDomain())

    init {
        start(this::class.java.simpleName)
    }
}