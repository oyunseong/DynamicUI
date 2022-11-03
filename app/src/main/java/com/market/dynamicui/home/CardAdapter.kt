package com.market.dynamicui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.market.dynamicui.domain.Card
import com.market.dynamicui.model.*
import com.market.myzepeto.R

class CardAdapter(list: ArrayList<Card>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = list

    override fun getItemViewType(position: Int) = when (items[position]) {
        is
        is Menu -> {
            menu_type
        }
        is Peed -> {
            peed_type
        }
        is Friend -> {
            friend_type
        }
        is Booth -> {
            booth_type
        }
        else -> {
            throw IllegalStateException("Not Found ViewHolder Type!!")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            menu_type -> {
                MenuViewHolder.create(parent)
            }
            peed_type -> {
                PeedViewHolder.create(parent)
            }
            friend_type -> {
                FriendViewHolder.create(parent)
            }
            booth_type -> {
                BoothViewHolder.create(parent)
            }
            else -> {
                throw IllegalStateException("Not Found ViewHolder Type $viewType")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MenuViewHolder -> {
                holder.bind(items[position] as Menu)
            }
            is PeedViewHolder -> {
                holder.bind(items[position] as Peed)
            }
            is FriendViewHolder -> {
                holder.bind(items[position] as Friend)
            }
            is BoothViewHolder -> {
                holder.bind(items[position] as Booth)
            }
        }
    }

    class MenuViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: Menu) {
            binding.apply {
//            icon.background = item.title
//                title.text = item.title
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): MenuViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_menu, parent, false)
                return MenuViewHolder(view)
            }
        }
    }

    class PeedViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: Peed) {
            binding.apply {
//            peedImg.setImageResource()
//                peedTitle.text = item.title
//                peedLikeCount.text = item.like_count.toString()
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): PeedViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_peed, parent, false)
                return PeedViewHolder(view)
            }
        }
    }

    class FriendViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: Friend) {
            binding.apply {
//            peedImg.setImageResource()
//            .text = item.title
//            peedLikeCount.text = item.like_count.toString()
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): FriendViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_friend, parent, false)
                return FriendViewHolder(view)
            }
        }
    }

    class BoothViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: Booth) {
            binding.apply {
//            peedImg.setImageResource()
//                peedTitle.text = item.title
//                peedLikeCount.text = item.like_count.toString()
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): BoothViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_booth, parent, false)
                return BoothViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(item: Header) {
        this.items.add(item)
        this.notifyDataSetChanged()
    }
}