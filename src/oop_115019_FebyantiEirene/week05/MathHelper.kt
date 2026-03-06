package oop_115019_FebyantiEirene.week05

class MathHelper(val sisi:Int, val panjang: Int, val lebar: Int, val jariJari: Double) {
    fun hitungLuas(sisi:Int):Int {
        return sisi * sisi
    }

    fun hitungLuas(panjang: Int, lebar: Int): Int {
        return panjang * lebar
    }

    fun hitungLuas(jariJari: Double): Double {
        return 3.14 * jariJari * jariJari
    }
}