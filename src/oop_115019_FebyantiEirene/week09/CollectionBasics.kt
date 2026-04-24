package oop_115019_FebyantiEirene.week09

fun main() {
    println("=== TEST LIST ===")

    val frameworks: List<String> = listOf("Kotlin", "Java", "C++", "Scala", "JavaScript")
    println("Immutable List: $frameworks")

    val scores: MutableList<Int> = mutableListOf(85, 90)
    scores.add(85)
    scores[0] = 88
    println("Mutable List: $scores")

}