package com.mkeeda.runch.api.slash.auth

import com.mkeeda.runch.api.ApiRequestInterceptor
import com.mkeeda.runchdomain.entity.AccessToken
import com.mkeeda.runchdomain.entity.RequestToken
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {
    @Headers(ApiRequestInterceptor.ACCESS_TOKEN_HEADER)
    @POST("api/auth/login.json")
    fun login(@Body form: LoginInputForm): Single<RequestToken>

    @Headers(ApiRequestInterceptor.ACCESS_TOKEN_HEADER)
    @POST("api/auth/logout.json")
    fun logout(): Single<Unit>

    @Headers(ApiRequestInterceptor.NO_AUTH_HEADER)
    @POST("api/auth/getToken.json")
    fun getToken(): Single<AccessToken>
}
