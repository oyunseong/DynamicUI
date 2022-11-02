package com.market.dynamicui.mapper

import com.market.dynamicui.domain.Card
import com.market.dynamicui.model.CardType
import com.market.dynamicui.model.datasource.CardResponse

// 무엇을 할것인가?
// CardResponse 타입 리스트를 받아 그 안에있는 String 타입인 cardId를 int 타입으로 변환할거임
fun List<CardResponse>.toCard(): List<Card> {
    return map {

    }
}