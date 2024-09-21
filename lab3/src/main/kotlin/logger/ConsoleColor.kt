package lab3.logger

enum class ConsoleColor(val code: String) {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    WHITE("\u001B[37m");

    override fun toString(): String = code
}