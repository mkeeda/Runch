package com.mkeeda.runch.api.gnavi

import com.mkeeda.runch.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class GnaviApiRequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest
            .url
            .newBuilder()
        val apiKey = BuildConfig.gnaviApiKey

        val newUrl = originalUrl
            .addQueryParameter("keyid", apiKey)
            .build()
        val newRequest = originalRequest
            .newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(newRequest)
    }

}
