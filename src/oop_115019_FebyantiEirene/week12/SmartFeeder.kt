package oop_001_johnthor.week12

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    // Validasi porsi harus lebih dari 0
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    // Logika pengecekan stok dan mekanik akan ditambahkan di langkah berikutnya
    return availableGram - requestedGram
}

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    // Validasi Dispenser
    if (isJammed) {
        throw DispenserJamException()
    }

    // Lanjut ke logika berikutnya...
    return availableGram
}