package com.market.dynamicui.mapper

import com.market.dynamicui.domain.*
import com.market.dynamicui.model.datasource.*

fun List<CardResponse>.toCard(): List<Card> {
    return map {
        when (it) {
            is HeaderResponse -> {
                Header(
                    cardId = it.cardId.convertCardType(),
                    title = it.title,
                    buttonText = it.buttonText,
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

fun String.convertCardType(): Int {
    return when (this) {
        CardViewType.HEADER.name -> CardViewType.HEADER.value
        CardViewType.VIDEO.name -> CardViewType.VIDEO.value
        CardViewType.CIRCLE_HORIZONTAL_LIST.name -> CardViewType.CIRCLE_HORIZONTAL_LIST.value
        CardViewType.BANNER_HORIZONTAL_LIST.name -> CardViewType.BANNER_HORIZONTAL_LIST.value
        CardViewType.RECT_HORIZONTAL_LIST.name -> CardViewType.RECT_HORIZONTAL_LIST.value
        else -> {
            throw IllegalStateException("Can't convert Card Type!!")
        }
    }
}

fun List<CircleItemResponse>.toCircleItemList(): List<CircleItem> {
    return map {
        CircleItem(
            iconColor = it.iconColor,
            title = it.title,
            hasNewContents = it.hasNewContents
        )
    }
}

fun List<BannerItemResponse>.toBannerItemList(): List<BannerItem> {
    return map {
        BannerItem(
            title = it.title,
            subTitle = it.subTitle,
            contentsImageColor = it.contentsImageColor,
            backgroundColor = it.backgroundColor
        )
    }
}

fun List<RectItemResponse>.toRectItemList(): List<RectItem> {
    return map {
        RectItem(
            thumbnailColor = it.thumbnailColor,
            title = it.title,
            subTitle = it.subTitle
        )
    }
}

