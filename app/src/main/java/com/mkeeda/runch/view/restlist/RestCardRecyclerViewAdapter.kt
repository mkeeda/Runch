package com.mkeeda.runch.view.restlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkeeda.runch.R
import com.mkeeda.runchdomain.entity.Restaurant

class RestCardRecyclerViewAdapter: RecyclerView.Adapter<RestCardViewHolder>() {
    private var restList: List<Restaurant> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestCardViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.rest_card, parent, false)
        return RestCardViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return this.restList.size
    }

    override fun onBindViewHolder(holder: RestCardViewHolder, position: Int) {
    }

    fun update(restList: List<Restaurant>) {
        this.restList = restList
        this.notifyDataSetChanged()
    }
}
