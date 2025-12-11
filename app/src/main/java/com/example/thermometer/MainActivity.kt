package com.example.thermometer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thermometer.ui.theme.ThermometerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Preview(showBackground = true, name = "温度转换预览")
@Composable
fun ThermometerScreen() {
    val celsius = 0.0

    fun celsiusToFahrenheit(c: Double ) = c * 9/5 +32

    val fahrenheit = celsiusToFahrenheit(celsius)

    Column(
        modifier = Modifier
            .fillMaxSize() //沾满屏幕
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("摄氏度：$celsius°C")
        Text("华氏度：$fahrenheit°F")
    }
}
