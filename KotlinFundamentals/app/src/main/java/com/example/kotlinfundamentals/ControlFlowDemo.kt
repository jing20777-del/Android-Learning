package com.example.kotlinfundamentals

fun main(){

    val a = 10
    val b = 20
    val max = if (a > b ) a else b
    println("Max: $max")

    fun getTemperatureDescription(celsius: Double): String{
        return when{
            celsius < 0 -> "Freezing"
            celsius < 10 -> "Cold"
            celsius < 25 -> "Mild"
            else -> "Hot"
        }
    }
    println("${getTemperatureDescription(14.0)}")


    val temperatures = listOf(0.0,10.0,25.0,100.0)
    println("Temperature reports:")
    for (temp in temperatures){
        println("$temp℃ is ${getTemperatureDescription(temp)}")
    }


    println("Countdown:")
    for (i in 5 downTo 1){
        println("$i...")
    }

    //temps: List<Double>?   ?代表temps可以为空
    //?.filter { it > 0 }   过滤出>0的元素    filter是集合的过滤函数
    //forEach是遍历函数，作用：如果过滤后的列表不为 null，遍历每个元素并打印；否则不执行
    fun processTemperatures(temps: List<Double>?){
        temps
            ?.filter { it > 0 }
            ?.forEach { println("Valid safely: $it") }
    }
    processTemperatures(listOf(-10.0, 0.0, 25.0, 100.0))
    processTemperatures(null)
}





