package com.example.tainguyen.mvvm.dagger.module

import android.content.Context
import android.content.SharedPreferences
import com.example.tainguyen.mvvm.AppConfig
import com.example.tainguyen.mvvm.MyApplication
import com.example.tainguyen.mvvm.R
import dagger.Module
import dagger.Provides
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
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
    fun provideSharedPreferences(context: Context, appConfig: AppConfig): SharedPreferences = context.getSharedPreferences(appConfig.prefName, Context.MODE_PRIVATE)

//    @Provides
//    @Singleton
//    internal fun providePreferencesHelper(preferencesHelperImp: PreferencesHelperImp): PreferencesHelper {
//        return preferencesHelperImp
//    }

    @Provides
    @Singleton
    fun provideCalligraphyDefaultConfig(): CalligraphyConfig =
            CalligraphyConfig.Builder()
                    //                .setDefaultFontPath("fonts/Comfortaa-Regular.ttf")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
}
