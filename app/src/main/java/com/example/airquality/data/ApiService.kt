package com.example.airquality.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("feed/here/")
    suspend fun getAirQualityData(
        @Query("token") token: String
    ): AirQualityResponse
}
