package com.market.dynamicui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.market.dynamicui.domain.*
import com.market.dynamicui.model.CardViewType
import com.market.myzepeto.R

class CardAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Card> = emptyList()

    override fun getItemViewType(position: Int) = when (items[position]) {
        is Video -> {
            CardViewType.VIDEO.value
        }
        is Header -> {
            CardViewType.HEADER.value
        }
        is CircleHorizontalList -> {
            CardViewType.CIRCLE_HORIZONTAL_LIST.value
        }
        is RectHorizontalList -> {
            CardViewType.RECT_HORIZONTAL_LIST.value
        }
        is BannerHorizontalList -> {
            CardViewType.BANNER_HORIZONTAL_LIST.value
        }
        else -> {
            throw IllegalStateException("Not Found ViewHolder Type!!")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CardViewType.VIDEO.value -> {
                VideoViewHolder.create(parent)
            }
            CardViewType.HEADER.value -> {
                HeaderViewHolder.create(parent)
            }
            CardViewType.CIRCLE_HORIZONTAL_LIST.value -> {
                CircleHorizontalListViewHolder.create(parent)
            }
            CardViewType.RECT_HORIZONTAL_LIST.value -> {
                RectHorizontalListViewHolder.create(parent)
            }
            CardViewType.BANNER_HORIZONTAL_LIST.value -> {
                BannerHorizontalListViewHolder.create(parent)
            }
            else -> {
                throw IllegalStateException("Not Found ViewHolder Type $viewType")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is VideoViewHolder -> {
                holder.bind(items[position] as Video)
            }
            is HeaderViewHolder -> {
                holder.bind(items[position] as Header)
            }
            is CircleHorizontalListViewHolder -> {
                holder.bind(items[position] as CircleHorizontalList)
            }
            is RectHorizontalListViewHolder -> {
                holder.bind(items[position] as RectHorizontalList)
            }
            is BannerHorizontalListViewHolder -> {
                holder.bind(items[position] as BannerHorizontalList)
            }
            else -> {
                throw IllegalStateException("Not Found ViewHolder Type ;( ")
            }
        }
    }

    class HeaderViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        private val title = binding.findViewById<TextView>(R.id.headerTitle)
        private val buttonText = binding.findViewById<TextView>(R.id.headerButtonText)
        fun bind(item: Header) {
            binding.apply {
                title.text = item.title
                buttonText.text = item.buttonText
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): HeaderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_header, parent, false)
                return HeaderViewHolder(view)
            }
        }
    }

    class VideoViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: Video) {
            binding.apply {
                // TODO
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): VideoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_circle, parent, false)
                return VideoViewHolder(view)
            }
        }
    }

    class CircleHorizontalListViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: CircleHorizontalList) {
            binding.apply {
                // TODO
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): CircleHorizontalListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_circle, parent, false)
                return CircleHorizontalListViewHolder(view)
            }
        }
    }

    class RectHorizontalListViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        fun bind(item: RectHorizontalList) {
            binding.apply {
                // TODO
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): RectHorizontalListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_circle, parent, false)
                return RectHorizontalListViewHolder(view)
            }
        }
    }

    class BannerHorizontalListViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        //        val title: TextView = binding.findViewById<TextView>(R.id.bannerTitle)
//        val bannerItemList: RecyclerView = binding.findViewById<RecyclerView>(R.id.bannerRecyclerView)

        fun bind(item: BannerHorizontalList) {
            binding.apply {
//                bannerItemList
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): BannerHorizontalListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_circle, parent, false)
                return BannerHorizontalListViewHolder(view)
            }
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    fun setList(item: List<Card>) {
        this.items = item
        notifyDataSetChanged()
    }
}