package oop_115019_FebyantiEirene.week01

fun main() {
    val gameTitle: String = "Cooking Mama"
    val price: Int = 750000

    val userNote: String? = null

    val finalPrice = calculateDiscount(price)

    printReceipt(
        title = gameTitle,
        price = price,
        finalPrice = finalPrice,
        userNote = userNote
    )
}

fun calculateDiscount(price: Int): Int =
    if (price > 500000) (price * 0.8).toInt() else (price * 0.9).toInt()

fun printReceipt(title: String, price: Int, finalPrice: Int, userNote: String?) {
    println("Game Title: $title")
    println("Original Price: $price")
    println("Final Price: $finalPrice")

    println("Note: ${userNote ?: "Tidak ada catatan"}")
}