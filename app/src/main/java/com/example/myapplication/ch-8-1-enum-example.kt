package com.example.myapplication

enum class Fruits{
    BANANA, APPLE
}

enum class Transport {
    BUS, CAR, BIKE
}

fun main() {
    val myWay : Transport = Transport.BUS
//    println("오늘은 ${myWay}를 탔다")

    when(myWay) {
        Transport.BUS -> {println("myWay bus")}
        Transport.CAR -> {println("myWay car")}
        Transport.BIKE -> {println("myWay bike")}
    }
}