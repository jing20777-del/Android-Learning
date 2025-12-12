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

//@Preview(showBackground = true, name = "状态提升示例")
@Composable
fun ThermometerInputField(
    celsiusInput: String,
    onCelsiusChange: (String) -> Unit,
    fahrenheit: Double

) {

    Column(
        modifier = Modifier
            .fillMaxSize() //沾满屏幕
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = celsiusInput,
            onValueChange = onCelsiusChange,
            label = {Text("摄氏度")},
            placeholder = {Text("例如: 36.5")}
        )

        Text(
            text = "华氏度: $fahrenheit°F",
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}


@Composable
fun ThermometerScreen(){
    var celsiusInput by remember { mutableStateOf("0") }
    val celsius = celsiusInput.toDoubleOrNull() ?: 0.0
    val fahrenheit = celsius * 9.0 / 5.0 + 32.0

    ThermometerInputField(
        celsiusInput = celsiusInput,
        onCelsiusChange = { celsiusInput = it },
        fahrenheit = fahrenheit
    )
}
