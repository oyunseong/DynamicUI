package com.market.myzepeto.model

interface Header {
    val image: String
    val title: String
}

data class Menu(
    override val image: String,
    override val title: String,
) : Header

data class Peed(
    override val image: String,
    override val title: String,
    val text: String,
    val like_count: Int
) : Header

data class Friend(
    override val image: String,
    override val title: String,
) : Header

data class Booth(
    override val image: String,
    override val title: String,
    val text: String
) : Header

