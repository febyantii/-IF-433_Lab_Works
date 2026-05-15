package oop_001_johnthor.week12

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    if (isJammed) {
        throw DispenserJamException()
    }

    // Validasi Stok Makanan
    if (requestedGram > availableGram) {
        throw FoodEmptyException(requestedGram, availableGram)
    }

    println("Kibble berhasil dikeluarkan!")
    return availableGram - requestedGram
}

fun main() {
    var currentKibbleStock = 50.0 // Menggunakan Double agar konsisten dengan tipe data berat
    // Atau sesuai instruksi gambar (Int):
    // var currentKibbleStock = 50

    println("--- JADWAL MAKAN PAGI ---")
    try {
        currentKibbleStock = dispenseKibble(80, currentKibbleStock.toInt(), false)
    } catch (e: DispenserJamException) {
        println("Peringatan: ${e.message}")
    } catch (e: FoodEmptyException) {
        println("Peringatan: ${e.message}")
    } catch (e: Exception) {
        println("Error Umum: ${e.message}")
    }

    try {
        currentKibbleStock = dispenseKibble(80, currentKibbleStock.toInt(), false)
    } catch (e: DispenserJamException) {
        println("Peringatan: ${e.message}")
    } catch (e: FoodEmptyException) {
        println("Peringatan: ${e.message}")
    } catch (e: Exception) {
        println("Error Umum: ${e.message}")
    } finally {
        println("Siklus pengecekan dispenser pagi selesai.")
    }

    println("\n--- JADWAL MAKAN SORE ---")
    val result = runCatching {
        dispenseKibble(requestedGram = 30, availableGram = 1000, isJammed = false)
    }

    result.onSuccess { newStock ->
        currentKibbleStock = newStock.toDouble()
        println("Makan sore sukses! Sisa stok kibble: $currentKibbleStock gr")
    }
}

