class NestedLet {
    var a: String? = null
    var b: String? = null

    fun doSomethingWithAb() {
        // Use nested let
        a?.let { itA ->
            b?.let { itB ->
                println(itA.length + itB.length)
            }
        }

        // Can also use a custom "let"
        letWithTwoStrings(a, b) { itA, itB ->
            println(itA.length + itB.length)
        }
        println("Something done")
    }

    fun <R: Any>letWithTwoStrings(str1: String?, str2: String?, block: (String, String)->R?) : R? {
        return if (str1 != null && str2 != null) block(str1, str2) else null
    }
}

fun main(args: Array<String>) {
    val nl = NestedLet()

    nl.doSomethingWithAb()

    nl.a = "abc"
    nl.doSomethingWithAb()

    nl.b = "xy"
    nl.doSomethingWithAb()

    nl.a = null
    nl.doSomethingWithAb()
}