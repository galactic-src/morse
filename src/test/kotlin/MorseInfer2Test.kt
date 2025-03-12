import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotlintest.shouldBe
import jm.*
import org.junit.jupiter.api.Test

class MorseInfer2Test {

    @Test
    fun `finds very short word`() {
        val notBadMorse = "at".map { MORSE_ENCODE[it] }.joinToString("")
        val result = MorseInfer2(setOf("at")).infer(notBadMorse)
        result shouldBe listOf(listOf("at"))
    }

    @Test
    fun `finds words`() {
        val notBadMorse = "notbad".map { MORSE_ENCODE[it] }.joinToString("")
        val result = MorseInfer2(setOf("not", "bad")).infer(notBadMorse)
        result shouldBe listOf(listOf("not", "bad"))
    }

    @Test
    fun `finds numbers`() {
        val numberMorse = "12".map { MORSE_ENCODE[it] }.joinToString("")
        val result = MorseInfer2(setOf("1", "2")).infer(numberMorse)
        result shouldBe listOf(listOf("1", "2"))
    }

    @Test
    fun `finds words and numbers`() {
        val mixMorse = "it3does".map { MORSE_ENCODE[it] }.joinToString("")
        val result = MorseInfer2(setOf("it", "does", "3")).infer(mixMorse)
        result shouldBe listOf(listOf("it", "3", "does"))
    }

    @Test
    fun `gives up if it doesn't find anything`() {
        val result = MorseInfer2(setOf()).infer(".")
        result shouldBe listOf()
    }

    @Test
    fun `gives up if remainder doesn't match anything`() {
        val m = morse("abc")
        val words = setOf("ab")
        val result = MorseInfer2(words).infer(m)
        result shouldBe listOf()
    }
}
