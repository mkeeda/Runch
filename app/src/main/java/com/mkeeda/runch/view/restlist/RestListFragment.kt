package com.mkeeda.runch.view.restlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.mkeeda.runch.R
import com.mkeeda.runch.RunchApplication
import com.mkeeda.runch.domainimpl.repository.RestSearchRepositoryImpl
import com.mkeeda.runch.util.RunchViewModelFactory
import com.mkeeda.runchdomain.usecase.ShowRestUseCase
import kotlinx.android.synthetic.main.rest_list_fragment.view.restlist_recycler_view

class RestListFragment : Fragment() {
    private val viewModel: RestListViewModel by viewModels {
        RunchViewModelFactory {
            val repository = RestSearchRepositoryImpl(retrofit = RunchApplication.singleton.retrofit)
            val showRestUseCase = ShowRestUseCase(restSearchRepository = repository)
            RestListViewModel(showRestUseCase = showRestUseCase)
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.rest_list_fragment, container, false)
        val adapter = RestCardRecyclerViewAdapter()
        view.restlist_recycler_view.adapter = adapter
        viewModel.rests.observe(this) {
            it?.let {
                adapter.submitList(it)
            }
        }
        viewModel.loadRestaurants()
        return view
    }
}
