
enum class Release(val str: String) {
    MASTER("master"),
    BETA("beta"),
    DEV("dev")
}

val IP = mapOf(
    Release.MASTER to "72.66.54.109",
    Release.BETA to "72.66.54.109",
    Release.DEV to "localhost")

