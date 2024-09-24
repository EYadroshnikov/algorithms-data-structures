package lab4

open class Stack<T> {
    protected val list = SingleLinkedList<T>()
    private val capacity = 100

    open fun push(value: T): Unit {
        if (list.size >= capacity) {
            throw StackOverflowError()
        }
        return list.push(value)
    }

    open fun pop(): T? {
        return list.pop()
    }

    open fun remove(value: T): Boolean {
        return list.remove(value)
    }

    fun contains(value: T): Boolean {
        return list.contains(value)
    }

    fun size(): Int {
        return list.size
    }

    override fun toString(): String {
        return list.toString()
    }
}