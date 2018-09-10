package com.example.tainguyen.mvvm.data.network.interceptor

import com.example.tainguyen.mvvm.BuildConfig
import com.example.tainguyen.mvvm.utils.md5
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HttpInterceptor @Inject internal constructor() : Interceptor {
    private val PRIVATE_API_KEY_ARG = "hash"
    private val PUBLIC_API_KEY_ARG = "apikey"
    private val TS = "ts"
    private val TS_VALUE = "1"

    override fun intercept(chain: Interceptor.Chain): Response {
        val defaultRequest = chain.request()
        val defaultHttpUrl = defaultRequest.url()
        val httpUrl = defaultHttpUrl.newBuilder()
                .addQueryParameter(PUBLIC_API_KEY_ARG, BuildConfig.MARVEL_PUBLIC_KEY)
                .addQueryParameter(TS, TS_VALUE)
                .addQueryParameter(PRIVATE_API_KEY_ARG, generateHash())
                .build()
        val request = defaultRequest.newBuilder().url(httpUrl).build()
        return chain.proceed(request)
    }

    private fun generateHash(): String {
        val stringBuilder = StringBuilder()
        return stringBuilder.append(TS_VALUE).append(BuildConfig.MARVEL_PRIVATE_KEY).append(BuildConfig.MARVEL_PUBLIC_KEY).toString().md5()
    }
}
