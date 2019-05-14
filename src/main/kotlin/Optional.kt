
interface Optional<T> {
    companion object {
        fun <T> empty(): Optional<T> {
            return None()
        }
        fun <T> forValue(t :T):Optional<T>{
            return Some(t)
        }
        fun <T> forValueNullable(t :T?):Optional<T>{
            return t?.let { Some(it) } ?: empty()
        }
    }
    fun getOrElse(getter: () -> T): T
    fun getOrElse(t: T): T
    fun orElse(other: Optional<T>): Optional<T>
    fun get(): T
    fun <R> map(mapper: (T) -> R): Optional<R>
    fun isPresent() :Boolean
    fun filter(filter :(T) -> Boolean):Optional<T>

    fun isNotPresent() = !isPresent()
    fun getNullable():T? = if(isPresent()) get() else null
    fun ifPresent(intake :(T) -> Unit) { if(isPresent()) intake.invoke(get()) }
    fun ifNotPresent(intake :() -> Unit) { if(isNotPresent()) intake.invoke() }
    fun getOrError(message :Any):T = getNullable() ?: error(message)
}

class None<T> :Optional<T>{
    override fun getOrElse(getter: () -> T): T = getter()

    override fun getOrElse(t: T): T = t

    override fun orElse(other: Optional<T>): Optional<T> = other

    override fun get(): T = throw NullPointerException("Can't get from empty optional")

    override fun <R> map(mapper: (T) -> R): Optional<R> = Optional.empty()

    override fun isPresent(): Boolean = false

    override fun filter(filter: (T) -> Boolean): Optional<T> = this
}

class Some<T> (private val value :T) :Optional<T>{
    override fun getOrElse(getter :() -> T) = value
    override fun getOrElse(t :T) = value
    override fun orElse(other :Optional<T>) = this
    override fun get() = value
    override fun <R> map(mapper :(T) -> R) = Some(mapper(value))
    override fun isPresent() = true
    override fun filter(filter: (T) -> Boolean) = if(filter(value)) this else None<T>()
}

//special
fun <T> Optional<Optional<T>>.flatMap() = this.getOrElse { Optional.empty() }
fun <T> T?.toOptionalNullable() = Optional.forValueNullable(this)
fun <T> T.toOptional() = Optional.forValue(this)