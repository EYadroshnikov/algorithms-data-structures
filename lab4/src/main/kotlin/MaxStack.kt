package lab4

class MaxStack<T : Comparable<T>> : Stack<T>() {
    private val maxList = SingleLinkedList<T>()

    override fun push(value: T) {
        super.push(value)
        if (maxList.peek() == null || value >= maxList.peek()!!) {
            maxList.push(value)
        }
    }

    override fun pop(): T? {
        val poppedValue = super.pop()
        if (poppedValue == maxList.peek()) {
            maxList.pop()
        }
        return poppedValue
    }

    override fun remove(value: T): Boolean {
        val isRemoved = super.remove(value)

        if (isRemoved) {
            for (max in maxList) {
                if (max == value) {
                    maxList.remove(max)
                    break
                }
            }
        }

        return isRemoved
    }

    fun max(): T? = maxList.peek()

    override fun toString(): String {
        return "Stack: ${super.toString()}\n" +
                "Max top: ${maxList.toString()}"
    }
}