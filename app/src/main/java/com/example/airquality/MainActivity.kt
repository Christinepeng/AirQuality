package com.example.airquality

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.airquality.ui.theme.AirQualityTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: AirQualityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AirQualityViewModel::class.java)
        setContent {
            AirQualityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AirQualityApp(viewModel)
                }
            }
        }
//        viewModel.fetchAirQualityData()
    }
}

@Composable
fun AirQualityApp(viewModel: AirQualityViewModel) {
    val airQualityData by viewModel.airQualityData

    LaunchedEffect(Unit) {
        viewModel.fetchAirQualityData()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        airQualityData?.let { data ->
            Text(
                text = "Air Quality Index: ${data.data.aqi}\nCity: ${data.data.city.name}\nPM2.5: ${data.data.iaqi.pm25.v}",
                modifier = Modifier.align(Alignment.Center)
            )
        } ?: Text(text = "Loading...", modifier = Modifier.align(Alignment.Center))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AirQualityTheme {
        AirQualityApp(viewModel = viewModel())
    }
}