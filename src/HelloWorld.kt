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
    b.showNumber()

    println("thread " + Thread.currentThread().id)
    val t1 = doInANewThread {
        println("Some other thread " + Thread.currentThread().id)
    }

    t1.join()
}

fun doInANewThread(run: () -> Unit): Thread {
    with(Thread(Runnable(run))) {
        this.start()
        return this
    }
}

class Box(capacity: Int) { // capacity is val by default
    var stuff: Any? = null
    val initialisedNumber: Int

    init {
        println("initialisedNumber")
        initialisedNumber = 39
    }

    fun showNumber() = println(initialisedNumber)
}