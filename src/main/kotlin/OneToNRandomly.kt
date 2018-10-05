import java.util.*
import kotlin.collections.ArrayList

val random = Random();
val usageText = """
|Usage:
|    main(N) - print 1 to N in random order
|    main(N1, N2) - print N1 to N2 in random order
""".trimMargin()

// Prints N1 to N2 in random order.
fun main(args: Array<String>) {
    if (args.isEmpty() || args.size > 2) {
        println(usageText)
        return
    }

    try {
        val start: Int
        val end: Int
        if (args.size == 2) {
            start = args[0].toInt()
            end = args[1].toInt()
        } else {
            start = 1
            end = args[0].toInt()
        }

        val arr:ArrayList<Int> = ArrayList()
        /*for (i in start..end) {
            arr.add(i)
        }*/
        (start..end).mapTo(arr) {it}
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