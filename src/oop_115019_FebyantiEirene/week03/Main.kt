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

    val weapon1 = Weapon("Double Blade")

    weapon1.damage = -50
    weapon1.damage = 9999
    println("Tier Weapon: ${weapon1.tier}")

    val player1 = Player("Jinwoo")

    // ERROR: player1.xp = 100

    player1.addXp(50)

    player1.addXp(60)

}