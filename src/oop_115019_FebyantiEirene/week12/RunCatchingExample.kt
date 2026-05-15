package oop_001_johnthor.week12

fun main() {
    println("=== TEST RUNCATCHING ===")
    val result: Result<Int> = runCatching {
        "42X".toInt()
    }

    // Hasil result bisa diproses lebih lanjut dengan onSuccess atau onFailure
}