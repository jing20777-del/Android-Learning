package com.example.kotlinfundamentals

fun main(){
    val sensor = TemperatureSensor(-20.0,50.0)
    println("Sensor valid for 25℃ ${sensor.validate(25.0)}")

  /*  val record = TemperatureRecord(25.0)
    println("Record: $record")
    println("Fahrenheit: ${record.fahrenheit}℉")*/

  /*  val newRecord = record.withCelsius(30.0)
    println("New record: $newRecord")*/
}

class TemperatureSensor(val min: Double,val max: Double){
    init {
        require(min < max){"Invalid range: $min >= $max"}
    }

    fun validate(celsius: Double): Boolean{
        return celsius in min..max
    }
}


//range: Pair<Double, Double> = 定义一个名为 range 的属性，它的类型是 “存储两个 Double 类型元素的成对数据结构”，核心用来封装有逻辑关联的两个值
///写法1：用 to 关键字（推荐，更易读） val range1 = 0.0 to 100.0 // 等价于 Pair(0.0, 100.0)
///写法2：直接调用 Pair 构造函数（和Java风格一致）  val range2 = Pair(0.0, 100.0)
class LegacySensor{
    var range: Pair<Double, Double> = 0.0 to 100.0

    constructor()
    constructor(min: Double,max: Double){
        range = min to max
    }
}


/*
data class TemperatureRecord(
    val celsius: Double,
    val timestamp: Long = System.currentTimeMillis() //系统时间
){
    val fahrenheit: Double get() = celsius * 9.0 / 5.0 + 32.0

    fun withCelsius(newCelsius: Double): TemperatureRecord {
        return copy(celsius = newCelsius)
    }
}*/
