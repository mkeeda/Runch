package com.mkeeda.runch.view.restlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkeeda.runchdomain.entity.Restaurant
import com.mkeeda.runchdomain.repository.RestSearchRepository
import kotlinx.coroutines.launch

class RestListViewModel(
    private val restSearchRepository: RestSearchRepository
) : ViewModel() {
    val rests = MutableLiveData<List<Restaurant>>()

    fun loadRestaurants() {
        viewModelScope.launch {
            try {
                rests.value = restSearchRepository.retrieveByLocation(latitude = 35.682444, longitude = 139.773611)
            } catch (error: Throwable) {
                println(error)
            }
        }
    }
}
