package oop_115019_FebyantiEirene.week05

abstract class PaymentMethod(val accountName: String) {
    fun processPayment(amount: Double) {}
}