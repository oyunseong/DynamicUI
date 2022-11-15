package com.market.dynamicui.model.server

import com.market.dynamicui.domain.Maple
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface MapleAPI {
    @GET("soap/maplestory.asmx?wsdl")
    fun getData(): Call<Maple>

    @POST()
    fun postData(): Call<Maple>
}