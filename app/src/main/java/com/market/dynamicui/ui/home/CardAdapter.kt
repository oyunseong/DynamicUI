package com.market.dynamicui.ui.home

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.market.dynamicui.domain.*
import com.market.dynamicui.domain.CardViewType
import com.market.dynamicui.utils.HorizontalItemDecorator
import com.market.dynamicui.utils.VerticalItemDecorator
import com.market.myzepeto.R

class CardAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Card> = emptyList()
    private val scrollStates = hashMapOf<Int, Parcelable>()

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
        val key = items[holder.adapterPosition].cardId
        val state = scrollStates[key]
        when (holder) {
            is VideoViewHolder -> {
                holder.bind(items[position] as Video)
            }
            is HeaderViewHolder -> {
                holder.bind(items[position] as Header)
            }
            is CircleHorizontalListViewHolder -> {
                holder.bind(items[position] as CircleHorizontalList)
                if (state != null) {
                    holder.horizontalLayoutManager.onRestoreInstanceState(state)
                } else {
                    holder.horizontalLayoutManager.scrollToPosition(0)
                }
            }
            is RectHorizontalListViewHolder -> {
                holder.bind(items[position] as RectHorizontalList)
                if (state != null) {
                    holder.horizontalLayoutManager.onRestoreInstanceState(state)
                } else {
                    holder.horizontalLayoutManager.scrollToPosition(0)
                }
            }
            is BannerHorizontalListViewHolder -> {
                holder.bind(items[position] as BannerHorizontalList)
                if (state != null) {
                    holder.horizontalLayoutManager.onRestoreInstanceState(state)
                } else {
                    holder.horizontalLayoutManager.scrollToPosition(0)
                }
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

            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): VideoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_video, parent, false)
                return VideoViewHolder(view)
            }
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        val key = items[holder.adapterPosition].cardId
        when (holder) {
            is CircleHorizontalListViewHolder -> {
                scrollStates[key] = holder.horizontalLayoutManager.onSaveInstanceState()!!
            }
            is BannerHorizontalListViewHolder -> {
                scrollStates[key] = holder.horizontalLayoutManager.onSaveInstanceState()!!
            }
            is RectHorizontalListViewHolder -> {
                scrollStates[key] = holder.horizontalLayoutManager.onSaveInstanceState()!!
            }
        }
    }

    class CircleHorizontalListViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        private val cardHorizontalAdapter = CardHorizontalAdapter()
        private var circleHorizontalRecyclerView: RecyclerView =
            binding.findViewById(R.id.circleRecyclerView)
        lateinit var horizontalLayoutManager: LinearLayoutManager

        fun bind(item: CircleHorizontalList) {
            cardHorizontalAdapter.setList(item.circleItemList)
            horizontalLayoutManager =
                LinearLayoutManager(binding.context, LinearLayoutManager.HORIZONTAL, false)
            circleHorizontalRecyclerView.apply {
                layoutManager = horizontalLayoutManager
                adapter = cardHorizontalAdapter
                addItemDecoration(HorizontalItemDecorator(8))
                addItemDecoration(VerticalItemDecorator(8))
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): CircleHorizontalListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_circle, parent, false)
                return CircleHorizontalListViewHolder(view)
            }
        }
    }

    class RectHorizontalListViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        private val cardHorizontalAdapter = CardHorizontalAdapter()
        private var rectHorizontalRecyclerView: RecyclerView =
            binding.findViewById(R.id.rectRecyclerView)
        lateinit var horizontalLayoutManager: LinearLayoutManager

        fun bind(item: RectHorizontalList) {
            cardHorizontalAdapter.setList(item.rectItemList)
            horizontalLayoutManager =
                LinearLayoutManager(binding.context, LinearLayoutManager.HORIZONTAL, false)
            rectHorizontalRecyclerView.apply {
                layoutManager = horizontalLayoutManager
                adapter = cardHorizontalAdapter
                addItemDecoration(HorizontalItemDecorator(8))
                addItemDecoration(VerticalItemDecorator(8))
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): RectHorizontalListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_rect, parent, false)
                return RectHorizontalListViewHolder(view)
            }
        }
    }

    class BannerHorizontalListViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding) {
        private val cardHorizontalAdapter = CardHorizontalAdapter()
        private var bannerHorizontalRecyclerView: RecyclerView =
            binding.findViewById(R.id.bannerRecyclerView)
        lateinit var horizontalLayoutManager: LinearLayoutManager

        fun bind(item: BannerHorizontalList) {
            cardHorizontalAdapter.setList(item.bannerItemList)
            horizontalLayoutManager =
                LinearLayoutManager(binding.context, LinearLayoutManager.HORIZONTAL, false)
            bannerHorizontalRecyclerView.apply {
                layoutManager = horizontalLayoutManager
                adapter = cardHorizontalAdapter
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): BannerHorizontalListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_banner, parent, false)
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