package lab4


class SingleLinkedList<T> : Iterable<T> {
    private var head: Node<T>? = null
    var size = 0
        private set

    private data class Node<T>(var value: T, var next: Node<T>? = null) {
        override fun toString(): String {
            return value.toString()
        }
    }

    fun push(value: T): Unit {
        head = Node(value, head)
        size++
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        val poppedValue = head!!.value
        head = head!!.next
        size--
        return poppedValue
    }

    fun peek(): T? {
        return head?.value
    }

    fun remove(value: T): Boolean {
        if (isEmpty()) return false

        if (head!!.value == value) {
            head = head!!.next
            size--
            return true
        }

        var currentNode = head
        while (currentNode?.next != null) {
            if (currentNode.next!!.value == value) {
                currentNode.next = currentNode.next!!.next
                size--
                return true
            }
            currentNode = currentNode.next
        }
        return false
    }

    fun contains(value: T): Boolean {
        var currentNode = head
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true
            }
            currentNode = currentNode.next
        }
        return false
    }

    fun count(value: T): Int {
        var count = 0
        var currentNode = head
        while (currentNode != null) {
            if (currentNode.value == value) {
                count++
            }
            currentNode = currentNode.next
        }
        return count
    }

    fun isEmpty(): Boolean = head == null

    override fun toString(): String {
        val values = mutableListOf<T>()
        var current = head
        while (current != null) {
            values.add(current.value)
            current = current.next
        }
        return values.joinToString(" -> ")
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            private var currentNode = head

            override fun hasNext(): Boolean {
                return currentNode != null
            }

            override fun next(): T {
                val value = currentNode?.value ?: throw NoSuchElementException()
                currentNode = currentNode?.next
                return value
            }
        }
    }
}