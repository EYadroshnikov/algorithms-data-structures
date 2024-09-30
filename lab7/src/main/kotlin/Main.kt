package lab7

fun main() {
    val phoneBook = PhoneBook()

    while (true) {
        println("\nВведите команду (add, del, find, tag, undo, show, exit):")
        val input = readLine()?.split(" ") ?: continue

        when (input[0]) {
            "add" -> {
                if (input.size >= 3) {
                    val number = input[1]
                    val name = input[2]
                    val group = if (input.size > 3) input[3] else null
                    phoneBook.add(number, name, group)
                    println("Контакт добавлен.")
                } else {
                    println("Ошибка: недостаточно аргументов для команды 'add'.")
                }
            }
            "del" -> {
                if (input.size == 2) {
                    phoneBook.delete(input[1])
                    println("Контакт удалён.")
                } else {
                    println("Ошибка: недостаточно аргументов для команды 'del'.")
                }
            }
            "find" -> {
                if (input.size == 2) {
                    println(phoneBook.find(input[1]))
                } else {
                    println("Ошибка: недостаточно аргументов для команды 'find'.")
                }
            }
            "tag" -> {
                if (input.size == 3) {
                    phoneBook.tag(input[1], input[2])
                    println("Метка добавлена.")
                } else {
                    println("Ошибка: недостаточно аргументов для команды 'tag'.")
                }
            }
            "undo" -> {
                phoneBook.undo()
                println("Последнее действие отменено.")
            }
            "show" -> {
                println(phoneBook)
            }
            "exit" -> {
                println("Выход из программы.")
                break
            }
            else -> {
                println("Неизвестная команда. Попробуйте ещё раз.")
            }
        }
    }
}