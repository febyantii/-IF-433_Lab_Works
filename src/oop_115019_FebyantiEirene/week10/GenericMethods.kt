package oop_001_johnthor.week10

// Fungsi cetak generik
fun <T> printData(data: T) {
    println("Data yang diterima : $data")
}

// Fungsi dengan tipe kembalian generik
fun <T> processData(input: T): T {
    return input
}