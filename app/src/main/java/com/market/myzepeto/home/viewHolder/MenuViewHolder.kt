package com.market.myzepeto.home.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.market.myzepeto.databinding.ItemTypeMenuBinding
import com.market.myzepeto.model.Menu

class MenuViewHolder(private val binding: ItemTypeMenuBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Menu) {
        binding.apply {
//            icon.background = item.title
            title.text = item.title
        }
    }
}