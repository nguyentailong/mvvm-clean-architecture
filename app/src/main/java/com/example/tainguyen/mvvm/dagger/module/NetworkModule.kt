package com.example.tainguyen.mvvm.dagger.module

import com.example.tainguyen.mvvm.AppConfig
import com.example.tainguyen.mvvm.BuildConfig
import com.example.tainguyen.mvvm.data.network.ComicService
import com.example.tainguyen.mvvm.data.network.interceptor.HttpInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideRestApi(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): ComicService {
        return Retrofit.Builder()
                .baseUrl(AppConfig.ApiUrls.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(ComicService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor { message ->
            Timber.d(message)
        }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    internal fun provideGson(): Gson {
        return GsonBuilder()
                .setPrettyPrinting()
                .create()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClientRestAPI(httpLoggingInterceptor: HttpLoggingInterceptor, httpInterceptor: HttpInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(httpInterceptor)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(httpLoggingInterceptor)
        }
        return builder.build()
    }

    @Provides
    @Singleton
    internal fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)
}
