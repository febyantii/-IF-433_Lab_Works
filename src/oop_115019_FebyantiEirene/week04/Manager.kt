package oop_115019_FebyantiEirene.week04

open class Manager (name: String, baseSalary: Int) : Employee(name, baseSalary) {
    override fun work() {
        println("$name sedang memimpin rapat divisi.")
    }

    override fun calculateBonus(): Double {
        return super.calculateBonus() + 500000
    }
}