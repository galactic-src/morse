import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.shouldBe
import jm.MORSE_DECODE
import jm.MorseInfer
import org.junit.jupiter.api.Test

val MORSE_ENCODE = MORSE_DECODE.entries.associate { (morse, c) -> c[0] to morse }

class MorseTest {
    @Test
    fun `all morse codes consists of dots and dashes only`() {
        MORSE_DECODE.keys.forEach { k ->
            k.any{ it != '.' && it != '-' } shouldBe false
        }
    }

    @Test
    fun `all letters of the alphabet are included in the code`() {
        ('a'..'z').forEach {
            MORSE_DECODE.values shouldContain it.toString()
        }
    }

    @Test
    fun `finds very short word`() {
        val notBadMorse = "at".map { MORSE_ENCODE[it] }.joinToString("")
        val result = MorseInfer(setOf("at")).infer(notBadMorse)
        result shouldBe listOf("at")
    }

    @Test
    fun `finds words`() {
        val notBadMorse = "notbad".map { MORSE_ENCODE[it] }.joinToString("")
        val result = MorseInfer(setOf("not", "bad")).infer(notBadMorse)
        result shouldBe listOf("not bad")
    }

    @Test
    fun `finds numbers`() {
        val numberMorse = "12".map { MORSE_ENCODE[it] }.joinToString ("")
        val result = MorseInfer(setOf()).infer(numberMorse)
        result shouldBe listOf("1 2")
    }

    @Test
    fun `finds words and numbers`() {
        val mixMorse = "it3does".map { MORSE_ENCODE[it] }.joinToString ("")
        val result = MorseInfer(setOf("it", "does")).infer(mixMorse)
        result shouldBe listOf("it 3 does")
    }

    @Test
    fun `gives up if it doesn't find anything`() {
        val result = MorseInfer(setOf()).infer(".")
        result shouldBe listOf()
    }

    @Test
    fun `gives up if remainder doesn't match anything`() {
        val m = "abc".map { MORSE_ENCODE[it] }.joinToString ("")
        val result = MorseInfer(setOf("ab")).infer(m)
        result shouldBe listOf()
    }
}