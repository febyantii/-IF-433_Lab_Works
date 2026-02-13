package oop_115019_FebyantiEirene.week02

class Hero (val name: String, var baseDamage: Int, var hp: Int = 100){
    fun attack (targetName: String) {
        println("$name menebas $targetName! ")
    }
    fun takeDamage(damage: Int) {
        if (hp <= 0){
            hp = 0
        } else {
            hp -= damage
        }
    }
    fun isAlive() : Boolean{
        return hp > 0
    }
}