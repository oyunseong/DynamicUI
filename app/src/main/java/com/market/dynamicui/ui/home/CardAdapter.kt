package com.market.dynamicui.ui.home

import android.net.Uri
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.market.dynamicui.domain.*
import com.market.dynamicui.domain.CardViewType
import com.market.dynamicui.utils.HorizontalItemDecorator
import com.market.dynamicui.utils.VerticalItemDecorator
import com.market.dynamicui.R

class CardAdapter(
    private val onItemClickListener: (CardItem, Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Card> = emptyList()
    private val scrollStates = hashMapOf<Int, Parcelable>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("^^CardAdapter", "onCreateViewHolder call $parent, $viewType")
        return when (viewType) {
            CardViewType.VIDEO.value -> {
                VideoViewHolder.create(parent)
            }
            CardViewType.HEADER.value -> {
                HeaderViewHolder.create(parent)
            }
            CardViewType.CIRCLE_HORIZONTAL_LIST.value -> {
                CircleHorizontalListViewHolder.create(parent, onItemClickListener)
            }
            CardViewType.RECT_HORIZONTAL_LIST.value -> {
                RectHorizontalListViewHolder.create(parent, onItemClickListener)
            }
            CardViewType.BANNER_HORIZONTAL_LIST.value -> {
                BannerHorizontalListViewHolder.create(parent, onItemClickListener)
            }
            else -> {
                throw IllegalStateException("Not Found ViewHolder Type $viewType")
            }
        }
    }

    override fun getItemViewType(position: Int) = when (items[position]) {
        is Video -> {
            CardViewType.VIDEO.value
        }
        is Header -> {
            CardViewType.HEADER.value
        }
        is CircleHorizontalList -> {
            Log.d("^^CircleHorizontalList", "getItemViewType call")
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

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        when (holder) {
            is VideoViewHolder -> {
                holder.player?.playWhenReady = true
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        when (holder) {
            is VideoViewHolder -> {
                holder.player?.playWhenReady = false
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
            is CircleHorizontalListViewHolder -> {
                holder.bind(items[position] as CircleHorizontalList)
                // state가 저장된 적이 있다면
                if (state != null) {
                    // 상태 저장 SavedState 하고 다시 그리기!
                    holder.horizontalLayoutManager.onRestoreInstanceState(state)
                } else {
                    // position 번째 item으로 이동시켜라!
                    holder.horizontalLayoutManager.scrollToPosition(0)
                }
            }
            is HeaderViewHolder -> {
                holder.bind(items[position] as Header)
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
        lateinit var layoutManager: LinearLayoutManager
        var exoPlayerView: PlayerView = binding.findViewById(R.id.exoPlayerView)
        var player: SimpleExoPlayer? = null
        private var sampleUrl =
            "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"

        // 출력할 미디어 정보를 가져옴
        private fun buildMediaSource(
            uri: String
        ): MediaSource {
            val dataSourceFactory = DefaultDataSourceFactory(binding.context, "sample")
            return ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(MediaItem.fromUri(Uri.parse(uri)))
        }

        //TODO 유튜브는 안나옴 WHY?
        fun bind(item: Video) {
            if (player == null) {
                player = SimpleExoPlayer.Builder(binding.context).build()
                exoPlayerView.player = player
                buildMediaSource(item.videoUrl).let {
                    player?.prepare(it)
                }
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

    /**
     * ViewHolder가 재사용될 때 호출됩니다.
     * 즉, RecyclerView에서 VewiHolder가 다른 데이터로 바인딩되기 전에 호출됩니다.
     */
    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        Log.d("^^onViewRecycled", "onViewRecycled call!")
        val key = items[holder.bindingAdapterPosition].cardId
        when (holder) {
            is CircleHorizontalListViewHolder -> {
                // LayoutManager의 Parcelable 변수에 recyclerView의 상태를 Parcelable 형식으로 저장
                // Parcelable = 포장 가능한 = Parcel 포장, able 가능한
                scrollStates[key] = holder.horizontalLayoutManager.onSaveInstanceState()!!
                Log.d("^^onViewRecycled", "holder.horizontalLayoutManager.onSaveInstanceState()")
            }
            is BannerHorizontalListViewHolder -> {
                scrollStates[key] = holder.horizontalLayoutManager.onSaveInstanceState()!!
            }
            is RectHorizontalListViewHolder -> {
                scrollStates[key] = holder.horizontalLayoutManager.onSaveInstanceState()!!
            }
        }
    }

    class CircleHorizontalListViewHolder(
        private val binding: View,
        private val onItemClickListener: (CardItem, Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding) {
        private val cardHorizontalAdapter = CardHorizontalAdapter(onItemClickListener)
        private var circleHorizontalRecyclerView: RecyclerView =
            binding.findViewById(R.id.circleRecyclerView)
        lateinit var horizontalLayoutManager: LinearLayoutManager

        init {
            initItemDistance()
        }

        private fun initItemDistance() {
            circleHorizontalRecyclerView.apply {
                addItemDecoration(HorizontalItemDecorator(8))
                addItemDecoration(VerticalItemDecorator(8))
            }
        }

        fun bind(item: CircleHorizontalList) {
            cardHorizontalAdapter.setList(item.circleItemList)
            horizontalLayoutManager =
                LinearLayoutManager(binding.context, LinearLayoutManager.HORIZONTAL, false)
            circleHorizontalRecyclerView.apply {
                layoutManager = horizontalLayoutManager
                adapter = cardHorizontalAdapter
            }
        }

        companion object Factory {
            fun create(
                parent: ViewGroup,
                onItemClickListener: (CardItem, Int) -> Unit
            ): CircleHorizontalListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_circle, parent, false)
                return CircleHorizontalListViewHolder(view, onItemClickListener)
            }
        }
    }

    class RectHorizontalListViewHolder(
        private val binding: View,
        private val onItemClickListener: (CardItem, Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding) {
        private val cardHorizontalAdapter = CardHorizontalAdapter(onItemClickListener)
        private var rectHorizontalRecyclerView: RecyclerView =
            binding.findViewById(R.id.rectRecyclerView)
        lateinit var horizontalLayoutManager: LinearLayoutManager

        init {
            initItemDistance()
        }

        private fun initItemDistance() {
            rectHorizontalRecyclerView.apply {
                addItemDecoration(HorizontalItemDecorator(8))
                addItemDecoration(VerticalItemDecorator(8))
            }
        }

        fun bind(item: RectHorizontalList) {
            cardHorizontalAdapter.setList(item.rectItemList)
            horizontalLayoutManager =
                LinearLayoutManager(binding.context, LinearLayoutManager.HORIZONTAL, false)
            rectHorizontalRecyclerView.apply {
                layoutManager = horizontalLayoutManager
                adapter = cardHorizontalAdapter
            }
        }


        companion object Factory {
            fun create(
                parent: ViewGroup,
                onItemClickListener: (CardItem, Int) -> Unit
            ): RectHorizontalListViewHolder {
                Log.d("++RectHorizontalListViewHolder", "Factory create")
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_rect, parent, false)
                return RectHorizontalListViewHolder(view, onItemClickListener)
            }
        }
    }

    class BannerHorizontalListViewHolder(
        private val binding: View,
        private val onItemClickListener: (CardItem, Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding) {
        private val cardHorizontalAdapter = CardHorizontalAdapter(onItemClickListener)
        private var bannerHorizontalRecyclerView: RecyclerView =
            binding.findViewById(R.id.bannerRecyclerView)
        lateinit var horizontalLayoutManager: LinearLayoutManager

        init {
            initItemDistance()
        }

        private fun initItemDistance() {
            bannerHorizontalRecyclerView.apply {
                addItemDecoration(HorizontalItemDecorator(8))
                addItemDecoration(VerticalItemDecorator(8))
            }
        }

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
            fun create(
                parent: ViewGroup,
                onItemClickListener: (CardItem, Int) -> Unit
            ): BannerHorizontalListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_type_banner, parent, false)
                return BannerHorizontalListViewHolder(view, onItemClickListener)
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