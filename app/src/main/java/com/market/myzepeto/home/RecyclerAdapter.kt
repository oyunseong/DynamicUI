package com.market.myzepeto.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.market.myzepeto.R
import com.market.myzepeto.databinding.ItemTypeFriendBinding
import com.market.myzepeto.databinding.ItemTypeMenuBinding
import com.market.myzepeto.databinding.ItemTypePeedBinding
import com.market.myzepeto.model.*

class RecyclerAdapter<T>(list: ArrayList<T>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val items = list

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (viewType) {
            menu_type -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_type_menu,
                    parent,
                    false
                )
                PeedViewHolder(view)
            }
            peed_type -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_type_peed,
                    parent,
                    false
                )
                PeedViewHolder(view)
            }
            friend_type -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_type_friend,
                    parent,
                    false
                )
                FriendViewHolder(view)
            }

            else -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_type_booth,
                    parent,
                    false
                )
                BoothViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (items[position].type) {
            menu_type -> {
                (holder as MenuViewHolder).bind(Menu(items[position]))
            }

        }
    }


    // https://hanyeop.tistory.com/247

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    inner class MenuViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: Menu) {
            binding.apply {
//            icon.background = item.title
//                title.text = item.title
            }
        }
    }

    inner class PeedViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: Peed) {
            binding.apply {
//            peedImg.setImageResource()
//                peedTitle.text = item.title
//                peedLikeCount.text = item.like_count.toString()
            }
        }
    }

    inner class FriendViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: Friend) {
            binding.apply {
//            peedImg.setImageResource()
//            .text = item.title
//            peedLikeCount.text = item.like_count.toString()
            }
        }
    }

    inner class BoothViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: Booth) {
            binding.apply {
//            peedImg.setImageResource()
//                peedTitle.text = item.title
//                peedLikeCount.text = item.like_count.toString()
            }
        }
    }
}