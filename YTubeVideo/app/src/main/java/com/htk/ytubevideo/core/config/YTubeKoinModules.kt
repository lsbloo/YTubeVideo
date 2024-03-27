package com.htk.ytubevideo.core.config

import com.htk.ytubevideo.authentication.FirebaseAuthenticator
import com.htk.ytubevideo.core.navigation.di.NavigationInject
import com.htk.ytubevideo.core.network.RetrofitInitializer
import com.htk.ytubevideo.features.home.di.HomeInject
import com.htk.ytubevideo.features.login.di.LoginInject
import com.htk.ytubevideo.features.splash.di.SplashInject
import org.koin.core.module.Module
import org.koin.dsl.module

object YTubeKoinModules {
    val appModules = ArrayList<Module>(
    ).apply {
        add(RetrofitInitializer.getRetrofitNetModule())
        add(getConfigFirebaseAuth())
        add(NavigationInject.navigationModule)
        addAll(SplashInject.get())
        addAll(LoginInject.get())
        addAll(HomeInject.get())
    }
}

internal fun getConfigFirebaseAuth() = module { single { FirebaseAuthenticator.getInstance() } }