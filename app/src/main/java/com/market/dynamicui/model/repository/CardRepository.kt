package com.market.dynamicui.model.repository

import com.market.dynamicui.domain.Card
import com.market.dynamicui.mapper.toCard
import com.market.dynamicui.model.datasource.CardService


class CardRepository(private val cardService: CardService) {
    suspend fun getLoadCards(): List<Card> {
        return cardService.loadCards().toCard()
    }
}