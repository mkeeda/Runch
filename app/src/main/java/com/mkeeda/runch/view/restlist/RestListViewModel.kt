package com.mkeeda.runch.view.restlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkeeda.runchdomain.entity.RestCardViewEntity
import com.mkeeda.runchdomain.usecase.ShowRestUseCase
import kotlinx.coroutines.launch

class RestListViewModel(
    private val showRestUseCase: ShowRestUseCase
) : ViewModel() {
    val rests = MutableLiveData<List<RestCardViewEntity>>()

    fun loadRestaurants() {
        viewModelScope.launch {
            try {
                rests.value = showRestUseCase.randomSelectedRestsByLocation(
                    latitude = 35.682444,
                    longitude = 139.773611,
                    order = 10
                )
            } catch (error: Throwable) {
                println(error)
            }
        }
    }
}
