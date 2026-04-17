package oop_115019_FebyantiEirene.week08

fun main() {
    println("=== TEST SAFE CALLS & ELVIS ===")
    val emptyOrder = Order(null, null)

    val destination = emptyOrder.deliveryDetails?.address?.city?.name ?: "Kota Tidak Diketahui"
    println("Tujuan mengirim: $destination")

    println("\n=== TEST LET BLOCK ====")
    val validOrder = Order(null, 250000)

    val receipt = validOrder.totalPrice?.let { price ->
        val tax = price * 0.11
        "Transaksi Valid. Harga: Rp.$price, Pajak: $tax"
    } ?: "Transaksi Invalid: Harga belum di-set!"

    println(receipt)
}