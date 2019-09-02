package com.mkeeda.runch.view.restlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.mkeeda.runch.R
import kotlinx.android.synthetic.main.rest_list_fragment.view.restlist_recycler_view

class RestListFragment : Fragment() {
    private val viewModel: RestListViewModel by lazy {
        ViewModelProvider(this, RestListViewModelFactory()).get(RestListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.rest_list_fragment, container, false)
        val adapter = RestCardRecyclerViewAdapter()
        view.restlist_recycler_view.adapter = adapter
        viewModel.rests.observe(this) {
            adapter.update(it)
        }
        viewModel.loadRestaurants()
        return view
    }
}
