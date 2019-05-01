package com.mkeeda.runch.view.restlist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mkeeda.runch.R
import com.mkeeda.runchdomain.model.restlist.RestListViewModel

class RestListFragment : Fragment() {

    companion object {
        fun newInstance() = RestListFragment()
    }

    private lateinit var viewModel: RestListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rest_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RestListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
