package com.example.thermometer

fun celsiusToFahrenheit(c: Double): Double{
    require(c >= -273.15){"Teperature below absolute zero"}
    val fahrenheit = c * 9.0 / 5.0 +32.0
    return fahrenheit
}

fun main(){
    val result = celsiusToFahrenheit(0.0)
    println("0°C = $result°F")
}