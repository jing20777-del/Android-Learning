package com.example.thermometer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorInt
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thermometer.ui.theme.ThermometerTheme
import androidx.compose.runtime.*


data class Temperature(
    val celsius: Double
){
    val fahrenheit: Double get() = celsius * 9.0 / 5.0 + 32.0
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThermometerTheme {
                ThermometerScreen()
            }
        }
    }
}

@Preview(showBackground = true, name = "状态提升示例")

@Composable
fun ThermometerScreen(){
    var celsiusInput by remember { mutableStateOf("0") }
    val celsius = celsiusInput.toDoubleOrNull() ?:0.0

    val temperatureHistory = remember {
        mutableStateListOf<Temperature>()
    }

    LaunchedEffect(celsius) {
        if (temperatureHistory.none { it.celsius == celsius }){
            temperatureHistory.add(0, Temperature(celsius))
        }
    }

    Column (
        modifier = Modifier.fillMaxSize() //沾满屏幕
    ){
       TextField(
           value = celsiusInput,
           onValueChange = {celsiusInput = it },
           label = {Text("摄氏度")},
           modifier = Modifier.padding(16.dp)
       )

        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ){
            items(temperatureHistory){ temp ->
                TemperatureItem(temp)

        }
        }
    }
}
@Composable
fun TemperatureItem(temperature: Temperature) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text("摄氏度: ${temperature.celsius}°C")
        Text("华氏度: ${temperature.fahrenheit}°F")
    }
}
