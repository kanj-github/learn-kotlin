fun main(args: Array<String>) {
    val data = mapOf("emails" to "mail.domain.com")
    val email = data["email"] ?: "No email"
    println("-------")
    println(email)
}