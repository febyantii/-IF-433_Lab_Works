package oop_115019_FebyantiEirene.week05

class EWallet(accountName: String, var balance: Double) : PaymentMethod(accountName) {
    override fun processPayment(amount: Double) {
        if (amount <= balance) {
            balance -= amount
            println("Sukses")
        }   else {
            println("Saldo tidak cukup")
        }
    }

    fun topUp(amount: Double) {
        balance += amount
    }
}