package com.example.tainguyen.mvvm.dagger.module

import com.example.tainguyen.mvvm.executor.Schedulers
import com.example.tainguyen.mvvm.executor.SchedulersImp
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RxModule {

    @Binds
    @Singleton
    abstract fun provideSchedulers(schedulers: SchedulersImp): Schedulers

}
