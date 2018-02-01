class JustAClass {
    var stuff: MutableList<String> = ArrayList<String>()
        set(value) {
            field = value
            println("stuff set " + stuff)
        }

    constructor(stuff: MutableList<String>) {
        this.stuff = stuff
    }

    fun addMoreStuff(moreStuff: List<String>) {
        stuff.addAll(moreStuff)
    }

    fun printShit() {
        for (str in stuff) {
            println(str)
        }
    }

    fun getCount() = stuff?.let {
        when(stuff.size) {
            0,1 -> 1
            else -> stuff.size + 1
        }
    } ?: let {
        println("null case")
        1}
}