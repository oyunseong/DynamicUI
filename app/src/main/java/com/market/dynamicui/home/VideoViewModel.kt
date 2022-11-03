package com.market.dynamicui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.market.dynamicui.model.datasource.CardRepository
import com.market.dynamicui.model.datasource.CardService
import kotlinx.coroutines.launch

class VideoViewModel(
    private val cardRepository: CardRepository = CardRepository(
        CardService()
    )
) : ViewModel() {

    fun getLoadCardData() = viewModelScope.launch {
        cardRepository.getLoadCards()
    }
}