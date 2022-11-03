package com.market.dynamicui.mapper

import com.market.dynamicui.domain.*
import com.market.dynamicui.model.datasource.*
import com.market.utils.convertCardType
import com.market.utils.toBannerItemList
import com.market.utils.toCircleItemList
import com.market.utils.toRectItemList

fun List<CardResponse>.toCard(): List<Card> {
    return map {
        when (it) {
            is HeaderResponse -> {
                Header(
                    cardId = it.cardId.convertCardType(),
                    title = it.title,
                    buttonText = it.title,
                )
            }
            is VideoResponse -> {
                Video(
                    cardId = it.cardId.convertCardType(),
                    videoUrl = it.videoUrl,
                    videoTitle = it.videoTitle,
                    autoPlay = it.autoPlay,
                )
            }
            is CircleHorizontalListResponse -> {
                CircleHorizontalList(
                    cardId = it.cardId.convertCardType(),
                    circleItemList = it.circleItemList.toCircleItemList()
                )
            }
            is BannerHorizontalListResponse -> {
                BannerHorizontalList(
                    cardId = it.cardId.convertCardType(),
                    bannerItemList = it.bannerItemList.toBannerItemList()
                )
            }
            is RectHorizontalListResponse -> {
                RectHorizontalList(
                    cardId = it.cardId.convertCardType(),
                    rectItemList = it.rectItemList.toRectItemList()
                )
            }
            else -> {
                throw IllegalStateException("Not Found Card Type!!")
            }
        }
    }
}

