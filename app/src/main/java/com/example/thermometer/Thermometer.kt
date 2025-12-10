package com.example.thermometer

fun celsiusToFahrenheit(c: Double): Double{
    require(c >= -273.15){"Teperature below absolute zero"}
    return c * 9/5 + 32
}