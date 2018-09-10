package com.example.tainguyen.mvvm.dagger

import com.example.tainguyen.mvvm.MyApplication
import com.example.tainguyen.mvvm.dagger.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ActivityBuilderModule::class,
            ViewModelModule::class,
            AppModule::class,
            RxModule::class,
            DataModule::class,
            UtilsModule::class,
            NetworkModule::class
        ])
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApplication>()
}