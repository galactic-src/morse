package jm

class MorseInfer(private val words: Set<String>, private val debug: Boolean = false) {
    private val checker: TranslationEndChecker = TranslationEndChecker().also { it.addAll(words) }

    fun debugLog(message: Any) {
        if (debug) {
            println(message)
        }
    }

    fun infer(input: String): List<List<String>> {
        debugLog("inferring for $input")
        val translations = morseTranslate(input)
        debugLog(translations)
        println("inferred ${translations.size} translations")

        val readings = translations.flatMap(::textSplit)

        return readings
    }

    fun generateNumericVariants(text: String): List<String> {
        val characterLists = mutableListOf<MutableList<Char>>(mutableListOf())
        for (c in text) {
            val sub = COMMON_NUMERIC_SUBS[c]
            val subbedEntries =
                if (sub != null) {
                    characterLists.map {chars -> chars.toMutableList().also { it.add(sub)} }
                } else {
                    listOf()
                }

            characterLists.forEach {
                it.add(c)
            }

            characterLists.addAll(subbedEntries)
        }
        return characterLists.map { it.joinToString ( "" ) }
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
                if (words.contains(subs)) {
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

        val resultsWithVariants = results.flatMap(::generateNumericVariants)

        return resultsWithVariants.filter{ it.length > CHECKER_DEPTH || checker.endsWithWordEnd(it) }
    }
}