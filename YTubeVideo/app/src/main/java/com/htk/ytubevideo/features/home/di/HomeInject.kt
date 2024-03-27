package com.htk.ytubevideo.features.home.di

import com.htk.ytubevideo.core.base.ScopedModule
import com.htk.ytubevideo.features.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object HomeInject : ScopedModule() {

    init {
        start(HomeInject::class.java.simpleName)
    }

    override fun getPresentation() = module {
        viewModel {
            HomeViewModel(routerNavigation = get())
        }
    }

    override fun getAdditionalModules(): Module? {
        return null
    }

    override fun getDomain(): Module? {
        return null
    }

    override fun get() = listOf(getPresentation())
}