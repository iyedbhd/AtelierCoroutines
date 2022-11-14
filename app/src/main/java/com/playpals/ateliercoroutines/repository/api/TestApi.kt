package com.playpals.ateliercoroutines.repository.api

import com.google.gson.annotations.SerializedName
import com.playpals.ateliercoroutines.repository.ApiClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

data class DataResponse(
    @SerializedName("data")
    var data: String
)

interface TestApi {
    @GET("getData")
    fun getData(): Call<DataResponse>


    companion object {
        fun getApi(): TestApi? {
            return ApiClient.client?.create(TestApi::class.java)
        }
    }

}