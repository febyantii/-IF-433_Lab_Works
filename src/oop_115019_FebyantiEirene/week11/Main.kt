package oop_115019_FebyantiEirene.week11

package oop_001_johnthor.week11

fun main() {
    println("=== TEST EXTENSION FUNCTIONS ===")

    // Menguji fungsi dari Langkah 1
    println("Alex".addGreeting())
    println("Hi".repeatTimes(3))

    // Menguji fungsi dari Langkah 2 (Nullable)
    val text: String? = null
    println("Apakah null/empty? ${text.isNullOrEmptyCustom()}")
}