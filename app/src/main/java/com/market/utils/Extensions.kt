package com.market.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.market.dynamicui.domain.BannerItem
import com.market.dynamicui.domain.CircleItem
import com.market.dynamicui.domain.RectItem
import com.market.dynamicui.model.CardViewType
import com.market.dynamicui.model.datasource.BannerItemResponse
import com.market.dynamicui.model.datasource.CircleItemResponse
import com.market.dynamicui.model.datasource.RectItemResponse

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
            color = it.color,
            title = it.title,
            hasNewContents = it.hasNewContents
        )
    }
}

fun List<BannerItemResponse>.toBannerItemList(): List<BannerItem> {
    return map {
        BannerItem(
            title = it.title,
            contentsText = it.contentsText,
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

fun String.printLog(tag: String? = null) {
    Log.d("++$tag", this)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
