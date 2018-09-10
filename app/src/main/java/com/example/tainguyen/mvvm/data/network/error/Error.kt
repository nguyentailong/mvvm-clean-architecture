package com.example.tainguyen.mvvm.data.network.error

import com.google.gson.annotations.SerializedName

data class Error(@SerializedName("code") val code: String,
                 @SerializedName("message") val message: String)

