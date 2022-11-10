package com.market.dynamicui.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.market.dynamicui.domain.BannerItem
import com.market.dynamicui.domain.CircleItem
import com.market.dynamicui.domain.RectItem
import com.market.dynamicui.domain.CardViewType
import com.market.dynamicui.model.datasource.BannerItemResponse
import com.market.dynamicui.model.datasource.CircleItemResponse
import com.market.dynamicui.model.datasource.RectItemResponse

fun String.printLog(tag: String? = null) {
    Log.d("++$tag", this)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
