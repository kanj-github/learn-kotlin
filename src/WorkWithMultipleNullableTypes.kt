/*
* Make duplicate properties with non-nullable type with custom get. Like _str for str.
* */

class WorkWithMultipleNullableTypes {
    var str: String? = null
        /*get() {
            return if (field != null) {
                field
            } else {
                this.ant?.text ?: "XYZ"
            }
        }*/

    var ant: Ant? = null
    var bomb: Bomb? = null
    //val nonNull = NonNull()

    /*class NonNull() {
        lateinit var str: String
        lateinit var ant: Ant
        lateinit var bomb: Bomb
    }*/

    val _str: String
        get() {
            if (str == null) {
                str = ant?.text ?: "XYZ"
            }
            return str ?: throw AssertionError("what happened to str?")
        }

    val _ant: Ant
        get() {
            if (ant == null) {
                ant = Ant()
            }
            return ant ?: throw AssertionError("what happened to ant?")
        }

    val _bomb: Bomb
        get() {
            if (bomb == null) {
                bomb = Bomb(16)
            }
            return bomb ?: throw AssertionError("what happened to bomb?")
        }
    fun doSomething() {
/*
        var str_: String
        var ant_: Ant
        var bomb_: Bomb
*/

        /*if (str == null && ant != null) {
            str = ant?.text
        } else if (str == null) {
            str = "XYZ"
            ant = Ant()
        }

        if (bomb == null) {
            bomb = Bomb(16)
        }*/

        str?.let{
            //str_ = it
            //nonNull.str = it
        }
        ant?.let {
            //ant_ = it
            //nonNull.ant = it

        }
        bomb?.let {
            //bomb_ = it
            //nonNull.bomb = it
        }

        //nonNull.bomb.appendSomeStuff(listOf("a", "b", "4"))

        // Access _properties now
    }
}