package com.example.tainguyen.mvvm.initializers

import android.app.Application
import com.example.tainguyen.mvvm.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject


class TimberInitializer @Inject constructor() : Initializer {
    override fun init(application: Application) {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}