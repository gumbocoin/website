private val keyfile = """

""".trimIndent()

private val clientID = "b346f0ccf2"
private val password = "javascript"

external class Obj{
    fun ping()
}

external val obj :Obj

fun main() {
    obj.ping()
}