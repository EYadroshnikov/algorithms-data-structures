package lab4

fun main() {
    val stack = MaxStack<Int>()

    while (true) {
        print("Enter command (push <value> / pop / max / exit): ")
        val input = readLine()?.trim() ?: continue

        when {
            input.startsWith("push") -> {
                val value = input.split(" ").getOrNull(1)?.toIntOrNull()
                if (value != null) {
                    stack.push(value)
                    println("Value $value added to the stack")
                } else {
                    println("Error: invalid value for push")
                }
            }

            input == "pop" -> {
                val poppedValue = stack.pop()
                if (poppedValue != null) {
                    println("Value $poppedValue removed from the stack")
                } else {
                    println("Error: stack is empty")
                }
            }

            input.startsWith("remove") -> {
                val value = input.split(" ").getOrNull(1)?.toIntOrNull()
                if (value != null) {
                    val result = stack.remove(value)
                    println("Value $value ${if (result) "removed from the" else "not found in the"} stack")
                } else {
                    println("Error: invalid value for remove")
                }
            }

            input == "max" -> {
                val maxValue = stack.max()
                if (maxValue != null) {
                    println("Maximum value in the stack: $maxValue")
                } else {
                    println("Error: stack is empty")
                }
            }

            input == "exit" -> {
                println("Exiting the program")
                break
            }

            else -> {
                println("Error: unknown command")
            }
        }
        println(stack)
    }
}