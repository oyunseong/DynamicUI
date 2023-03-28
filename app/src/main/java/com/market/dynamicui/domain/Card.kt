package com.market.dynamicui.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

abstract class Card {
    abstract val cardType: Int
    var cardId: Int = -1
}

data class Header(
    override val cardType: Int = CardViewType.HEADER.value,
    val title: String,
    val buttonText: String
) : Card()

data class Video(
    override val cardType: Int = CardViewType.VIDEO.value,
    val videoUrl: String,
    val videoTitle: String,
    val autoPlay: Boolean = false,
) : Card()

data class CircleHorizontalList(
    override val cardType: Int = CardViewType.CIRCLE_HORIZONTAL_LIST.value,
    val circleItemList: List<CircleItem>
) : Card()


data class BannerHorizontalList(
    override val cardType: Int = CardViewType.BANNER_HORIZONTAL_LIST.value,
    val bannerItemList: List<BannerItem>
) : Card()

data class RectHorizontalList(
    override val cardType: Int = CardViewType.RECT_HORIZONTAL_LIST.value,
    val rectItemList: List<RectItem>
) : Card()

abstract class CardItem

@Parcelize
data class CircleItem(
    val iconColor: String,
    val title: String,
    val hasNewContents: Boolean = false,
) : CardItem(), Parcelable

@Parcelize
data class BannerItem(
    val title: String,
    val subTitle: String,
    val contentsImageColor: String,
    val backgroundColor: String,
) : CardItem(), Parcelable

@Parcelize
data class RectItem(
    val thumbnailColor: String,
    val title: String,
    val subTitle: String
) : CardItem(), Parcelable


