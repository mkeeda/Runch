package com.mkeeda.runch.view.restlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mkeeda.runch.RunchApplication
import com.mkeeda.runch.domainimpl.repository.RestSearchRepositoryImpl

class RestListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repository = RestSearchRepositoryImpl(retrofit = RunchApplication.singleton.retrofit)
        return RestListViewModel(restSearchRepository = repository) as T
    }
}
