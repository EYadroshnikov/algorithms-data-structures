package lab1

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    TextGenerator.generateTestFiles()

    val variantParams = """
        Вариант:
        Латиница
        Сортировка слиянием по количеству символов в слове
        Учитывать числа
    """.trimIndent()

    val testFolders = File("lab1/src/main/resources").listFiles { file -> file.isDirectory }?.sortedWith(compareBy {
        val match = Regex("\\d+").find(it.name)
        match?.value?.toIntOrNull() ?: 0
    }) ?: return

    testFolders.forEach { testFolder ->
        val inputFileName = "${testFolder.path}/original.txt"
        val resultFileName = "${testFolder.path}/result.txt"
        val analysisFileName = "${testFolder.path}/analysis.txt"

        val originalText = File(inputFileName).readText()
        val words = originalText.split(Regex("\\W+")).filter { it.isNotBlank() }

        val sortedWords: List<String>
        val time = measureTimeMillis {
            sortedWords = MergeSort.sort(words)
        }

        File(resultFileName).writeText(sortedWords.joinToString(" "))

        val analysis = TextAnalyzer.analyzeText(sortedWords, originalText, time, variantParams)
        File(analysisFileName).writeText(analysis)

        println("${testFolder.name} completed in ${time}ms")
    }
}
