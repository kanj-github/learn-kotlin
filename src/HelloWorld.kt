fun main(args: Array<String>) {
    val data = mapOf("email" to "mail@domain.com")
    val email = data["email"] ?: "No email"
    println("-------")
    println(email)

    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |
    |(Benjamin Franklin)
    """.trimMargin()

    println(text)
}