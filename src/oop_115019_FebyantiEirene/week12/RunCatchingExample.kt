package oop_001_johnthor.week12

fun main() {
    println("=== TEST RUNCATCHING ===")
    val result: Result<Int> = runCatching {
        "42X".toInt()
    }

    // Hasil result bisa diproses lebih lanjut dengan onSuccess atau onFailure

    // Pattern: getOrElse
    val safeValue = result.getOrElse { -1 }
    println("Safe Value (getOrElse): $safeValue")

// Pattern: recover (bisa mengubah tipe kegagalan jadi sukses)
    val recovered = result.recover { 0 }.getOrNull()
    println("Recovered Value: $recovered")
}