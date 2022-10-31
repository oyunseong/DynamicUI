package com.market.myzepeto.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.market.myzepeto.R
import com.market.myzepeto.model.Header

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.HeaderViewHolder>() {
    private val items = mutableListOf<Header>()

    inner class HeaderViewHolder constructor(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.)
    )


    override fun onBindViewHolder(holder: RecyclerAdapter, position: Int) {
        val currentHeader = getItem(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.HeaderViewHolder {
        TODO("Not yet implemented")
    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Header>() {
            override fun areItemsTheSame(oldItem: Header, newItem: Header): Boolean {
                return true
//                return oldItem.title = newItem.title
            }

            override fun areContentsTheSame(oldItem: Header, newItem: Header): Boolean {
                return true
            }
        }
    }
    // https://hanyeop.tistory.com/247
}