package oop_001_johnthor.week10

fun main() {
    // Checkpoint 15: Inisialisasi repository
    val coinRepo = WalletRepository<Coin>()

    // Checkpoint 16: Mengisi data dompet (minimal 3 koin)
    coinRepo.add(Coin("BTC.", 0.5))
    coinRepo.add(Coin("ETH", 10.2))
    coinRepo.add(Coin("USDT", 500.0))

    // Membungkus list koin ke dalam ApiResponse
    val response = ApiResponse("200 OK", coinRepo.getAll())

    println("Status Respons: ${response.status}")
    println("--- Daftar Koin di Dompet ---")

    // Menggunakan forEach untuk menampilkan detail setiap koin
    response.data.forEach { coin ->
        println("Koin: ${coin.name} | Saldo: ${coin.balance}")
    }

    // Tambahkan di bawah kode iterasi koin sebelumnya
    println("\n=== LOG TRANSAKSI TERBARU ===")

    // Inisialisasi repository khusus untuk transaksi
    val txRepo = WalletRepository<Transaction>()

    // Menambahkan data transaksi fiktif
    txRepo.add(Transaction("TX-001", 0.05))
    txRepo.add(Transaction("TX-002", 1.2))
    txRepo.add(Transaction("TX-003", 250.0))

    txRepo.getAll().forEach { tx ->
        println("ID Transaksi: ${tx.id} | Jumlah: ${tx.amount}")
    }

    println("\n--- Arsitektur Generik Berhasil Diuji ---")
}