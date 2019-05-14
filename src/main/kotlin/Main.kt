import org.w3c.dom.Element
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import kotlin.browser.document

private val clientID = "7a533d5840"
private val password = "java"
const val KEY_FILE = """
    --- BEGIN PRIVATE KEY ---
MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCb2UPqBY7KKSGla3EMHCzCVWWFmmAj
62uS+IqC7Yh+kFb3CH+gPYMkluAPnuvBk9EwzrPTfH/RjGICAHwMO25wXAmLStnM+Pt4yJAAdc75tQVr
b0o5llB3QRPfYy4KYjmlKHuxyNb4kx/xFzRiLjHrphkPfyPDW/REVD46pMmrefXURWaOkf384I/XoPX+
tYeuUqnjskrDXvudtjZpnFwie3hPZomd43s4aNlAWw+J7BIG/CfC4KVnz2TXQPzK6Y3KV0qLTkTo9/Lz
4DQmqCAxIgGqE0s2q/wlaDltv2UuHV+dSB8Om3ooJkY3h3Cm0HEs2X7h+DRLYz/bs48SJsmjAgMBAAEC
ggEAQZmobp88RXgew4SAJzrM1FghzaT3hucXdtvLYeUeKTgUgxM+tXJu+z3OvoSEdA0GZub65rBnFQtk
Tbdqf7OcfwsesVUmbJL5NxQlGSx9nLpHt7s2oRrWb/wio0saHCDQZuatel4xrpwvO8oqsJEFTk2yCsXX
hen03bYgI4stoFGik4HmAOYNalsslkOrbBdbxHTMaWIuV/uLEItxn86Q2Yx4cVrFaKZO3E6MIR6EEm+H
sBx9UQOQdeJY/clY3yjhU0sTO1n/jRk7My9vzoIaHpjzACvXefO1npk/bc7S+H90W6ItyOWmUxZBNYMJ
CIEeAB5sgU0YUGlHymGMcRvvcQKBgQDgLyQFCHpNwHInhvag2NgnwcWR97/dIs/hqk7Mz9oLOms+CbuC
kA647v3nj1PzKKzB724bEZYEK0bacO5rOP3tKHsjGMYoOJBf9pKj53PxYdiygNz84oPbUKegtvMeyE6i
rlokQcTNYQ8ihX91m6eEAeTFDTvfGVW8XgkfG9wX1wKBgQCx92vxCr3HurpBB0t0wg9EAuRt7Xti0tum
+EySrmCqQQKHwykUuDv+toBNgvldhGKmdKag5l2HZ+ah5UVPgn/On2gEt6gjdA7tnWDWlx/CyICCxC51
U1Q/6puuH2aKJgMuWB+dagLWMnSWRPNytIBNigRdxnd1risPO7pMc08zFQKBgQDD4KyKMUQbl2CmpMfs
9kq3QhmMVnovj3EvbYz4a0vKr7pwNDS/+XrDnx3+Kz9goFOCB9+eixkWf3Gi/zVyPhOwGcStf8Hz9qg/
EMRDrcGiUKn0HZ/43Tn0cF5mkDOQ29fJUKm2MDjycjG1KguaCOyu7LCkc9GyNwKwWUGDCuaddQKBgGYZ
u/zDG9QdpcOvCrRGrXloa2NBzvsIW+o0I8I3ds/WkjwPVF9Fv23HiF5v2N61F9/Fpt9CqsAHdQLGxXfz
N530SDoEn9sPN41NMASNGTSn0Uq0gK7hCsHMuFoyO6LgYgzRk/m8mzoGImsfzceuFLnnh8/BEEIclSmd
K6m2seZtAoGAK8a9lbXmAjmKsoGAswFyMaIA+9lxi8JyaZjayuoq4EHaV+IMZm0zCuH2KT86UKDxgCzP
Xabp1BWDfy+bWDK3YY/Uog0tKTVnXYNTpEiawtmUKwuI7iOhEU59TXtGxzllTzVDytcxsX90CBI3IyFN
a4Ff/t8HJq5lpDNw/p7frhM=
--- END PRIVATE KEY ---
--- BEGIN PUBLIC KEY ---
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm9lD6gWOyikhpWtxDBwswlVlhZpgI+trkviK
gu2IfpBW9wh/oD2DJJbgD57rwZPRMM6z03x/0YxiAgB8DDtucFwJi0rZzPj7eMiQAHXO+bUFa29KOZZQ
d0ET32MuCmI5pSh7scjW+JMf8Rc0Yi4x66YZD38jw1v0RFQ+OqTJq3n11EVmjpH9/OCP16D1/rWHrlKp
47JKw177nbY2aZxcInt4T2aJneN7OGjZQFsPiewSBvwnwuClZ89k10D8yumNyldKi05E6Pfy8+A0Jqgg
MSIBqhNLNqv8JWg5bb9lLh1fnUgfDpt6KCZGN4dwptBxLNl+4fg0S2M/27OPEibJowIDAQAB
--- END PUBLIC KEY ---"""

val r = Release.DEV

val url = "http://" + IP.getValue(r) + ":" + 9999 + "/api/${r.str}"


external class Event

external class XMLHttpRequest {
    var onreadystatechange: (thi: XMLHttpRequest, ev: Event) -> Unit
    fun open(httpVerb: String, url: String, async: Boolean)
    fun send(body: String)
    val readyState: Int
    val response: Any
    val responseText: String
    val status: Int
}


fun request(
    verb: String,
    body: String = "",
    urlEnding: String,
    callback: (XMLHttpRequest) -> Unit = {},
    errorCallback: (XMLHttpRequest) -> Unit = {}
) {
    val req = XMLHttpRequest()
    req.onreadystatechange = { _, _ ->
        if (req.readyState == 4 && req.status == 200)
            callback(req)
        else if (req.readyState == 4)
            errorCallback(req)
    }
    req.open(verb, url + urlEnding, true)
    req.send(body)
}

inline fun <reified T : Element> opt(id: String): Optional<T> =
    document.getElementById(id)?.unsafeCast<T>().toOptionalNullable()

inline fun <reified T : Element> dom(id: String): T =
    document.getElementById(id)?.unsafeCast<T>().toOptionalNullable().getOrError("Can't find dom element $id")


fun main() {
    dom<HTMLButtonElement>("button")
        .addEventListener("click", {
            request(
                verb = "GET",
                urlEnding = "/ping",
                callback = { req -> dom<HTMLDivElement>("pong").textContent = req.responseText })
        })
}

