package com.market.myzepeto.model


/**
 * @param type {1 : Menu,
 *             {2 : Peed,
 *             {3 : Friend,
 *             {4 : Booth
 * */
interface Header {
    val type: Int
    val image: String
    val title: String
}

data class Menu(
    override val type: Int,
    override val image: String,
    override val title: String,
) : Header

data class Peed(
    override val type: Int,
    override val image: String,
    override val title: String,
    val text: String,
    val like_count: Int
) : Header

data class Friend(
    override val type: Int,
    override val image: String,
    override val title: String,
) : Header

data class Booth(
    override val type: Int,
    override val image: String,
    override val title: String,
    val text: String
) : Header

