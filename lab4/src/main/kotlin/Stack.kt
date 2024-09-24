package lab4

open class Stack<T> {
    private var top: Node<T>? = null

    open fun push(value: T): Unit {
        top = Node(value, top)
    }

    open fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        val poppedValue = top?.value
        top = top?.next
        return poppedValue
    }

    open fun remove(value: T): Boolean {
        var current = top
        var previous: Node<T>? = null

        while (current != null) {
            if (current.value == value) {
                if (previous == null) { // Removing the top element
                    top = current.next
                } else {
                    previous.next = current.next
                }
                return true
            }
            previous = current
            current = current.next
        }
        return false // Value not found
    }

    fun peek(): T? = top?.value

    fun isEmpty(): Boolean = top == null

    fun isExist(value: T): Boolean {
        var current = top
        while (current != null) {
            if (current.value == value) {
                return true
            }
            current = current.next
        }
        return false
    }

    fun size(): Int {
        var count = 0
        var current = top
        while (current != null) {
            count++
            current = current.next
        }
        return count
    }

    override fun toString(): String {
        val values = mutableListOf<T>()
        var current = top
        while (current != null) {
            values.add(current.value)
            current = current.next
        }
        return values.joinToString(" -> ")
    }
}