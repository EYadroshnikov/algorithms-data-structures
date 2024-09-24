package lab4

class MaxStack<T : Comparable<T>> : Stack<T>() {
    private var maxTop: Node<T>? = null

    override fun push(value: T) {
        super.push(value)
        if (maxTop == null || value >= maxTop!!.value) {
            maxTop = Node(value, maxTop)
        }
    }

    override fun pop(): T? {
        val poppedValue = super.pop()
        if (poppedValue == maxTop?.value) {
            maxTop = maxTop?.next
        }
        return poppedValue
    }

    override fun remove(value: T): Boolean {
        val isRemoved = super.remove(value)

        var current = maxTop
        var previous: Node<T>? = null

        while (isRemoved && current != null) {
            if (current.value == value) {
                if (!super.isExist(value)) {
                    if (previous == null) { // Removing the top element
                        maxTop = current.next
                    } else {
                        previous.next = current.next
                    }
                }
                break
            }

            previous = current
            current = current.next
        }

        return isRemoved
    }

    fun max(): T? = maxTop?.value

    override fun toString(): String {
        val values = mutableListOf<T>()
        var current = maxTop
        while (current != null) {
            values.add(current.value)
            current = current.next
        }
        return "Stack: ${super.toString()}\n" +
                "Max top: ${values.joinToString(" -> ")}"
    }
}