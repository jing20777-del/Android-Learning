package com.example.kotlinfundamentals.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*


@Composable
fun TemperatureInputField(
    celsiusInput : String,
    onCelsiusChange: (String) -> Unit,   //用户输入回调
    fahrenheit: Double,
    modifier: Modifier = Modifier
){
    //组件内部逻辑
    Column (modifier =  modifier){
        OutlinedTextField(
            value = celsiusInput,
            onValueChange = onCelsiusChange,
            label = { Text("摄氏度") }
        )
        Text(
            text = "华氏度： $fahrenheit℉",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}