class Bomb (var a: Int) {
    var b : Int? = null
    var stuff : MutableList<String>? = null

    fun appendSomeStuff(newStuff: List<String>) {
        stuff?.addAll(newStuff) ?: let { stuff = ArrayList<String>(newStuff) }
    }
}

fun main(args: Array<String>) {
    val bomb : Bomb? = Bomb(1)
    //bomb?.b = 2
    println(bomb?.a ?: "bomb is null")
    println(bomb?.b ?: "bomb is null") // Elvis needs bomb.b to be non-null too

    val arr : ArrayList<String> = ArrayList()
    arr.add("abc")
    arr.add("bcd")
    bomb?.appendSomeStuff(arr)
    println(bomb?.stuff)
    // Check HandleNullFieldOutsideClass for more ways to do this
}
