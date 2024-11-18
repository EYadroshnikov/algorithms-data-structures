package lab8

class Tree<T> {
    private data class Node<T>(var value: T, var leftChild: Node<T>? = null, var rightChild: Node<T>? = null) {
        override fun toString(): String {
            return value.toString()
        }
    }

    private var root: Node<T>? = null


    private fun inOrder(node: Node<T>?, result: MutableList<T>): Unit {
        if (node !== null) {
            inOrder(node.leftChild, result)
            result.add(node.value)
            inOrder(node.rightChild, result)
        }
    }

    private fun preOrder(node: Node<T>?, result: MutableList<T>): Unit {
        if (node !== null) {
            result.add(node.value)
            preOrder(node.leftChild, result)
            preOrder(node.rightChild, result)
        }
    }

    private fun postOrder(node: Node<T>?, result: MutableList<T>): Unit {
        if (node !== null) {
            preOrder(node.leftChild, result)
            preOrder(node.rightChild, result)
            result.add(node.value)
        }
    }

    fun inOrder(): List<T> {
        val result = mutableListOf<T>()
        inOrder(this.root, result)
        return result
    }

    fun preOrder(): List<T> {
        val result = mutableListOf<T>()
        preOrder(this.root, result)
        return result
    }

    fun postOrder(): List<T> {
        val result = mutableListOf<T>()
        postOrder(this.root, result)
        return result
    }
}
