fun main(args: Array<String>) {
    println("Start")

    try {
        Thread.sleep(1000)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

    val aAss = DumbAss.getInstance(Ass("JackAss"))

    val bAss = DumbAss.getInstance(Ass("SmartAss"))

    aAss.foo()

    bAss.foo()

    println(aAss === bAss)

    // Can't instantiate
    //val cAss = DumbAss(Ass("FunkyAss"))
}

class DumbAss private constructor(val ass: Ass) {

    init {
        println("Dumbass init ${ass.name}")
    }

    fun foo() {
        println("Dumbass says - ${ass.name}")
    }

    companion object {
        private lateinit var ass: Ass

        private val INSTANCE by lazy {
            DumbAss(ass)
        }

        fun getInstance(ass: Ass): DumbAss {
            this.ass = ass
            return INSTANCE
        }
    }
}

class Ass(val name: String)