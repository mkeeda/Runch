package com.mkeeda.runch.domainimpl.repository

import com.mkeeda.runch.api.gnavi.RestSearchService
import com.mkeeda.runchdomain.repository.RestSearchRepository
import retrofit2.Retrofit

class RestSearchRepositoryImpl(retrofit: Retrofit) : RestSearchRepository {
    private val restSearchService: RestSearchService = retrofit.create(RestSearchService::class.java)

//    override fun retrieveRandom5ByLocation(latitude: Double, longitude: Double): Single<List<Restaurant>> {
//        return restSearchService.searchRestByLocation(latitude = latitude, longitude = longitude)
//            .map {
//                val shuffledList = it.rest.shuffled()
//                if (it.hit_per_page >= 5) {
//                    shuffledList.subList(fromIndex = 0, toIndex = 5)
//                } else {
//                    shuffledList
//                }
//            }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//    }
}
