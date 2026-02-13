package oop_115019_FebyantiEirene.week02

import java.util.Scanner

class Hero (val name: String, var baseDamage: Int, var hp: Int = 100){
    fun attack (targetName: String) {
        println("$name menebas $targetName! ")
    }
    fun takeDamage(damage: Int) {
        hp -= damage

        if (hp <= 0){
            hp = 0
        }
    }
    fun isAlive() : Boolean{
        return hp > 0
    }
}

fun main(){
    val scanner = Scanner(System.`in`)

    print("Masukkan Nama Hero: ")
    val hero = scanner.nextLine()

    print("Masukkan Stat Damage: ")
    var statDamage = scanner.nextInt()

    val hero1 = Hero(hero, statDamage)

    var enemyHp = 100

    while (hero1.isAlive() && enemyHp > 0) {
        println("Menu: ")
        println("1. Serang")
        println("2. Kabur")
        println("Pilih Menu: ")
        var pilihan = scanner.nextInt()

        if (pilihan == 1) {
            enemyHp -= hero1.baseDamage
            if (enemyHp < 0) {
                enemyHp = 0
            }
            println("HP SIsa musuh: ${enemyHp}")

            if (enemyHp > 0) {
                hero1.takeDamage((10..20).random())

                println("Sisa HP Hero: ${hero1.hp}")
            }
        } else if (pilihan == 2) {
            println("Hero Kabur Bye!")
            break;
        }
    }

    println("AKHIRNYAAA ....")
    if (enemyHp <= 0){
        println("HERO MENANG!")
    } else if (!hero1.isAlive()) {
        println("HERO KALAH")
    } else
        println("bye")
}