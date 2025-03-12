package jm

const val VETERANS_STORIES_SIGN = "-..--.-...--.-...--.-.-..--.-"
// 89083720 translations, 804 readings
// net cut LAN tenant
// tea treated war ant
// net treated war wet

val VETERANS_STORIES_SIGN_REVERSED = VETERANS_STORIES_SIGN.reversed()
// 92109406 translations, 848 readings
// year 7 knit pet
// year 7 knee tax
// tan arg in geek tea
// shortest: twin knit permit

const val INDIVIDUALS_SIGN = "-.-...--.-.-..--.-...--.-...-"
// 92254896 translations, 704 readings
// keep text tree menu
// cute cat as gnu
// cute trace wav
// trunk UK East

val INDIVIDUALS_SIGN_REVERSED = INDIVIDUALS_SIGN.reversed()
// 85584941 translations, 325 readings
// bye item ur geek
// tie knitwear geek

const val HUT_11_SIGN = "-....-...--.-......-...-.--.--..-.-.-.-"
// "bletchley park"

val HUT_11_SIGN_REVERSED = HUT_11_SIGN.reversed()
// 1301615 readings,
// CNN wants bin guest

fun main() {
    val readings = MorseInfer2(WORDS.wordList).infer(HUT_11_SIGN)

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