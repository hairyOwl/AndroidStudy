package com.example.firstapp.lesson

import java.lang.Exception

/**
 *@author: hairly owl
 *@time:2021/10/13 21:22
 *@version: 1.00
 *@description: 一次四则运算计算机器
 */

fun main() {
    while(true){
        println("==========请输入你的表达式==========")
        //接受控制台输入数据
        val input:String? = readLine() //判空的校验
        try {
            input?.let {
                val res = calculate(it)
                println("${input} = ${res}")
                println("是否继续使用(y/n)")
                val cmd = readLine()
                cmd?.let{
                    if(it.equals("n")){
                        System.exit(-1) //强制退出程序
                    }else{
                        //继续使用

                    }
                }
            }
        }catch (ex:Exception){
            ex.printStackTrace() //打印异常
        }
    }
}

//四则运算函数
fun calculate(input: String): String {
    if(input.contains("+")){ //加法
        //数据处理
        val nums = input.trim().split("+") //去掉空格 分割操作符左右
        return operate(nums[0].toDouble(),nums[1].toDouble(),"+").toString()

    }else if (input.contains("-")){ //减法
        val nums = input.trim().split("-")
        return operate(nums[0].toDouble(),nums[1].toDouble(),"-").toString()

    }else if (input.contains("*")){ //减法
        val nums = input.trim().split("*")
        return operate(nums[0].toDouble(),nums[1].toDouble(),"*").toString()

    }else if (input.contains("/")){ //减法
        val nums = input.trim().split("/")
        return operate(nums[0].toDouble(),nums[1].toDouble(),"/").toString()
    }else{
        return "error: 您输入的表达式有误"
    }
}

//计算函数
fun operate(num1: Double, num2: Double, operator: String): Double {
    return when(operator){ //kotlin中的when代替 java中的switch-case
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> num1 / num2
        else -> 0.0
    }
}
