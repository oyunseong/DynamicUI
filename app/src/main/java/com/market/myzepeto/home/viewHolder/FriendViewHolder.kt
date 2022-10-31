package com.market.myzepeto.home.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.market.myzepeto.databinding.ItemTypeFriendBinding
import com.market.myzepeto.model.Friend

class FriendViewHolder(private val binding: ItemTypeFriendBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Friend) {
        binding.apply {
//            peedImg.setImageResource()
//            .text = item.title
//            peedLikeCount.text = item.like_count.toString()
        }
    }
}