package com.htk.ytubevideo.core.navigation.di

import com.htk.ytubevideo.core.navigation.RouterNavigation
import com.htk.ytubevideo.core.navigation.RouterNavigationImpl
import org.koin.dsl.module

object NavigationInject {
    private fun providerRouterNavigation(): RouterNavigation {
        return RouterNavigationImpl()
    }

    val navigationModule = module {
        single {
            providerRouterNavigation()
        }
    }
}