package com.example.kotlinfundamentals

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinfundamentals.ui.screen.TemperatureScreen
import com.example.kotlinfundamentals.ui.theme.KotlinFundamentalsTheme



data class TemperatureRecord(val celsius: Double)

//----------作用域函数--------------
//apply：操作对象，返回对象本身 → 适合 “创建对象 + 初始化”（比如创建列表加元素、创建按钮设样式）；
fun createDefaultHistory(): List<TemperatureRecord>{
    return mutableListOf<TemperatureRecord>().apply {
        add(TemperatureRecord(0.0))
        add(TemperatureRecord(25.0))
        add(TemperatureRecord(100.0))
    }
}


//run：操作对象，返回最后一行结果 → 适合 “操作对象后算个值”（比如加完元素算个数、算平均值）；
fun getTotalRecordCount(): Int{
    return mutableListOf<TemperatureRecord>().run {
        add(TemperatureRecord(0.0))
        add(TemperatureRecord(25.0))
        size
    }
}

//----------高阶函数组合（filter/map）------------
val rawHistory = listOf(-10.0,0.0,25.0,100.0)
val validFahrenheit = rawHistory
    .filter { it in 0.0..100.0 }
    .map { it * 9.0 / 5.0 +32.0}


//---------扩展函数-----------------
fun String.toCelsius(): Double {
    return this.toDoubleOrNull() ?: 0.0
}

fun Double.fahrenheit(): Double{
    return this * 9.0 / 5.0 + 32.0
}

val pi =3.14159
val name = "Android"
var currentTemp = 25.0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinFundamentalsTheme {
                Surface {
                    TemperatureScreen()
                }
            }
        }
    }
}

/*
@Composable
fun TemperatureApp(){
    var celsiusInput by remember { mutableStateOf("0") }   //初始值默认是0，
    // remember保留状态,屏幕旋转、UI 重组时输入值不变

    val celsius = celsiusInput
        .trim()            //去除输入字符的首尾空格
        .toCelsius()
        .coerceIn(0.0 , 100.0)   //限制数值范围,小于0取0，大于100取100，中间值不变

    val fahrenheit = celsius.fahrenheit()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){ TextField(
        value = celsiusInput,
        onValueChange = { newValue ->
            if (newValue.all { it.isDigit() || it == '.' }){
                celsiusInput = newValue
            }
        },
        label = {Text("摄氏度")}
    )

        Text(
            text = "华氏度: $fahrenheit℉",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}*/


@Preview(showBackground = true)
@Composable
fun TemperatureReview(){
    TemperatureScreen()
}
