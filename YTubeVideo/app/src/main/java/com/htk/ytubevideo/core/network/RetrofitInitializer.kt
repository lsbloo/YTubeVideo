package com.htk.ytubevideo.core.network

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer {

    fun getRetrofitNetModule() = module {

        fun provideCache(application: Application): Cache {
            return Cache(application.cacheDir, (10 * 1024 * 1024).toLong())
        }

        fun provideHttpClient(cache: Cache): OkHttpClient {
            val interceptorLogger = HttpLoggingInterceptor()
            interceptorLogger.level = HttpLoggingInterceptor.Level.BODY
            val cachedOkHttpClientBuilder = OkHttpClient.Builder().apply {
                cache
                addInterceptor(interceptorLogger)
            }
            return cachedOkHttpClientBuilder.build()
        }

        fun provideGson(): Gson {
            return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
        }

        fun provideSetupRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
            return Retrofit.Builder().baseUrl(com.htk.ytubevideo.BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        single { provideCache(androidApplication()) }
        single { provideHttpClient(get()) }
        single { provideGson() }
        single<Retrofit> { provideSetupRetrofit(get(), get()) }

    }
}