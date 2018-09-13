package com.example.tainguyen.mvvm

import com.example.tainguyen.mvvm.dagger.DaggerAppComponent
import com.example.tainguyen.mvvm.initializers.Initializers
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class MyApplication : DaggerApplication() {

    @Inject
    lateinit var initializers: Initializers

    override fun onCreate() {
        super.onCreate()
        initializers.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? = DaggerAppComponent.builder().create(this)
}