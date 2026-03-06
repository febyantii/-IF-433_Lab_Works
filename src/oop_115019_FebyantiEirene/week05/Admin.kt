package oop_115019_FebyantiEirene.week05

class Admin(nama: String) : Pegawai(nama) {
    override fun bekerja() {
        println("[$nama] sedang duduk di depan komputer melayani administrasi.")
    }

    fun doADminWork() {
        println("[$nama] sedang merekap data absensi mahasiswa.")
    }
}