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
                VideoResponse(
                    videoUrl = "",
                    videoTitle = "",
                    autoPlay = false
                )
            )
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
                        ),
                        CircleItemResponse(
                            iconColor = "#ff8c00",
                            title = "튜토리얼",
                            hasNewContents = false,
                        ),
                        CircleItemResponse(
                            iconColor = "#ff8c00",
                            title = "더보기",
                            hasNewContents = false,
                        )
                    )
                )
            )
            add(
                HeaderResponse(
                    title = "실시간 추천 피드",
                    buttonText = "더보기"
                )
            )
            add(
                BannerHorizontalListResponse(
                    bannerItemList = listOf(
                        BannerItemResponse(
                            title = "10.28 ~ 11.09",
                            subTitle = "내 아바타 인증하고,\nBLACKPINK 콘서트 가자",
                            contentsImageColor = "#ff0000",
                            backgroundColor = "#FBA1C0"
                        ),
                        BannerItemResponse(
                            title = "10.28 ~ 11.09",
                            subTitle = "내 아바타 인증하고,\nBLACKPINK 콘서트 가자",
                            contentsImageColor = "#ff8c00",
                            backgroundColor = "#4b0082"
                        )
                    )
                )
            )
            add(
                HeaderResponse(
                    title = "헤더2",
                    buttonText = "더보기2"
                )
            )
            add(
                HeaderResponse(
                    title = "친구",
                    buttonText = "더보기"
                )
            )
            add(
                CircleHorizontalListResponse(
                    circleItemList = listOf(
                        CircleItemResponse(
                            iconColor = "#2a6214",
                            title = "친구 추가",
                            hasNewContents = false
                        ),
                        CircleItemResponse(
                            iconColor = "#546782",
                            title = "Daum",
                            hasNewContents = false
                        ),
                        CircleItemResponse(
                            iconColor = "#546782",
                            title = "Google",
                            hasNewContents = true
                        ),
                        CircleItemResponse(
                            iconColor = "#546782",
                            title = "Naver",
                            hasNewContents = true
                        ),
                        CircleItemResponse(
                            iconColor = "#546782",
                            title = "android11",
                            hasNewContents = true
                        ),
                        CircleItemResponse(
                            iconColor = "#546782",
                            title = "Kakao",
                            hasNewContents = true
                        )
                    )
                )
            )
            add(
                HeaderResponse(
                    title = "월드 핫플레이스 Top 7",
                    buttonText = "더보기"
                )
            )
        }
    }
}
