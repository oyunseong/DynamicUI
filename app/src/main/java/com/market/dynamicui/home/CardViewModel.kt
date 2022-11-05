package com.market.dynamicui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.market.dynamicui.domain.Card
import com.market.dynamicui.domain.Video
import com.market.dynamicui.model.CardViewType
import com.market.dynamicui.model.datasource.CardRepository
import com.market.dynamicui.model.datasource.CardService
import kotlinx.coroutines.launch

class CardViewModel(
    private val cardRepository: CardRepository = CardRepository(
        CardService()
    )
) : ViewModel() {

    /**
     * TODO
     * 질문
     * Video 타입은 1개 ??
     * 2개 이상이면 List로 받아야할 지
     * */
    private val _video = MutableLiveData<Video>()
    val video: LiveData<Video> get() = _video

    private val _cardDataList = MutableLiveData<List<Card>>()
    val cardDataList: LiveData<List<Card>> get() = _cardDataList

    init {
        getLoadCardData()
    }

    fun getLoadCardData() = viewModelScope.launch {
        _cardDataList.value = cardRepository.getLoadCards()
    }
}