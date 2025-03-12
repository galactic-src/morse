package jm

val MORSE_DECODE = mapOf(
    ".-" to "a",
    "-..." to "b",
    "-.-." to "c",
    "-.." to "d",
    "." to "e",
    "..-." to "f",
    "--." to "g",
    "...." to "h",
    ".." to "i",
    ".---" to "j",
    "-.-" to "k",
    ".-.." to "l",
    "--" to "m",
    "-." to "n",
    "---" to "o",
    ".--." to "p",
    "--.-" to "q",
    ".-." to "r",
    "..." to "s",
    "-" to "t",
    "..-" to "u",
    "...-" to "v",
    ".--" to "w",
    "-..-" to "x",
    "-.--" to "y",
    "--.." to "z",
    ".----" to "1",
    "..---" to "2",
    "...--" to "3",
    "....-" to "4",
    "....." to "5",
    "-...." to "6",
    "--..." to "7",
    "---.." to "8",
    "----." to "9",
    "-----" to "0",
)

val MORSE_ENCODE = MORSE_DECODE.entries.associate { (morse, c) -> c[0] to morse }

fun morse(text: String): String = text.map { MORSE_ENCODE[it] }.joinToString("")

val COMMON_NUMERIC_SUBS = mapOf(
    '0' to 'o',
    '1' to 'i',
    '3' to 'e',
    '4' to 'a',
    '5' to 's',
    '6' to 'g',
    '7' to 't',
    '8' to 'b',
)

val COMMON_NUMERIC_SUBS_MORSE = COMMON_NUMERIC_SUBS.map { (i, c) -> MORSE_ENCODE[i]!! to MORSE_ENCODE[c] }.toMap()