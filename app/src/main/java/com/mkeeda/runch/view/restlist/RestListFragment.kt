package com.mkeeda.runch.view.restlist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.mkeeda.runch.R
import com.mkeeda.runchdomain.extension.disposed
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.rest_list_fragment.*
import kotlinx.android.synthetic.main.rest_list_fragment.view.*

class RestListFragment : Fragment() {
    private lateinit var viewModel: RestListViewModel
    private val disposeBag = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RestListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.rest_list_fragment, container, false)
        view.restlist_recycler_view.setHasFixedSize(true)
        view.restlist_recycler_view.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        view.restlist_recycler_view.adapter = RestCardRecyclerViewAdapter()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.setupViewModelBinding()
    }

    private fun setupViewModelBinding() {
        this.viewModel.restList.subscribe {
            val adapter = restlist_recycler_view.adapter
            if (adapter is RestCardRecyclerViewAdapter) {
                adapter.update(it)
            }
        }.disposed(by = disposeBag)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.disposeBag.clear()
    }
}
