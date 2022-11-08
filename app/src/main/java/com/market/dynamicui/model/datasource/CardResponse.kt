package com.market.dynamicui.model.datasource

/**
 * UI에서 Card Model을 그대로 쓸 수 없음
 * 여기는 network layer임 DTO
 * mapper를 하나 만들어서 모델들을 UI에 맞는 모델로 변환해야함
 * cardId String 타입을 mapper를 이용해 Int 타입으로 변환
 * CardRepository가 CardService 의존성을 갖게하고 ( 인스턴스 생성 )
 * viewmodel에서는 cardRepository를 봐야함
 * cardRepository에서는 CardService에서 CardList를 받고, 그대로 ui Model로 변환한 새로운 리스트 반환
 * */
abstract class CardResponse {
    abstract val cardId: String
}

data class HeaderResponse(
    override val cardId: String = CardResponseType.HEADER.name,
    val title: String,
    val buttonText: String
) : CardResponse()

data class VideoResponse(
    override val cardId: String = CardResponseType.VIDEO.name,
    val videoUrl: String,
    val videoTitle: String,
    val autoPlay: Boolean = false,
) : CardResponse()

data class CircleHorizontalListResponse(
    override val cardId: String = CardResponseType.CIRCLE_HORIZONTAL_LIST.name,
    val circleItemList: List<CircleItemResponse>
) : CardResponse()

data class CircleItemResponse(
    val iconColor: String,
    val title: String,
    val hasNewContents: Boolean = false,
)

data class BannerHorizontalListResponse(
    override val cardId: String = CardResponseType.BANNER_HORIZONTAL_LIST.name,
    val bannerItemList: List<BannerItemResponse>
) : CardResponse()

data class BannerItemResponse(
    val title: String,
    val subTitle: String,
    val contentsImageColor: String,
    val backgroundColor: String,
)

data class RectHorizontalListResponse(
    override val cardId: String,
    val rectItemList: List<RectItemResponse>
) : CardResponse()

data class RectItemResponse(
    val thumbnailColor: String,
    val title: String,
    val subTitle: String
)