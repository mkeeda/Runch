package com.mkeeda.runch.domainimpl.repository

import com.mkeeda.runch.api.gnavi.RestSearchService
import com.mkeeda.runchdomain.entity.Restaurant
import com.mkeeda.runchdomain.repository.RestSearchRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class RestSearchRepositoryImpl: RestSearchRepository {
    private val restSearchService: RestSearchService

    constructor(retrofit: Retrofit) {
        this.restSearchService = retrofit.create(RestSearchService::class.java)
    }
    override fun retrieveRandom5ByLocation(latitude: Double, longitude: Double): Single<List<Restaurant>> {
        return restSearchService.searchRestByLocation(latitude = latitude, longitude = longitude)
            .map {
                val shuffledList = it.rest.shuffled()
                if (it.hit_per_page >= 5) {
                    shuffledList.subList(fromIndex = 0, toIndex = 4)
                } else {
                    shuffledList
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
