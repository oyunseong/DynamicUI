package com.market.myzepeto.home.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.market.myzepeto.databinding.ItemTypePeedBinding
import com.market.myzepeto.model.Peed

class PeedViewHolder(private val binding: ItemTypePeedBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Peed) {
        binding.apply {
//            peedImg.setImageResource()
            peedTitle.text = item.title
            peedLikeCount.text = item.like_count.toString()
        }
    }
}