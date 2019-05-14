import org.w3c.dom.HTMLButtonElement
import kotlin.browser.document
import kotlin.reflect.KCallable

private val clientID = "b346f0ccf2"
private val password = "javascript"

external class Obj{
    fun ping(callback :(String) -> Unit)
    var url :String
}

fun Obj.ping(){
    ping { println(it) }
}

external val obj :Obj

val r = Release.DEV



fun main() {
    obj.url = "http://" + IP.getValue(r) + ":" + 9999 + "/api/${r.str}"
    obj.ping()

//    document.getElementsByName("button")
//        .unsafeCast<HTMLButtonElement>()
//        .addEventListener("click",{
//            console.log("Pinging")
//            obj.ping()
//        })
    val button = document.getElementById("button") as HTMLButtonElement
    button.addEventListener("click", {
        println("pinging")
        obj.ping()
    })
}

