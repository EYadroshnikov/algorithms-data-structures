package lab3

object Print {
    private fun printColored(text: String, color: ConsoleColor) {
        println("${color}$text${ConsoleColor.RESET}")
    }

    fun red(text: String) = printColored(text, ConsoleColor.RED)
    fun green(text: String) = printColored(text, ConsoleColor.GREEN)
    fun yellow(text: String) = printColored(text, ConsoleColor.YELLOW)
    fun white(text: String) = printColored(text, ConsoleColor.WHITE)
}