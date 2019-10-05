package com.mkeeda.runchdomain.repository

import com.mkeeda.runchdomain.entity.RestApiEnvelope

interface RestSearchRepository {
    suspend fun retrieveByLocation(latitude: Double, longitude: Double): RestApiEnvelope
}
