package lab1

import java.io.File
import kotlin.random.Random

object TextGenerator {
    private const val ALPHABET = "abcdefghijklmnopqrstuvwxyz1234567890"

    fun generateText(size: Int): String {
        val words = mutableListOf<String>()
        var currentSize = 0

        while (currentSize < size) {
            val wordLength = Random.nextInt(1, 15)
            val word = (1..wordLength)
                .map { ALPHABET.random() }
                .joinToString("")
            words.add(word)
            currentSize += word.length + 1
        }

        return words.joinToString(" ")
    }

    fun generateTestFiles() {
        val sizes = listOf(1000, 5000, 15000, 30000, 50000, 70000, 85000, 100000, 115000, 130000)
        sizes.forEachIndexed { index, size ->
            val text = generateText(size)
            File("lab1/src/main/resources/test-${index + 1}/original.txt").apply {
                parentFile.mkdirs()
                writeText(text)
            }
        }
    }
}
