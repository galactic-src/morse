package jm

import kotlin.math.min


/**
 * One attempt at optimisation - allows us to discard any lists of letters that don't end with a valid word
 * Not actually sufficient for the longest code though
 */
const val CHECKER_DEPTH = 8

class TranslationEndChecker() {
    class TranslationEndCheckerNode {
        private val letters:Array<TranslationEndCheckerNode?> = arrayOfNulls(26)
        var isWordStart: Boolean = false

        private fun createIfNotExist(c: Char): TranslationEndCheckerNode {
            val existing = letters[c-'a']
            if (existing != null) {
                return existing
            } else {
                val new = TranslationEndCheckerNode()
                letters[c-'a'] = new
                return new
            }
        }

        fun step(c: Char): TranslationEndCheckerNode {
            return createIfNotExist(c)
        }

        fun stepIfPresent(c: Char): TranslationEndCheckerNode? = if (c in 'a'..'z') { letters[c-'a'] } else { null }
    }

    private val root = TranslationEndCheckerNode()

    fun addAll(words: Collection<String>) {
        for (word in words) {
            add(word)
        }
    }

    fun add(word: String) {
        val maxRange = min(CHECKER_DEPTH, word.length)
        var node = root
        for (i in 0..<maxRange) {
            val c = word[word.lastIndex-i]
            node = node.step(c)
        }

        if (maxRange == word.length) {
            node.isWordStart = true
        }
    }

    fun endsWithWordEnd(text: String): Boolean {
        var node: TranslationEndCheckerNode? = root

        if (text == "") {
            return false
        }

        if (text.last() !in 'a'..'z') {
            return true
        }

        for (i in 0..<min(CHECKER_DEPTH, text.length)) {
            if (node?.isWordStart == true) {
                return true
            }

            node = node?.stepIfPresent(text[text.lastIndex-i])
        }

        return node != null
    }
}