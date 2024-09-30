package lab7

data class Contact(val number: String, var name: String) {
    val tags = mutableSetOf<String>()
    var group: String? = null
}