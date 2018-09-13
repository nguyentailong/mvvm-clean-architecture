package com.example.tainguyen.mvvm.initializers

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import javax.inject.Inject

class LeakCanaryInitializer @Inject constructor() : Initializer {
    override fun init(application: Application) {
        when {
            LeakCanary.isInAnalyzerProcess(application) -> RefWatcher.DISABLED
            else -> LeakCanary.install(application)
        }
    }
}