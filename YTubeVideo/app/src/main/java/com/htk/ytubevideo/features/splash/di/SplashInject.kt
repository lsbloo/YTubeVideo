package com.htk.ytubevideo.features.splash.di

import com.htk.ytubevideo.core.base.ScopedModule
import com.htk.ytubevideo.features.splash.domain.SplashScreenRotateUseCase
import com.htk.ytubevideo.features.splash.domain.SplashScreenRotateUseCaseImpl
import com.htk.ytubevideo.features.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object SplashInject : ScopedModule() {

    init {
        start(this::class.java.simpleName)
    }

    override fun get() = listOf(getPresentation(), getDomain())

    override fun getPresentation() = module {
        viewModel {
            SplashViewModel(get(), get())
        }
    }

    override fun getAdditionalModules(): Module? {
        return null
    }

    override fun getDomain() = module {
        factory {
            getSplashScreenRotateUseCase()
        }
    }

    private fun getSplashScreenRotateUseCase(): SplashScreenRotateUseCase {
        return SplashScreenRotateUseCaseImpl()
    }
}
