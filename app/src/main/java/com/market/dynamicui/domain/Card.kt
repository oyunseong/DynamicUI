package com.market.dynamicui.domain

import com.market.dynamicui.model.*

abstract class Card {
    abstract val cardId: Int
}

data class Header(
    override val cardId: Int = CardViewType.HEADER.value,
    val title: String,
    val buttonText: String
) : Card()

data class Video(
    override val cardId: Int = CardViewType.VIDEO.value,
    val videoUrl: String,
    val videoTitle: String,
    val autoPlay: Boolean = false,
) : Card()

data class CircleHorizontalList(
    override val cardId: Int = CardViewType.CIRCLE_HORIZONTAL_LIST.value,
    val circleItemList: List<CircleItem>
) : Card()

data class CircleItem(
    val iconColor: String,
    val title: String,
    val hasNewContents: Boolean = false,
)

data class BannerHorizontalList(
    override val cardId: Int = CardViewType.BANNER_HORIZONTAL_LIST.value,
    val bannerItemList: List<BannerItem>
) : Card()

data class BannerItem(
    val title: String,
    val subTitle: String,
    val contentsImageColor: String,
    val backgroundColor: String,
)

data class RectHorizontalList(
    override val cardId: Int = CardViewType.RECT_HORIZONTAL_LIST.value,
    val rectItemList: List<RectItem>
) : Card()

data class RectItem(
    val thumbnailColor: String,
    val title: String,
    val subTitle: String
)