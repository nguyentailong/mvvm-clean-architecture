package com.example.tainguyen.mvvm.dagger.module

import com.example.tainguyen.mvvm.executor.Schedulers
import com.example.tainguyen.mvvm.executor.SchedulersImp
import com.example.tainguyen.mvvm.initializers.CalligraphyInitializer
import com.example.tainguyen.mvvm.initializers.Initializer
import com.example.tainguyen.mvvm.initializers.LeakCanaryInitializer
import com.example.tainguyen.mvvm.initializers.TimberInitializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
abstract class UtilsModule {

    @Binds
    @Singleton
    abstract fun provideSchedulers(schedulers: SchedulersImp): Schedulers

    @Binds
    @IntoSet
    abstract fun provideCalligraphyInitializer(calligraphyInitializer: CalligraphyInitializer): Initializer

    @Binds
    @IntoSet
    abstract fun provideTimberInitializer(timberInitializer: TimberInitializer): Initializer

    @Binds
    @IntoSet
    abstract fun provideLeakCanaryInitializer(leakCanaryInitializer: LeakCanaryInitializer): Initializer

}