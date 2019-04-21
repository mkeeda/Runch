package com.mkeeda.runchdomain.repository

import com.mkeeda.runchdomain.entity.Restaurant
import io.reactivex.Single

interface RestSearchRepository {
    fun retrieveRandom5ByLocation(latitude: Double, longitude: Double): Single<List<Restaurant>>
}
