package com.mkeeda.runch.domainimpl.repository

import com.mkeeda.runch.api.gnavi.RestSearchService
import com.mkeeda.runchdomain.entity.Restaurant
import com.mkeeda.runchdomain.repository.RestSearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class RestSearchRepositoryImpl(retrofit: Retrofit) : RestSearchRepository {
    private val restSearchService: RestSearchService = retrofit.create(RestSearchService::class.java)

    override suspend fun retrieveByLocation(latitude: Double, longitude: Double): List<Restaurant> {
        return withContext(Dispatchers.IO) {
            restSearchService
                .searchRestByLocation(latitude = latitude, longitude = longitude)
                .rest
        }
    }
}
