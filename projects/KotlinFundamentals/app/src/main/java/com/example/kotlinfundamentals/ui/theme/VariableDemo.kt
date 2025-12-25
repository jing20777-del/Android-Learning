package com.example.kotlinfundamentals.ui.theme

fun main() {
    val pi = 3.14159
    val name = "Android"

    var currentTemp = 25.0              // 自动推断为 Double
    currentTemp = 30.0

    val inferred = 10
    val explicit : Double = 10.0

    data class userProfile(val id : String,val name: String)
    val user = userProfile("1","John")


    println("pi = $pi, name = $name")
    println("currentTemp = $currentTemp")
    println("inferred = $inferred, explicit = $explicit")
    println("user = $user")

}