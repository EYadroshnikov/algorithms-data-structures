package lab1

object TextAnalyzer {
    fun analyzeText(words: List<String>, originalText: String, time: Long, variantParams: String): String {
        val wordCount = words.size
        val wordLengths = words.groupBy { it.length }.mapValues { it.value.size }

        return buildString {
            appendLine("Исходный текст:")
            appendLine(originalText)
            appendLine()
            appendLine("Параметры выбранного варианта:")
            appendLine(variantParams)
            appendLine()
            appendLine("Количество слов в исходном тексте: $wordCount")
            appendLine("Время выполнения сортировки: $time мс")
            appendLine()
            appendLine("Количество слов каждой длины:")
            wordLengths.forEach { (length, count) ->
                appendLine("Длина $length: $count слов")
            }
        }
    }
}
