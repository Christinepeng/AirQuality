package com.example.airquality

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airquality.data.AirQualityResponse
import com.example.airquality.data.RetrofitInstance
import kotlinx.coroutines.launch

class AirQualityViewModel : ViewModel() {
    private val apiService = RetrofitInstance.api
    private val apiKey = "9ca04852e4ce4a22c479d58e2d68dedc583f4a84"

    var airQualityData: MutableState<AirQualityResponse?> = mutableStateOf(null)
    private set

    fun fetchAirQualityData() {
        viewModelScope.launch {
            try {
                val response = apiService.getAirQualityData(apiKey)
                airQualityData.value = response
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }
}