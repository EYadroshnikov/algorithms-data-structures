package lab6

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val heap = Array(size) { n -> scanner.nextInt() }
    val swaps = mutableListOf<Pair<Int, Int>>()

    for (rootIndex in size / 2 - 1 downTo 0) {
        heapify(heap, size, rootIndex, swaps)
    }

    println(swaps.size)
    swaps.forEach { (i, j) ->
        println("$i $j")
    }
//    println(heap.joinToString(" "))
}

fun heapify(heap: Array<Int>, heapSize: Int, rootIndex: Int, swaps: MutableList<Pair<Int, Int>>) {
    var minIndex = rootIndex
    val leftChildIndex = 2 * rootIndex + 1
    val rightChildIndex = 2 * rootIndex + 2

    if (leftChildIndex < heapSize && heap[leftChildIndex] < heap[minIndex]) {
        minIndex = leftChildIndex
    }

    if (rightChildIndex < heapSize && heap[rightChildIndex] < heap[minIndex]) {
        minIndex = rightChildIndex
    }

    if (rootIndex != minIndex) {
        heap[rootIndex] = heap[minIndex].also { heap[minIndex] = heap[rootIndex] }
        swaps.add(rootIndex to minIndex)
        heapify(heap, heapSize, minIndex, swaps)
    }
}
