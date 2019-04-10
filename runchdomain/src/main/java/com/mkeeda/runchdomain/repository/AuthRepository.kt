package com.mkeeda.runchdomain.repository

import io.reactivex.Single

interface AuthRepository {
    fun login(username: String, password: String): Single<Unit>
}
