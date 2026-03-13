package oop_115019_FebyantiEirene.week06

interface Clickable {
    val name: String
    fun click()
}

class Button(override val name: String) : Clickable {
    override fun click() {
        println("Tombol '$name' berhasil di-klik!")
    }
}