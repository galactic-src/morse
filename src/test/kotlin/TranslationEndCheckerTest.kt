import io.kotlintest.shouldBe
import jm.TranslationEndChecker
import org.junit.jupiter.api.Test

class TranslationEndCheckerTest {

    @Test
    fun `checker checks last treeDepth letters`() {
        val checker = TranslationEndChecker().also { it.add("tada") }
        checker.endsWithWordEnd("tada") shouldBe true
        checker.endsWithWordEnd("asdftada") shouldBe true
        checker.endsWithWordEnd("sada") shouldBe false
    }

    @Test
    fun `checker matches complete word`() {
        val checker = TranslationEndChecker().also { it.add("deed") }
        checker.endsWithWordEnd("yesindeed") shouldBe true
    }

    @Test
    fun `matches a full word shorter than treeDepth, even if a longer word exists`() {
        val checker = TranslationEndChecker().also { it.addAll(setOf("yesterday", "day")) }
        checker.endsWithWordEnd("day") shouldBe true
    }

    @Test
    fun `copes with z`() {
        val checker = TranslationEndChecker().also { it.add("zzz") }
        checker.endsWithWordEnd("zzz") shouldBe true
    }

    @Test
    fun `true if last character is numeric`() {
        val checker = TranslationEndChecker()
        checker.endsWithWordEnd("ab1") shouldBe true
    }
}