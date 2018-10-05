class Bomb (var a: Int) {
    var b : Int? = null
    var stuff : MutableList<String>? = null

    fun appendSomeStuff(newStuff: List<String>) {
        stuff?.addAll(newStuff) ?: let { stuff = ArrayList<String>(newStuff) }
    }
}

class Ant {
    val text = "ABCD"
}

fun main(args: Array<String>) {
    var bomb : Bomb? = Bomb(1)
    //bomb?.b = 2
    println(bomb?.a ?: "bomb-a is null")
    println(bomb?.b ?: "bomb-b is null") // Elvis needs bomb.b to be non-null too

    val arr : ArrayList<String> = ArrayList()
    arr.add("abc")
    arr.add("bcd")
    //bomb = null
    bomb?.appendSomeStuff(arr) ?: println("bomb is null")
    println(bomb?.stuff)
    // Check HandleNullFieldOutsideClass for more ways to do this

    val antIns: Ant? = Ant()
    println(antIns?.text?.length) // Need to access length using ?. too because ansIns?.text is of type String?
}
