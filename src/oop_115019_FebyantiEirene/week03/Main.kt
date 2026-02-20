package oop_115019_FebyantiEirene.week03

fun main() {
    val e = Employee("Budi")
    //println("--- Test Error ---")
    //e.salary = 5000 //Ini akan meledakkan program lol

    //1. Test validasi salary
    e.salary = -100 //harusnya print error
    e.salary = 5000000
    println("Gaji: ${e.salary}")

    //2. Test Encapsulation
    e.increasePerformance()
    // e.performanceRating = 5 //coba uncomment, pasti Merah (Error)

    //3. Test Computed Property
    println("Pajak yang harus dibayar: ${e.tax}")
}