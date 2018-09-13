package com.example.tainguyen.mvvm.initializers

import android.app.Application
import com.example.tainguyen.mvvm.R
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

class CalligraphyInitializer @Inject constructor() : Initializer {
    override fun init(application: Application) {
        val mCalligraphyConfig: CalligraphyConfig = CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/Comfortaa-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        CalligraphyConfig.initDefault(mCalligraphyConfig)
    }
}