package oop_001_johnthor.week12

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    // Validasi porsi harus lebih dari 0
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    // Logika pengecekan stok dan mekanik akan ditambahkan di langkah berikutnya
    return availableGram - requestedGram
}