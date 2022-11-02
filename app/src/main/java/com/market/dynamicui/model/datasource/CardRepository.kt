package com.market.dynamicui.model.datasource


class CardRepository(private val cardService: CardService) {
    suspend fun getDataAll(): List<CardResponse>{
        return cardService.loadCards()
    }
}