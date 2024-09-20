package lab1

object MergeSort {
    fun sort(words: List<String>): List<String> {
        if (words.size <= 1) return words
        val middle = words.size / 2
        val left = sort(words.subList(0, middle))
        val right = sort(words.subList(middle, words.size))
        return merge(left, right)
    }

    private fun merge(left: List<String>, right: List<String>): List<String> {
        var leftIndex = 0
        var rightIndex = 0
        val result = mutableListOf<String>()

        while (leftIndex < left.size && rightIndex < right.size) {
            if (left[leftIndex].length >= right[rightIndex].length) {
                result.add(left[leftIndex])
                leftIndex++
            } else {
                result.add(right[rightIndex])
                rightIndex++
            }
        }
        result.addAll(left.subList(leftIndex, left.size))
        result.addAll(right.subList(rightIndex, right.size))

        return result
    }
}
