package oop_115019_FebyantiEirene.week04

fun main() {
    println("--- Testing Vehicle ---")
    val generalVehicle = Vehicle("Sepeda Onthel")
    generalVehicle.honk()
    generalVehicle.accelerate()

    println("\n--- Testing Car ---")
    val myCar = Car("Toyota", 4)
    myCar.openTrunk()
    myCar.honk()
    myCar.accelerate()

    val tesla = ElectricCar("Tesla", 4, 50000)
    tesla.accelerate()
    tesla.honk()
    tesla.openTrunk()
}