package com.example.kotlinfundamentals

fun main(){
    // 安全调用符 ?.     用法：变量?.方法/属性 → 变量非 null 才执行后面的操作
    // 1. ?.左边非空执行右边；左边为空0.0
    // 2. times(2)等价于乘以2
    // 3. toDoubleOrNull()把字符串转Double，失败返回null
    // 4. ?: 操作符   用法：可空变量 ?: 默认值 → 变量非 null 用变量值，否则用默认值
    // 5. 作用域函数 let { ... }     用法：变量?.let { 处理it } → 变量非 null 才进入大括号
    val userInput: String? = "25.0"
    val result = userInput?.let {
        it.toDoubleOrNull()?.times(2)
    }?: 0.0

    println("Result: $result")

    //6. 过滤函数 take if{..} 过滤空/不符合double类型的返回-1.0 类似安全值判断    用法：变量?.takeIf { 条件 } → 常用来替代 if (变量满足条件) { 执行 }
    val safeValue = userInput
        ?.takeIf { it.isNotBlank() }
        ?.toDoubleOrNull()
        ?.let { it * 3 }
        ?: -1.0

    println("Safe value： $safeValue")

    processInput("42.0")
    processInput(null)

}
fun processInput(input: String?){
    if (input != null && input.isNotBlank()){
        val value = input.toDoubleOrNull()
        if (value != null){
            println("Processed: $value")
        }
    }

    input
        ?.takeIf { it.isNotBlank() }
        ?.toDoubleOrNull()
        ?.let { println("Processed safely: $it") }
}