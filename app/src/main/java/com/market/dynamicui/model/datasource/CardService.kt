package com.market.dynamicui.model.datasource

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
                HeaderResponse(
                    title = "",
                    buttonText = ""
                )
            )
            add(
                CircleHorizontalListResponse(
                    circleItemList = listOf(
                        CircleItem(
                            color = "#000000",
                            title = "",
                            hasNewContents = false
                        ),
                        CircleItem(
                            color = "#000000",
                            title = "",
                            hasNewContents = false
                        ),
                        CircleItem(
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
