import java.util.*

class UserRepository(private val users: List<User>) {

    fun loadUser(id: String): Optional<User> {
        return Optional.ofNullable(users.find { it.id == id })
    }

}

data class User(val id: String)

fun main(args: Array<String>) {

    val repository = UserRepository(listOf(
            User("first"),
            User("second")))

    val user = repository.loadUser("first")

    if (user.isPresent) {
        println(user.get())
    } else {
        println("not found :(")
    }

    val notFound = repository.loadUser("notFound")

    if (notFound.isPresent) {
        println(notFound.get())
    } else {
        println("not found :(")
    }

}