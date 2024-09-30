package lab7

class PhoneBook {
    private val contacts = mutableMapOf<String, Contact>()
    private val history = mutableListOf<() -> Unit>()

    // Добавление или обновление контакта
    fun add(number: String, name: String, group: String? = null) {
        val previousContact = contacts[number]
        if (previousContact != null) {
            // Сохранение старого состояния для undo
            history.add { previousContact.name = previousContact.name }
            previousContact.name = name
            group?.let { previousContact.group = it }
        } else {
            val newContact = Contact(number, name)
            group?.let { newContact.group = it }
            contacts[number] = newContact
            // Добавление операции удаления для undo
            history.add { contacts.remove(number) }
        }
    }

    // Удаление контакта
    fun delete(number: String) {
        contacts[number]?.let { contact ->
            history.add { contacts[number] = contact } // Сохранение для undo
            contacts.remove(number)
        }
    }

    // Поиск контакта по номеру
    fun find(number: String): String {
        return contacts[number]?.name ?: "not found"
    }

    // Назначение метки контакту
    fun tag(number: String, tagName: String) {
        contacts[number]?.let { contact ->
            contact.tags.add(tagName)
            history.add { contact.tags.remove(tagName) } // Сохранение для undo
        }
    }

    // Поиск контактов по метке
    fun findByTag(tagName: String): List<String> {
        return contacts.values.filter { it.tags.contains(tagName) }
            .map { "${it.number}: ${it.name}" }
    }

    // Откат последнего изменения
    fun undo() {
        if (history.isNotEmpty()) {
            history.removeAt(history.lastIndex).invoke()
        }
    }

    override fun toString(): String {
        if (contacts.isEmpty()) return "Телефонная книга пуста."
        val header = "| %-10s | %-15s | %-10s | %-20s |\n".format("Номер", "Имя", "Группа", "Метки")
        val separator = "-".repeat(61)
        val rows = contacts.values.joinToString("\n") { contact ->
            val tags = contact.tags.joinToString(", ")
            "| %-10s | %-15s | %-10s | %-20s |".format(contact.number, contact.name, contact.group ?: "None", tags)
        }
        return "$header$separator\n$rows"
    }
}