package oop_115019_FebyantiEirene.week05

abstract class PaymentMethod(val accountName: String) {
    open fun processPayment(amount: Double) {}
}