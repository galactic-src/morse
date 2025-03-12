package jm

const val MORSE_NUMERIC_LENGTH = 5

class MorseInfer2 {
    val trie = MorseWordsTrie()

    constructor(words: Set<String>) {
        trie.addAll(words.map{it to morse(it)})
    }

    fun infer(input: String): List<List<String>> {
        trie.interpret(listOf(), input)
        return trie.results
    }
}

class MorseWordsTrie {
    data class MorseWordsTrieNode(
        var dash: MorseWordsTrieNode? = null,
        var dot: MorseWordsTrieNode? = null,
        var wordEnds: MutableSet<String> = mutableSetOf(),
    )

    val results: MutableList<List<String>> = mutableListOf()

    val root = MorseWordsTrieNode()

    fun addAll(morses: Collection<Pair<String,String>>) = morses.forEach(::add)

    fun add(morse: Pair<String,String>) {
        var node = root
        for (c in morse.second) {
            if (c == '.') {
                val nodeDot = node.dot
                if (nodeDot != null) {
                    node = nodeDot
                } else {
                    val newNode = MorseWordsTrieNode()
                    node.dot = newNode
                    node = newNode
                }
            } else if (c == '-') {
                val nodeDash = node.dash
                if (nodeDash != null) {
                    node = nodeDash
                } else {
                    val newNode = MorseWordsTrieNode()
                    node.dash = newNode
                    node = newNode
                }
            } else {
                throw Exception("'$c' isn't dot or dash")
            }
        }

        node.wordEnds.add(morse.first)
    }

    fun interpret(accumulatedWords: List<String>, remainingMorse: String): Unit =
        forEachWord(remainingMorse, root) { newRemainingMorse, foundWord ->
            val newAccumulatedWords: List<String> = accumulatedWords + listOf(foundWord)
            if (newRemainingMorse == "") {
                results.add(newAccumulatedWords)
            } else {
                interpret(newAccumulatedWords, newRemainingMorse)
            }
        }

    fun forEachWord (remainingMorse: String, node: MorseWordsTrieNode, handleWord: (remainingMorse: String, foundWord: String) -> Unit) {
        if (remainingMorse == "") {
            throw Exception("no more morse")
        }

        val nextChar = remainingMorse[0]
        val nextNode = if (nextChar == '.') {
            node.dot
        } else {
            node.dash
        }

        if (nextNode != null) {
            val newRemainingMorse = remainingMorse.substring(1)
            nextNode.wordEnds.forEach{ word ->
                handleWord(newRemainingMorse, word)
            }
            // next letter
            if (newRemainingMorse != "") {
                forEachWord(newRemainingMorse, nextNode, handleWord)
            }
        }
    }
}
