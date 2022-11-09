package com.market.dynamicui.model.datasource

import com.market.dynamicui.domain.CircleHorizontalList

/**
 * 서버 코드는 클라에서 접근 불가능
 * FakeServer만 접근가능
 * */

class CardService {

    suspend fun loadCards(): List<CardResponse> {
        return buildList {
            add(
                CircleHorizontalListResponse(
                    circleItemList = listOf(
                        CircleItemResponse(
                            iconColor = "#ff0000",
                            title = "인기 라이브",
                            hasNewContents = false,
                        ),
                        CircleItemResponse(
                            iconColor = "#ff8c00",
                            title = "퀘스트",
                            hasNewContents = false,
                        ),
                        CircleItemResponse(
                            iconColor = "#ffff00",
                            title = "BLACKPINK\n월드투어",
                            hasNewContents = false,
                        ),
                        CircleItemResponse(
                            iconColor = "#008000",
                            title = "무료코인",
                            hasNewContents = false,
                        ),
                        CircleItemResponse(
                            iconColor = "#0000ff",
                            title = "스타일",
                            hasNewContents = false,
                        ),CircleItemResponse(
                            iconColor = "#4b0082",
                            title = "크루",
                            hasNewContents = false,
                        ),
                        CircleItemResponse(
                            iconColor = "#ff0000",
                            title = "이벤트",
                            hasNewContents = false,
                        ),
                        CircleItemResponse(
                            iconColor = "#ff8c00",
                            title = "카메라",
                            hasNewContents = false,
                        )

                    )


                )
            )
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
                            subTitle = "내 아바타 인증하고,\nBLACKPINK 콘서트 가자",
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
                            iconColor = "#2a6214",
                            title = "원1",
                            hasNewContents = false
                        ),
                        CircleItemResponse(
                            iconColor = "#546782",
                            title = "원2",
                            hasNewContents = false
                        ),
                        CircleItemResponse(
                            iconColor = "#g4521d",
                            title = "원3",
                            hasNewContents = true
                        )
                    )
                )
            )
        }
    }
}
