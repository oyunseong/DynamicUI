package com.market.dynamicui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.market.dynamicui.domain.*
import com.market.dynamicui.model.CardViewType
import com.market.dynamicui.model.HorizontalListType
import com.market.myzepeto.R

class CardHorizontalAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var items: List<CardItem>

    fun setList(item: List<CardItem>) {
        this.items = item
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HorizontalListType.CIRCLE.value -> {
                CircleViewHolder.create(parent)
            }
            HorizontalListType.BANNER.value -> {
                BannerViewHolder.create(parent)
            }
            HorizontalListType.RECT.value -> {
                RectViewHolder.create(parent)
            }
            else -> {
                throw IllegalStateException("Not Found ViewHolder Type $viewType")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CircleViewHolder -> {
                holder.bind(items[position] as CircleItem)
            }
            is BannerViewHolder -> {
                holder.bind(items[position] as BannerItem)
            }
            is RectViewHolder -> {
                holder.bind(items[position] as RectItem)
            }
            else -> {
                throw IllegalStateException("Not Found ViewHolder Type ;( ")
            }
        }
    }

    override fun getItemViewType(position: Int) = when (items[position]) {
        is CircleItem -> {
            HorizontalListType.CIRCLE.value
        }
        is BannerItem -> {
            HorizontalListType.BANNER.value
        }
        is RectItem -> {
            HorizontalListType.RECT.value
        }
        else -> {
            throw IllegalStateException("Not Found ViewHolder Type!! $position, ${items[position]}")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CircleViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        private val circleIconColor: TextView = binding.findViewById(R.id.circleIconColor)
        private val circleItemTitle: TextView = binding.findViewById(R.id.circleItemTitle)
        fun bind(item: CircleItem) {
            binding.apply {
//                circleIconColor.setBackgroundColor(Color.parseColor(item.iconColor))
                circleItemTitle.text = item.title
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): CircleViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_circle, parent, false)
                return CircleViewHolder(view)
            }
        }
    }

    class BannerViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        private val bannerTitle: TextView = binding.findViewById(R.id.bannerTitle)
        private val bannerSubTitle: TextView = binding.findViewById(R.id.bannerSubTitle)

        //3
        //4
        fun bind(item: BannerItem) {
            bannerTitle.text = item.title
            bannerSubTitle.text = item.subTitle
        }

        companion object Factory {
            fun create(parent: ViewGroup): BannerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_banner, parent, false)
                return BannerViewHolder(view)
            }
        }
    }


    class RectViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        private val title: TextView = binding.findViewById(R.id.rectTitle)
        private val subTitle: TextView = binding.findViewById(R.id.rectSubTitle)
        private val image: ImageView = binding.findViewById(R.id.rectImage)

        fun bind(item: RectItem) {
            title.text = item.title
            subTitle.text = item.subTitle
            image.setBackgroundColor(Color.parseColor(item.thumbnailColor))
        }


        companion object Factory {
            fun create(parent: ViewGroup): RectViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_rect, parent, false)
                return RectViewHolder(view)
            }
        }
    }
}