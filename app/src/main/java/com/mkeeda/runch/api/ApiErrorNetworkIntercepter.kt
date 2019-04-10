package com.mkeeda.runch.api

import com.mkeeda.runchdomain.entity.SlashApiError
import com.mkeeda.runchdomain.foundation.RunchError
import com.mkeeda.runchdomain.foundation.RunchNetworkError
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.Response

class ApiErrorNetworkInterceptor: Interceptor {
    private val moshi = Moshi.Builder().build()
    private val errorEnvelopeAdapter = moshi.adapter(ApiErrorEnvelope::class.java)

    override fun intercept(chain: Interceptor.Chain?): Response {
        if (chain == null)
            throw Throwable("chain == null")

        val response = chain.proceed(chain.request())

        if (300 <= response.code()) {
            if (!this.isJSONResponse(response)) {
                // HTTP 的なエラー
                throw RunchError.network(type = RunchNetworkError.HTTP(response.code()))
            } else {
                val errorEnvelope = errorEnvelopeAdapter.fromJson(response.body()?.string() ?: "")
                if (errorEnvelope != null) {
                    throw this.getAPIErrorOrSessionExpiredError(errorEnvelope = errorEnvelope)
                } else {
                    throw RunchError.network(type = RunchNetworkError.InvalidResponse)
                }
            }
        } else {
            if (!this.isJSONResponse(response)) {
                throw RunchError.network(type = RunchNetworkError.InvalidResponse)
            } else {
                // 200系でのエラーは ApiResponseConverterFactory で対処
                return response
            }
        }
    }

    private fun isJSONResponse(response: Response): Boolean {
        return (response.header("Content-Type") ?: "").contains("application/json")
    }

    private fun getAPIErrorOrSessionExpiredError(errorEnvelope: ApiErrorEnvelope): Throwable {
        return when (errorEnvelope.code) {
            SlashApiError.CB_AU01.rawValue,
            SlashApiError.CB_CS01.rawValue ->
                RunchError.network(type = RunchNetworkError.SessionExpired)
            else -> {
                RunchError.network(type = RunchNetworkError.API(code = errorEnvelope.code, message = errorEnvelope.message))
            }
        }
    }
}
