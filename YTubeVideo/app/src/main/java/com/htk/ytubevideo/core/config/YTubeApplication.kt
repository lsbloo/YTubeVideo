package com.htk.ytubevideo.core.config

import android.app.Application
import androidx.startup.AppInitializer
import com.google.firebase.FirebaseApp
import com.htk.ytubevideo.core.base.ScopedModule
import com.htk.ytubevideo.features.splash.di.SplashInject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class YTubeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val initializer = AppInitializer.getInstance(this)
        FirebaseApp.initializeApp(this)
        startKoin {
            androidLogger()
            androidContext(this@YTubeApplication)
            modules(YTubeKoinModules.appModules)
        }
    }
}