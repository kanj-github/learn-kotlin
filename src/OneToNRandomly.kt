import java.util.*
import kotlin.collections.ArrayList

val random = Random();

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("fuck you!")
        return
    }

    try {
        val arr:ArrayList<Int> = ArrayList()
        /*for (i in 1..args[0].toInt()) {
            arr.add(i)
        }*/
        (1..args[0].toInt()).mapTo(arr) {it}
        printOneByOne(arr)
    } catch (e: NumberFormatException) {
        println("fuck you!")
    }
}

tailrec fun printOneByOne(arr: ArrayList<Int>) {
    val bound = arr.size - 1
    if (bound > 0) {
        val index = random.nextInt(bound)
        println(arr[index])
        arr.removeAt(index)
        printOneByOne(arr)
    } else {
        println(arr[0])
    }
}