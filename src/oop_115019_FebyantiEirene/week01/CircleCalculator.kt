package oop_115019_FebyantiEirene.week01

fun main(args: Array<String>) {
    val radius = 7.0
    val pi = 3.14

    var area = pi * radius * radius

    println("Radius: $radius, Area: $area")
}

fun checkSize(area: Double) {
    if (area > 100) {
        println("This is a big circle")
    } else {
        println("This is a small circle")
    }
}