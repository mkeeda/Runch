package com.mkeeda.runch.api.gnavi

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestSearchService {
    @GET("RestSearchAPI/v3/")
    fun searchRestByLocation(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): Single<RestApiEnvelope>
}
