package testing

// =========================================================
// 1. MANAJEMEN DATA TRANSAKSI (Special Classes)
// =========================================================

enum class TransactionType {
    PAYMENT,
    TOPUP,
    WITHDRAW
}

data class WalletUser(
    val username: String,
    var balance: Double,
    val accountType: String
)

sealed class TransactionStatus {
    data class Success(val amount: Double, val receiptId: String) : TransactionStatus()
    data class Error(val errorCode: Int, val message: String) : TransactionStatus()
}

// =========================================================
// 2. STANDARISASI FITUR PEMBAYARAN (Interfaces)
// =========================================================

interface Payable {
    fun processPayment(user: WalletUser, amount: Double): TransactionStatus
}

// =========================================================
// 3. KEAMANAN & TEMPLATE SISTEM KEUANGAN (Abstraction & Encapsulation)
// =========================================================

abstract class BaseFinanceSystem(val merchantName: String) {

    // Encapsulation: Private agar tidak bisa dimanipulasi dari luar class
    private var totalProcessedTransactions: Int = 0

    // Encapsulation: Protected agar anak class bisa menambah hitungan
    protected fun incrementTransactionCount() {
        totalProcessedTransactions++
        println("[$merchantName] System: Transaction count increased to $totalProcessedTransactions")
    }

    abstract fun initSystem()
}

// =========================================================
// 4. KERANGKA DASAR MESIN TRANSAKSI (Inheritance, Init, & Final)
// =========================================================

open class PaymentGateway(merchantName: String, val apiSecretKey: String) : BaseFinanceSystem(merchantName) {

    init {
        println("🔐 Connecting to Secure Server for $merchantName...")
    }

    override fun initSystem() {
        incrementTransactionCount()
        println("✅ Payment Gateway $merchantName is ready.")
    }

    // Final: Prosedur verifikasi tidak boleh di-override demi keamanan
    final fun verifyIdentity() {
        println("🛡️ Security Check: Verifying API Secret Key integrity...")
        println("Identity Verified for $merchantName.")
    }
}

// =========================================================
// 5. MODEL LAYANAN SPESIFIK (Polymorphism)
// =========================================================

class QRScannerPayment(
    merchantName: String,
    apiSecretKey: String,
    val isMerchantVerified: Boolean
) : PaymentGateway(merchantName, apiSecretKey), Payable {

    override fun processPayment(user: WalletUser, amount: Double): TransactionStatus {
        incrementTransactionCount()

        println("📱 Scanning QR Code for ${user.username}...")

        // Logic: Merchant harus terverifikasi DAN saldo harus cukup
        return if (isMerchantVerified && user.balance >= amount) {
            TransactionStatus.Success(amount, "TXN-${System.currentTimeMillis()}")
        } else {
            TransactionStatus.Error(403, "Transaksi Ditolak: Merchant Tidak Valid atau Saldo Kurang")
        }
    }
}

// =========================================================
// 6. SIMULASI EKSEKUSI (Syntax Basics)
// =========================================================

fun main() {
    println("=== GADINGPAY DIGITAL WALLET SYSTEM ===")

    // 1. Membuat objek WalletUser
    val myUser = WalletUser("FebyEirene", 500000.0, "Premium")
    println("Saldo Awal: Rp${myUser.balance}")

    // 2. Membuat objek QRScannerPayment
    val qrPayment = QRScannerPayment("Summarecon Mall", "SECRET_123", true)

    // 3. Inisialisasi sistem
    qrPayment.initSystem()

    // 4. Proses Pembayaran
    val paymentAmount = 150000.0
    val result = qrPayment.processPayment(myUser, paymentAmount)

    // 5. Pattern Matching (When) untuk menangani Sealed Class
    when (result) {
        is TransactionStatus.Success -> {
            println("✅ PEMBAYARAN BERHASIL!")
            println("Receipt ID: ${result.receiptId}")
            println("Jumlah: Rp${result.amount}")

            // Side Effect: Kurangi saldo user
            myUser.balance -= result.amount
            println("Saldo Sekarang: Rp${myUser.balance}")
        }
        is TransactionStatus.Error -> {
            println("❌ PEMBAYARAN GAGAL!")
            println("Error Code: ${result.errorCode}")
            println("Pesan: ${result.message}")
        }
    }

    // 6. Prosedur Keamanan Akhir
    println("")
    qrPayment.verifyIdentity()

    println("========================================")
}