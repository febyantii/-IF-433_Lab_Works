package oop_115019_FebyantiEirene.week01

fun main() {
    val gameTitle: String = "Cooking Mama"
    val price: Int = 75000
}

fun calculateDiscount(price: Int): Double = if (price > 500000) price*0.8 else price*0.9