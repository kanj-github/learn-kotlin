fun main(args: Array<String>) {
    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |
    |(Benjamin Franklin)
    """.trimMargin()

    println(text)

    val b = Box(9)
    //b.capacity = 10
    b.stuff = "A string"
}

class Box(capacity: Int) { // capacity is val by default
    var stuff: Any = Box(7)
}