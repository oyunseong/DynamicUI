package com.market.dynamicui.domain

import com.market.dynamicui.model.datasource.CardResponseType

abstract class Card {
    abstract val cardId: String
}

data class Header(
    override val cardId: String = CardResponseType.HEADER.name,
    val title: String,
    val buttonText: String
) : Card()

data class Video(
    override val cardId: String = CardResponseType.VIDEO.name,
    val videoUrl: String,
    val videoTitle: String,
    val autoPlay: Boolean = false,
) : Card()

data class CircleHorizontalList(
    override val cardId: String = CardResponseType.CIRCLE_HORIZONTAL_LIST.name,
    val circleItemList: List<CircleItem>
) : Card()

data class CircleItem(
    val color: String,
    val title: String,
    val hasNewContents: Boolean = false,
)