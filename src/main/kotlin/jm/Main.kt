package jm

import jm.Words.WORDS

fun main() {
    val veteransStoriesSign = "-..--.-...--.-...--.-.-..--.-"
    // 89083720 translations, 804 readings
    // net cut LAN tenant
    // tea treated war ant

    val veteransStoriesSignReversed = veteransStoriesSign.reversed()
    // 92109406 translations, 848 readings
    // year 7 knit pet
    // year 7 knee tax

    val individualsSign = "-.-...--.-.-..--.-...--.-...-"
    // 92254896 translations, 704 readings
    // keep text tree menu
    // cute cat as gnu

    val individualsSignReversed = individualsSign.reversed()
    // 85584941 translations, 325 readings
    // bye item ur geek

    // This one ate the heap even with 32GB to play with
    // val hut11Sign = "-....-...--.-.....-...-.--.--..-.-.-.-"
    // val hut11SignReversed = hut11Sign.reversed()

    val readings = MorseInfer(WORDS.wordList).infer(veteransStoriesSignReversed)

    println(readings.map{ it.joinToString( " ")}.joinToString("\n"))

    println("\n\nTotal ${readings.size} readings")
}
