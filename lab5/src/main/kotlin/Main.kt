package lab5

import java.util.*

fun findMaxInSlidingWindow(n: Int, arr: List<Int>, windowSize: Int): List<Int> {
    val result = mutableListOf<Int>()
    val deque = LinkedList<Int>() // будет хранить индексы элементов массива

    for (i in 0 until n) {
        // Удаляем индексы элементов, которые вышли за пределы текущего окна
        if (deque.isNotEmpty() && deque.first() == i - windowSize) {
            deque.removeFirst()
        }

        // Удаляем из deque элементы, которые меньше текущего элемента,
        // так как они не могут быть максимумом в текущем или следующих окнах
        while (deque.isNotEmpty() && arr[deque.last()] <= arr[i]) {
            deque.removeLast()
        }

        // Добавляем текущий элемент в deque
        deque.addLast(i)

        // Максимум для текущего окна - элемент, который находится в начале deque
        if (i >= windowSize - 1) {
            result.add(arr[deque.first()])
        }
    }

    return result
}

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val windowSize = readLine()!!.toInt()
    val result = findMaxInSlidingWindow(n, arr, windowSize)
    println(result.joinToString(" "))
}
