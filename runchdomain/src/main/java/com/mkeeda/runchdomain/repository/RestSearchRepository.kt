package com.mkeeda.runchdomain.repository

import com.mkeeda.runchdomain.entity.Restaurant

interface RestSearchRepository {
    suspend fun retrieveByLocation(latitude: Double, longitude: Double): List<Restaurant>
}
