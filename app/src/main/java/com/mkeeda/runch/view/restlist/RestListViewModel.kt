package com.mkeeda.runch.view.restlist

import androidx.lifecycle.ViewModel
import com.mkeeda.runch.RunchApplication
import com.mkeeda.runch.domainimpl.repository.RestSearchRepositoryImpl
import com.mkeeda.runchdomain.entity.Restaurant
import io.reactivex.Observable

class RestListViewModel : ViewModel() {
    val restList: Observable<List<Restaurant>>
        get() = RestSearchRepositoryImpl(retrofit = RunchApplication.singleton!!.retrofit)
            .retrieveRandom5ByLocation(latitude = 35.682444, longitude = 139.773611)
            .toObservable()
}
