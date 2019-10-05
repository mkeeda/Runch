package com.mkeeda.runch.api.gnavi

import com.mkeeda.runchdomain.entity.RestApiEnvelope
import retrofit2.http.GET
import retrofit2.http.Query

interface RestSearchService {
    @GET("RestSearchAPI/v3/")
    suspend fun searchRestByLocation(
        @Query(value = "latitude") latitude: Double,
        @Query(value = "longitude") longitude: Double,
        @Query(value = "hit_per_page") hitPerPage: Int = 20,
        @Query(value = "lunch") lunchFlag: Int = 1
    ): RestApiEnvelope
}
