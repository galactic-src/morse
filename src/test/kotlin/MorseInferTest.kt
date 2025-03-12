import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotlintest.shouldBe
import jm.MORSE_DECODE
import jm.MORSE_ENCODE
import jm.morse
import jm.MorseInfer
import org.junit.jupiter.api.Test

class MorseInferTest {
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
        result shouldBe listOf(listOf("at"))
    }

    @Test
    fun `finds words`() {
        val notBadMorse = "notbad".map { MORSE_ENCODE[it] }.joinToString("")
        val result = MorseInfer(setOf("not", "bad"), true).infer(notBadMorse)
        result shouldBe listOf(listOf("not", "bad"))
    }

    @Test
    fun `finds numbers`() {
        val numberMorse = "12".map { MORSE_ENCODE[it] }.joinToString ("")
        val result = MorseInfer(setOf()).infer(numberMorse)
        result shouldBe listOf(listOf("1", "2"))
    }

    @Test
    fun `finds words and numbers`() {
        val mixMorse = "it3does".map { MORSE_ENCODE[it] }.joinToString ("")
        val result = MorseInfer(setOf("it", "does")).infer(mixMorse)
        result shouldBe listOf(listOf("it", "3", "does"))
    }

    @Test
    fun `gives up if it doesn't find anything`() {
        val result = MorseInfer(setOf()).infer(".")
        result shouldBe listOf()
    }

    @Test
    fun `gives up if remainder doesn't match anything`() {
        val m = morse("abc")
        val words = setOf("ab")
        val result = MorseInfer(words).infer(m)
        result shouldBe listOf()
    }

    @Test
    fun `generates numeric substitutions`() {
        val m = morse("can3")
        val words = setOf("can", "cane")
        val result = MorseInfer(words).infer(m)
        result shouldContainExactlyInAnyOrder listOf(listOf("can", "3"), listOf("cane"))
    }
}