package com.market.dynamicui.utils

fun createRandomColorCode(): String {
    val r = (Math.random() * 255).toInt()
    val g = (Math.random() * 255).toInt()
    val b = (Math.random() * 255).toInt()
    val colorCode = (r * g * b).toString(16)
    if (colorCode.length != 6) {
        return "#${String.format("%6s", colorCode).replace(' ', '0')}"
    }
    return "#${(r * g * b).toString(16)}"
}