import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    println("start")
    doShit()
    println("done")
}

fun doShit() = runBlocking {
    repeat(5) {
        launch {
            delay(1000L)
            println(it)
        }
    }
}
