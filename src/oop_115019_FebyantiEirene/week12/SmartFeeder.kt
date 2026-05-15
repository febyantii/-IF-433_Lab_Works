package oop_001_johnthor.week12

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    // 1. Validasi awal menggunakan require
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    // 2. Cek Hardware (Dispenser)
    if (isJammed) {
        throw DispenserJamException()
    }

    // 3. Validasi Stok Makanan
    if (requestedGram > availableGram) {
        throw FoodEmptyException(requestedGram, availableGram)
    }

    println("Kibble berhasil dikeluarkan!")
    return availableGram - requestedGram
}

fun main() {
    // Inisialisasi stok awal
    var currentKibbleStock = 50

    // --- JADWAL MAKAN 1: Eksekusi dengan Multiple Catch ---
    println("--- JADWAL MAKAN PAGI ---")
    try {
        // Simulasi: Minta 80gr padahal stok cuma 50gr -> Memicu FoodEmptyException
        currentKibbleStock = dispenseKibble(requestedGram = 80, availableGram = currentKibbleStock, isJammed = false)
    } catch (e: DispenserJamException) {
        println("Peringatan ke Pemilik: ${e.message}")
    } catch (e: FoodEmptyException) {
        println("Peringatan ke Pemilik: ${e.message}")
    } catch (e: Exception) {
        println("Error Umum: ${e.message}")
    } finally {
        // Tetap dijalankan baik sukses maupun error
        println("Siklus pengecekan dispenser pagi selesai.")
    }

    // --- JADWAL MAKAN 2: Eksekusi dengan runCatching ---
    println("\n--- JADWAL MAKAN SORE ---")
    // Pemilik baru saja mengisi ulang alat sehingga availableGram menjadi 1000
    val result = runCatching {
        dispenseKibble(requestedGram = 30, availableGram = 1000, isJammed = false)
    }

    result.onSuccess { newStock ->
        currentKibbleStock = newStock
        println("Makan sore sukses! Sisa stok kibble: $currentKibbleStock gr")
    }.onFailure { error ->
        println("Peringatan ke Pemilik: ${error.message}")
        println("(Opsional: Berikan chicken jerky secara manual)")
    }
}