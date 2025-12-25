package com.example.kotlinfundamentals

fun main(){
    val converter = CelsiusToFahrenheitConverter()
    val waterTemp = -2.0
    val isFreezing = isFreezing(waterTemp)

    println("0°C = ${celsiusToFahrenheit(0.0)}°F")
    println("100°C = ${converter.convert(100.0)}°F")
    println("$waterTemp°的水能结冰么： $isFreezing")
    println("Greeting: ${greet(name = "Alice")}")
    println("Message: ${createMessage(body = "Hi there", tittle = "Notice")}")
    println("Is boiling? ${isBoiling(99.0)}")


}
//1.基础函数--带参+返回值
fun celsiusToFahrenheit(celsius: Double): Double{
    return celsius * 9.0 / 5.0 +32.0
}

//2.默认参数--简化调用
fun greet (name: String = "Guest", times: Int = 1): String{
    return "Helo, $name!".repeat(times)
}

//3.命名参数--提高可读性
fun createMessage(tittle: String, body: String): String{
    return "[$tittle] $body"
}

//4.表达式函数--单行简化
fun isBoiling(celsius: Double) = celsius >= 100.0

fun isFreezing(celsius: Double) = celsius <= 0.0

//5.企业级模式：函数vs方法
interface TemperatureConverter{
    fun convert(celsius: Double): Double

    fun logConvert(celsius: Double){
        val result = convert (celsius)

    }
}


class  CelsiusToFahrenheitConverter : TemperatureConverter {
    override fun convert(celsius: Double) = celsius * 9.0 / 5.0 + 32.0

    //新增方法：判断转换后的华氏度是否沸腾（212华氏度）
    fun isBoiling(celsius: Double): Boolean{
        val fahrenheit = convert(celsius)
        return fahrenheit >= 212.0
    }
}




