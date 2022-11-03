package com.market.dynamicui.model.datasource

import com.market.dynamicui.domain.Card
import com.market.dynamicui.mapper.toCard


class CardRepository(private val cardService: CardService) {
    suspend fun getLoadCards(): List<Card> {
        return cardService.loadCards().toCard()
    }
}