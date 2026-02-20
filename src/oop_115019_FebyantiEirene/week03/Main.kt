package oop_115019_FebyantiEirene.week03

fun main() {
    val e = Employee("Budi")

    //1. Test validasi salary
    e.salary = -100 //harusnya print error
    e.salary = 5000000
    println("Gaji: ${e.salary}")

    //2. Test Encapsulation
    e.increasePerformance()

    //3. Test Computed Property
    println("Pajak yang harus dibayar: ${e.tax}")
}