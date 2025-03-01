package jm

class MorseInfer(private val words: Set<String>, private val debug: Boolean = false) {
    fun debugLog(message: Any) {
        if (debug) {
            println(message)
        }
    }

    fun infer(input: String): List<String> {
        debugLog("inferring for $input")
        val translations = morseTranslate(input)
        debugLog(translations)
        println("inferred ${translations.size} translations")
        val readings = translations.flatMap(::textSplit)
        return readings.map{ it.joinToString( " ")}
    }

    fun textSplit(text: String): List<List<String>> {
        debugLog("split '$text'")
        if (text == "") {
            return listOf(listOf())
        }

        if (text[0] in '0'..'9') {
            debugLog("numeric: ${text[0]}")
            return textSplit(text.substring(1)).map {
                listOf(text.substring(0,1)) + it
            }
        } else {
            val results = mutableListOf<List<String>>()

            (1..(text.length)).mapNotNull {
                val subs = text.substring(0, it)
                debugLog("subs $subs")
                if (isWord(subs)) {
                    val remainder = text.substring(it)
                    debugLog("word '$subs' remainder '$remainder'")
                    results.addAll(textSplit(remainder).map { result ->
                        listOf(subs) + result
                    })
                }
            }

            return results//.also(::println)
        }
    }

    fun isWord(s: String): Boolean = s.length > 1 && words.contains(s)

    fun findLeadingWords(s: String): List<String> =
        (1..s.length).mapNotNull {
            val subs = s.substring(0, it)
            if (isWord(subs)) { subs } else { null }
        }

    fun morseTranslate(input: String): List<String> {
        if (input == "") {
            return listOf("")
        }

        val results = mutableListOf<String>()
        (1..5).mapNotNull { i ->
            if (input.length >= i) {
                val prefix = input.substring(0,i)
                val remainder = input.substring(i)
                MORSE_DECODE[prefix]?.let { p ->
                    morseTranslate(remainder)
                        .map{s -> p + s}
                        .also {
                            results.addAll(it)
                        }
                }
            } else { null }
        }
        return results
    }
}