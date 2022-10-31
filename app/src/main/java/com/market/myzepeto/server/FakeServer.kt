package com.market.myzepeto.server

import org.json.JSONObject

class FakeServer {
}

abstract class Card : JSONObject() {
    abstract val cardId: Int
    val h: List<Header> = listOf(
        Header(1, "asd", "asd", "asd"),
        Header(1, "asd", "asd", "asd")
    )
}

data class Header(
    override val cardId: Int,
    val text: String,
    val icon: String,
    val menuText: String
) : Card()