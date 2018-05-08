fun main(args: Array<String>) {
    var num = 1
    num = num.shl(2)
    // Need to assign because Int is immutable like java String
    println(num)

    num = num or 3
    println(num)
    val five = 5
    num = num and five.inv()
    println(num)
}