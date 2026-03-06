package oop_115019_FebyantiEirene.week05

class CreditCard(accountName: String, val limit: Double, var usedAmount:Double = 0.0) : PaymentMethod(accountName) {
    override fun processPayment(amount: Double) {
        if (usedAmount + amount <= limit) {
            usedAmount += amount
            println("Pembayaran Sukses! Saldo terpakai sekarang: $usedAmount")
        } else {
            println("Transaksi ditolak: Saldo tidak mencukupi (Melebihi Limit)")
        }
    }
}