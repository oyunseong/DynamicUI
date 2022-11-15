package com.market.dynamicui.domain

import com.google.gson.annotations.SerializedName

data class Maple(
    @SerializedName("jobImprintList")
    val title: List<String>,
) {
}