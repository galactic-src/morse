package jm

import jm.Words.WORDS

fun main() {
    val veteransStoriesSign = "-..--.-...--.-...--.-.-..--.-"
    // 89083720 translations, 804 readings
    // net cut LAN tenant
    // tea treated war ant
    // net treated war wet

    val veteransStoriesSignReversed = veteransStoriesSign.reversed()
    // 92109406 translations, 848 readings
    // year 7 knit pet
    // year 7 knee tax
    // tan arg in geek tea
    // shortest: twin knit permit

    val individualsSign = "-.-...--.-.-..--.-...--.-...-"
    // 92254896 translations, 704 readings
    // keep text tree menu
    // cute cat as gnu
    // cute trace wav
    // trunk UK East

    val individualsSignReversed = individualsSign.reversed()
    // 85584941 translations, 325 readings
    // bye item ur geek

    // This one ate the heap even with 32GB to play with
    // val hut11Sign = "-....-...--.-.....-...-.--.--..-.-.-.-"
    // val hut11SignReversed = hut11Sign.reversed()

    val readings = MorseInfer(WORDS.wordList).infer(individualsSignReversed)

    println(readings.map{ it.joinToString( " ")}.joinToString("\n"))

    println("\n\nTotal ${readings.size} readings")

    val shortestResults = findShortestResults(readings)

    println("\n\n${shortestResults.size} shortest readings: $shortestResults")
}

fun findShortestResults(readings: List<List<String>>): List<List<String>> {
    val groupedBySize = readings.groupBy { it.size }
    val shortestSize = groupedBySize.keys.min()
    return groupedBySize[shortestSize]!!
}