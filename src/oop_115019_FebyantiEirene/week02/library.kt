package oop_115019_FebyantiEirene.week02

import java.util.Scanner

class Loan (val bookTitle: String, val borrower: String, var loanDuration: Int = 1) {
    fun calculateFine(): Int {
        return if (loanDuration > 3) {
            (loanDuration - 3) * 2000
        } else {
            0
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    println("--- APLIKASI Library ---")

    print("Masukkan Judul: ")
    val judul = scanner.nextLine()

    print("Masukkan Nama: ")
    val peminjam = scanner.nextLine()

    print("Masukkan Lama Pinjam: ")
    var lamaPinjam = scanner.nextInt()

    scanner.nextLine()

    if (lamaPinjam < 0){
        lamaPinjam = 1
    }

    val loan1 = Loan(judul, peminjam, lamaPinjam)

    println("RECEIPT DETAIL PEMINJAMAN")
    println("Judul Buku: ${loan1.bookTitle}")
    println("Nama Peminjam: ${loan1.borrower}")
    println("Lama Peminjaman: ${loan1.loanDuration}")
    println("Total Denda: ${loan1.calculateFine()}")
}