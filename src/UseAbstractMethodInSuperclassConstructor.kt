abstract class Base {
    val text: String
    constructor(text: String) {
        this.text = text
        println(text + getTextSuffix())
    }
    abstract fun getTextSuffix(): String
}

class Derived(text: String) : Base(text) {
    override fun getTextSuffix() = "_"
}

fun main(args: Array<String>) {
    val d = Derived("stuff")
}