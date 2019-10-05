package com.mkeeda.runch.view.restlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.mkeeda.runch.R
import com.mkeeda.runchdomain.entity.RestCardViewEntity
import kotlinx.android.synthetic.main.rest_card.view.rest_card_access_walk
import kotlinx.android.synthetic.main.rest_card.view.rest_card_category
import kotlinx.android.synthetic.main.rest_card.view.rest_card_name
import kotlinx.android.synthetic.main.rest_card.view.rest_card_thumbnail_image

class RestCardRecyclerViewAdapter : ListAdapter<RestCardViewEntity, RestCardViewHolder>(RestCardDiffCallback()) {
    private var parent: ViewGroup? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestCardViewHolder {
        this.parent = parent
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.rest_card, parent, false)
        return RestCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: RestCardViewHolder, position: Int) {
        val rest = getItem(position)
        holder.itemView.rest_card_name.text = rest.name
        holder.itemView.rest_card_category.text = rest.category
        holder.itemView.rest_card_access_walk.text = rest.access

        rest.imageUrl?.let { thumbnailUrl ->
            // FIXME: Glide オブジェクトを外からインジェクトしてもらえば、parent は消せる？
            this.parent?.let {
                Glide.with(it.context)
                    .load(thumbnailUrl)
                    .into(holder.itemView.rest_card_thumbnail_image);
            }
        }

    }
}

class RestCardDiffCallback : DiffUtil.ItemCallback<RestCardViewEntity>() {
    override fun areItemsTheSame(oldItem: RestCardViewEntity, newItem: RestCardViewEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RestCardViewEntity, newItem: RestCardViewEntity): Boolean {
        return oldItem == newItem
    }

}
