package com.mkeeda.runch.domainimpl

import com.mkeeda.runch.api.slash.auth.AuthService
import com.mkeeda.runch.api.slash.auth.LoginInputForm
import com.mkeeda.runchdomain.foundation.UserDataHolder
import com.mkeeda.runchdomain.repository.AuthRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class AuthRepositoryImpl: AuthRepository {
    private val authService: AuthService
    private val userDataHolder: UserDataHolder

    constructor(retrofit: Retrofit, userDataHolder: UserDataHolder) {
        this.authService = retrofit.create(AuthService::class.java)
        this.userDataHolder = userDataHolder
    }

    override fun login(username: String, password: String): Single<Unit> {
        val loginInputForm = LoginInputForm(username, password)
        return this.authService.getToken()
            .flatMap {
                this.userDataHolder.userSession.token = it.token
                this.authService.login(loginInputForm)
            }
            .map {
                this.userDataHolder.userSession.token = it.requestToken
                Unit
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
