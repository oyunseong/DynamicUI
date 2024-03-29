package com.market.dynamicui.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.market.dynamicui.domain.Card
import com.market.dynamicui.model.datasource.CardService
import com.market.dynamicui.model.repository.CardRepository
import kotlinx.coroutines.launch

class CardViewModel(
    private val cardRepository: CardRepository = CardRepository(
        CardService()
    )
) : ViewModel() {

    private val _cardDataList = MutableLiveData<List<Card>>()
    val cardDataList: LiveData<List<Card>> get() = _cardDataList

    init {
        getLoadCardData()
    }

    private fun getLoadCardData() = viewModelScope.launch {
        _cardDataList.value = cardRepository.getLoadCards()
        setCardIdsWithListIndex()
    }

    private fun setCardIdsWithListIndex() {
        _cardDataList.value?.forEachIndexed { index, card ->
            card.cardId = index
        }
    }
}