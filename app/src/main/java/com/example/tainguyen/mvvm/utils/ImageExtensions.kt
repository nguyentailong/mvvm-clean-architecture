package com.example.tainguyen.mvvm.utils

import android.widget.ImageView

fun ImageView.loadImage(url: String) {
    ImageLoader.with(context).load(url).into(this)
}
