package lab2

import java.util.Scanner
import kotlin.math.max


fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val parents = Array<Int>(n) { scanner.nextInt() }

    println(calculateTreeHeight(n, parents))
}

fun calculateTreeHeight(n: Int, parents: Array<Int>): Int {
    val heights = Array<Int>(n) { -1 }

    fun getNodeHeight(node: Int): Int {
        if (parents[node] == -1) return 1
        if (heights[node] != -1) return heights[node]
        heights[node] = 1 + getNodeHeight(parents[node])
        return heights[node]
    }

    var maxHeight = 0
    for(i in 0 until n) {
        maxHeight = max(maxHeight, getNodeHeight(i))
    }
    return maxHeight
}