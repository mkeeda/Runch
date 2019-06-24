package com.mkeeda.runch.view.restlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mkeeda.runch.R
import com.mkeeda.runchdomain.entity.Restaurant
import kotlinx.android.synthetic.main.rest_card.view.rest_card_access_walk
import kotlinx.android.synthetic.main.rest_card.view.rest_card_category
import kotlinx.android.synthetic.main.rest_card.view.rest_card_name
import kotlinx.android.synthetic.main.rest_card.view.rest_card_thumbnail_image

class RestCardRecyclerViewAdapter: RecyclerView.Adapter<RestCardViewHolder>() {
    private var parent: ViewGroup? = null
    private var restList: List<Restaurant> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestCardViewHolder {
        this.parent = parent
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.rest_card, parent, false)
        return RestCardViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return this.restList.size
    }

    override fun onBindViewHolder(holder: RestCardViewHolder, position: Int) {
        val rest = restList[position]
        holder.itemView.rest_card_name.text = rest.name
        holder.itemView.rest_card_category.text = rest.category
        holder.itemView.rest_card_access_walk.text = rest.access.walk

        val thumbnailUrl = if (rest.image_url.shop_image1.isNotEmpty()) {
            rest.image_url.shop_image1
        } else {
            rest.image_url.shop_image2
        }
        this.parent?.let {
            Glide.with(it.context)
                .load(thumbnailUrl)
                .into(holder.itemView.rest_card_thumbnail_image);
        }
    }

    fun update(restList: List<Restaurant>) {
        this.restList = restList
        this.notifyDataSetChanged()
    }
}
