package oop_115019_FebyantiEirene.week05

fun main() {
    val dosen1 = Dosen("Pak Alex", "0123456")
    val admin1 = Admin("Bu Siti")

    val daftarPegawai: List<Pegawai> = listOf(dosen1, admin1)

    println("=== AKTIVITAS PEGAWAI ===")
    for (pegawai in daftarPegawai) {
        pegawai.bekerja()

        when (pegawai) {
            is Dosen -> {
                println("=> Terdeteksi sebagai Dosen (NIDN: ${pegawai.nidn})")
                pegawai.mengajar()
            }
            is Admin -> {
                println("=> Terdeteksi sebagai Admin")
                pegawai.doAdminWork()
            }
        }
    }
    println("-----------------------")

    val hitungPersegi = MathHelper()
    println("Luas Persegi adalah: ${hitungPersegi.hitungLuas(3)}")

    val hitungPersegiPanjang = MathHelper()
    println("Luas Persegi Panjang adalah: ${hitungPersegiPanjang.hitungLuas(3, 4)}")

    val hitungLingkaran = MathHelper()
    println("Luas Lingkaran adalah: ${hitungLingkaran.hitungLuas(5.5)}")

    println("-----------------------")

    val OVO = EWallet("Savings", 50000.0)
    val CC = CreditCard("Savings", 100000.0)

    val daftarKartu: List<PaymentMethod> = listOf(OVO, CC)

    for (PaymentMethod in daftarKartu) {
        PaymentMethod.processPayment(75000.0)
    }
}