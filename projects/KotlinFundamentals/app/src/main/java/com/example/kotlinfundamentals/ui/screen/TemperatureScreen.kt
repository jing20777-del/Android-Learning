package com.example.kotlinfundamentals.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinfundamentals.fahrenheit
import com.example.kotlinfundamentals.toCelsius
import com.example.kotlinfundamentals.ui.component.TemperatureInputField

@Composable
fun TemperatureScreen(){
    var celsiusInput by remember { mutableStateOf("0") }

    val celsuis = celsiusInput
        .trim()
        .toCelsius()
        .coerceIn(0.0,100.0)

    val fahrenheit = celsuis.fahrenheit()

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TemperatureInputField(
            celsiusInput = celsiusInput,
            onCelsiusChange = { newValue ->
                if (newValue.all { it.isDigit() || it == '.' } &&
                    newValue.count { it == '.' } <= 1){
                    celsiusInput = newValue
                }
            },
            fahrenheit = fahrenheit,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}