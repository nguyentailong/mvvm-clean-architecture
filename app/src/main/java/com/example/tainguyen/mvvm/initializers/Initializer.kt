package com.example.tainguyen.mvvm.initializers

import android.app.Application

interface Initializer {
    fun init(application: Application)
}