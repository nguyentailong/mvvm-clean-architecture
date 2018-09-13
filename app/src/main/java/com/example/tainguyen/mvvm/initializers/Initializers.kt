package com.example.tainguyen.mvvm.initializers

import android.app.Application
import javax.inject.Inject

class Initializers @Inject constructor(private val initializers: Set<@JvmSuppressWildcards Initializer>) {
    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}

