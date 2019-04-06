package com.mkeeda.runch.api

import com.mkeeda.runch.domain.foundation.UserSession
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiRequestInterceptor: Interceptor {

    companion object {
        const val NO_AUTH_HEADER_KEY = "No-Authentication"
        const val NO_AUTH_HEADER = "$NO_AUTH_HEADER_KEY: true"
        const val ACCESS_TOKEN_HEADER_KEY = "Access-Token"
        const val ACCESS_TOKEN_HEADER = "$ACCESS_TOKEN_HEADER_KEY: true"
    }

    private val userSession: UserSession

    constructor(userSession: UserSession) {
        this.userSession = userSession
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
        if (chain == null)
            throw IllegalStateException("chain == null")

        val request = chain.request()
        val requestBuilder = request
            .newBuilder()
            .addHeader("Content-Type", "application/json")

        if (this.needsAuth(request)) {
            if (this.useAccessToken(request)) {
                requestBuilder.addHeader("X-Cybozu-RequestToken", userSession.token)
            }
        }
        return chain.proceed(requestBuilder.build())
    }

    private fun needsAuth(request: Request): Boolean {
        return request.header(NO_AUTH_HEADER_KEY) == null
    }

    private fun useAccessToken(request: Request): Boolean {
        return request.header(ACCESS_TOKEN_HEADER_KEY) != null
    }
}
