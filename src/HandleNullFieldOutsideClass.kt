class StuffContainer(var stuff: MutableList<String>?) {
    fun appendSomeStuff(newStuff: List<String>) { // Appends to stuff, initialising it if null
        stuff?.addAll(newStuff) ?: let { stuff = ArrayList<String>(newStuff) }
    }
}

fun main (args: Array<String>) {
    val container = StuffContainer(null)

    val arr : ArrayList<String> = ArrayList()
    arr.add("abc")
    arr.add("bcd")

    // Now I want to put arr in container
    container.appendSomeStuff(arr)
    println(container.stuff) // [abc, bcd]

    // That worked. Now how to implement the logic in StuffContainer.appendSomeStuff here?
    container.stuff = null
    //container.stuff?.addAll(arr) ?: let { container.stuff = ArrayList<String>(arr) }
    // Can't write a let expression here

    if (container.stuff == null) {
        container.stuff = ArrayList<String>(arr)
    } else {
        container.stuff?.addAll(arr)
    }
    println(container.stuff) // [abc, bcd]

    container.stuff = null
    when {
        container.stuff == null -> container.stuff = ArrayList<String>(arr)
        else -> container.stuff?.addAll(arr)
    }
    println(container.stuff) // [abc, bcd]
}