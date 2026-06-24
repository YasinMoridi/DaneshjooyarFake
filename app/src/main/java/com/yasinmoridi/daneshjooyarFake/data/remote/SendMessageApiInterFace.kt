package com.yasinmoridi.daneshjooyarFake.data.remote

import com.yasinmoridi.daneshjooyarFake.data.model.NotifResponse
import com.yasinmoridi.daneshjooyarFake.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SendMessageApiInterFace {

    @GET("send")
    suspend fun sendMessage(
        @Query("to") token: String = Constants.TOKEN,
        @Query("text") text: String
    ):Response<NotifResponse>

}