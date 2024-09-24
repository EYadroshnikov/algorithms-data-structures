package lab4

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return value.toString()
    }
}
