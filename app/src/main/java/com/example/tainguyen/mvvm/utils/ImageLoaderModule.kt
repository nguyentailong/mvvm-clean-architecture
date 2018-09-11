package com.example.tainguyen.mvvm.utils

import android.content.Context

import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Priority
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.example.tainguyen.mvvm.AppConfig

@GlideModule(glideName = AppConfig.ModuleName.GLIDE)
class ImageLoaderModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        val requestOptions = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .format(DecodeFormat.PREFER_ARGB_8888)
                .disallowHardwareConfig()
                .priority(Priority.HIGH)
        builder.setDefaultRequestOptions(requestOptions)
    }

    override fun isManifestParsingEnabled(): Boolean = false
}
