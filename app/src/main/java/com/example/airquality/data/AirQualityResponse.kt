package com.example.airquality.data

import com.google.gson.annotations.SerializedName

data class AirQualityResponse(
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: Data
)

data class Data(
    @SerializedName("idx") val idx: Int,
    @SerializedName("aqi") val aqi: Int,
    @SerializedName("time") val time: Time,
    @SerializedName("city") val city: City,
    @SerializedName("iaqi") val iaqi: Iaqi,
    @SerializedName("forecast") val forecast: Forecast
)

data class Time(
    @SerializedName("v") val v: Long,
    @SerializedName("s") val s: String,
    @SerializedName("tz") val tz: String
)

data class City(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    @SerializedName("geo") val geo: List<String>
)

data class Iaqi(
    @SerializedName("pm25") val pm25: Pm25
)

data class Pm25(
    @SerializedName("v") val v: Int
)

data class Forecast(
    @SerializedName("daily") val daily: Daily
)

data class Daily(
    @SerializedName("pm25") val pm25: List<Pm25Forecast>
)

data class Pm25Forecast(
    @SerializedName("avg") val avg: Int,
    @SerializedName("day") val day: String,
    @SerializedName("max") val max: Int,
    @SerializedName("min") val min: Int
)
