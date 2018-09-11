package com.example.tainguyen.mvvm

import com.example.tainguyen.mvvm.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

class MyApplication : DaggerApplication() {

    @Inject
    internal lateinit var mCalligraphyConfig: CalligraphyConfig

    override fun onCreate() {
        super.onCreate()
        //        if (LeakCanary.isInAnalyzerProcess(this)) {
        //            // This process is dedicated to LeakCanary for heap analysis.
        //            // You should not init your app in this process.
        //            return;
        //        }
        //        LeakCanary.install(this);
        Timber.plant(Timber.DebugTree())
        CalligraphyConfig.initDefault(mCalligraphyConfig)

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? = DaggerAppComponent.builder().create(this)
}