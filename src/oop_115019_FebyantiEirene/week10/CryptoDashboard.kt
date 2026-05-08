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
}