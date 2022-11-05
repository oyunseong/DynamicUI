package com.market.dynamicui.model.datasource

/**
 * 서버 코드는 클라에서 접근 불가능
 * FakeServer만 접근가능
 * */

class CardService {

    suspend fun loadCards(): List<CardResponse> {
        return buildList {
            add(
                HeaderResponse(
                    title = "헤더1",
                    buttonText = "더보기1"
                )
            )
            add(
                VideoResponse(
                    videoUrl = "",
                    videoTitle = "",
                    autoPlay = false
                )
            )
            add(
                HeaderResponse(
                    title = "헤더2",
                    buttonText = "더보기2"
                )
            )
            add(
                BannerHorizontalListResponse(
                    bannerItemList = listOf(
                        BannerItemResponse(
                            title = "10.28 ~ 11.09",
                            contentsText = "내 아바타 인증하고,\nBLACKPINK 콘서트 가자",
                            contentsImageColor = "#000000",
                            backgroundColor = "#FBA1C0"
                        )
                    )
                )
            )
            add(
                HeaderResponse(
                    title = "헤더3",
                    buttonText = "더보기3"
                )
            )
            add(
                CircleHorizontalListResponse(
                    circleItemList = listOf(
                        CircleItemResponse(
                            color = "#000000",
                            title = "",
                            hasNewContents = false
                        ),
                        CircleItemResponse(
                            color = "#000000",
                            title = "",
                            hasNewContents = false
                        ),
                        CircleItemResponse(
                            color = "#000000",
                            title = "",
                            hasNewContents = true
                        )
                    )
                )
            )
        }
    }
}
