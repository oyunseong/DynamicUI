package com.market.dynamicui.ui.home

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.market.dynamicui.domain.*
import com.market.dynamicui.domain.HorizontalListType
import com.market.myzepeto.R

class CardHorizontalAdapter(
    private val onItemClickListener: (CardItem, Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var items: List<CardItem>

    fun setList(item: List<CardItem>) {
        this.items = item
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HorizontalListType.CIRCLE.value -> {
                CircleViewHolder.create(parent, onItemClickListener)
            }
            HorizontalListType.BANNER.value -> {
                BannerViewHolder.create(parent, onItemClickListener)
            }
            HorizontalListType.RECT.value -> {
                RectViewHolder.create(parent, onItemClickListener)
            }
            else -> {
                throw IllegalStateException("Not Found ViewHolder Type $viewType")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CircleViewHolder -> {
                holder.bind(items[position] as CircleItem, position)
            }
            is BannerViewHolder -> {
                holder.bind(items[position] as BannerItem, position)
            }
            is RectViewHolder -> {
                holder.bind(items[position] as RectItem, position)
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

    class CircleViewHolder(
        private val binding: View,
        private val onItemClickListener: (CardItem, Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding) {
        private val circleIconColor: TextView = binding.findViewById(R.id.circleIconColor)
        private val circleItemTitle: TextView = binding.findViewById(R.id.circleItemTitle)
        fun bind(item: CircleItem, position: Int) {
            binding.apply {
                rootView.setOnClickListener {
                    onItemClickListener.invoke(item, position)
                }
                val states = arrayOf(intArrayOf(android.R.attr.state_enabled))
                val colors = intArrayOf(Color.parseColor(item.iconColor))
                val colorStateList = ColorStateList(states, colors)
                circleIconColor.backgroundTintList = colorStateList
                circleItemTitle.text = item.title
            }
        }

        companion object Factory {
            fun create(
                parent: ViewGroup,
                onItemClickListener: (CardItem, Int) -> Unit
            ): CircleViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_circle, parent, false)
                return CircleViewHolder(view, onItemClickListener)
            }
        }
    }

    class BannerViewHolder(
        private val binding: View,
        private val onItemClickListener: (CardItem, Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding) {
        private val bannerTitle: TextView = binding.findViewById(R.id.bannerTitle)
        private val bannerSubTitle: TextView = binding.findViewById(R.id.bannerSubTitle)
        private val bannerContentsImageColor: TextView =
            binding.findViewById(R.id.bannerContentsImage)
        private val bannerBackgroundColor: TextView =
            binding.findViewById(R.id.bannerBackgroundColor)

        fun bind(item: BannerItem, position: Int) {
            val states = arrayOf(intArrayOf(android.R.attr.state_enabled))
            val backgroundColor = intArrayOf(Color.parseColor(item.backgroundColor))
            val imageColor = intArrayOf(Color.parseColor(item.contentsImageColor))
            val backgroundColorStateList = ColorStateList(states, backgroundColor)
            val imageColorStateList = ColorStateList(states, imageColor)

            binding.rootView.setOnClickListener {
                onItemClickListener.invoke(item, position)
            }

            bannerTitle.text = item.title
            bannerSubTitle.text = item.subTitle
            bannerContentsImageColor.backgroundTintList = imageColorStateList
            bannerBackgroundColor.backgroundTintList = backgroundColorStateList
        }

        companion object Factory {
            fun create(
                parent: ViewGroup,
                onItemClickListener: (CardItem, Int) -> Unit
            ): BannerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_banner, parent, false)
                return BannerViewHolder(view, onItemClickListener)
            }
        }
    }

    class RectViewHolder(
        private val binding: View,
        private val onItemClickListener: (CardItem, Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding) {
        private val title: TextView = binding.findViewById(R.id.rectTitle)
        private val subTitle: TextView = binding.findViewById(R.id.rectSubTitle)
        private val image: TextView = binding.findViewById(R.id.rectImage)

        fun bind(item: RectItem, position: Int) {
            val states = arrayOf(intArrayOf(android.R.attr.state_enabled))
            val colors = intArrayOf(Color.parseColor(item.thumbnailColor))
            val colorStateList = ColorStateList(states, colors)
            binding.rootView.setOnClickListener {
                onItemClickListener.invoke(item, position)
            }

            title.text = item.title
            subTitle.text = item.subTitle
            image.backgroundTintList = colorStateList
        }


        companion object Factory {
            fun create(
                parent: ViewGroup,
                onItemClickListener: (CardItem, Int) -> Unit
            ): RectViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_rect, parent, false)
                return RectViewHolder(view, onItemClickListener)
            }
        }
    }
}