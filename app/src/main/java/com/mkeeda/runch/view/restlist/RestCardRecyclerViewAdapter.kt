package com.mkeeda.runch.view.restlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkeeda.runch.R
import com.mkeeda.runchdomain.entity.Restaurant
import kotlinx.android.synthetic.main.rest_card.view.rest_card_access_walk
import kotlinx.android.synthetic.main.rest_card.view.rest_card_category
import kotlinx.android.synthetic.main.rest_card.view.rest_card_name

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
        holder.itemView.rest_card_name.text = restList[position].name
        holder.itemView.rest_card_category.text = restList[position].category
        holder.itemView.rest_card_access_walk.text = restList[position].access.walk
    }

    fun update(restList: List<Restaurant>) {
        this.restList = restList
        this.notifyDataSetChanged()
    }
}
