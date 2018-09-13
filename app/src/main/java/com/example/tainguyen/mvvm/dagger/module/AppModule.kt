package com.example.tainguyen.mvvm.dagger.module

import android.content.Context
import android.content.SharedPreferences
import com.example.tainguyen.mvvm.AppConfig
import com.example.tainguyen.mvvm.MyApplication
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: MyApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideAppConfig(appConfig: AppConfig): AppConfig = appConfig

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(AppConfig.ModuleName.PREF, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideRefWatcher(): RefWatcher {
        return LeakCanary.installedRefWatcher()
    }
}
