package oop_115019_FebyantiEirene.week01

fun main(args: Array<String>) {
    val radius = 7.0
    val pi = 3.14

    var area = pi * radius * radius

    println("Radius: $radius, Area: $area")
    println("Checksize: ${checkSize(area)}")
}

fun checkSize(area: Double) = if (area > 100) "This is a big circle" else "This is a small circle"