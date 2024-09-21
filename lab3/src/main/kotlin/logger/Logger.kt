package lab3.logger

object Print {
    private fun printColored(text: String, color: ConsoleColor) {
        println("[${System.currentTimeMillis().toInt()}] ${color}$text${ConsoleColor.RESET}")
    }

    fun red(text: String) = printColored(text, ConsoleColor.RED)
    fun green(text: String) = printColored(text, ConsoleColor.GREEN)
    fun yellow(text: String) = printColored(text, ConsoleColor.YELLOW)
    fun white(text: String) = printColored(text, ConsoleColor.WHITE)
}