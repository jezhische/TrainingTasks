fun main(args: Array<String>) {
    println(OneMore().go(null))
}



class OneMore() {
    fun go(msg: String?): String {
        val values = mapOf<String, String>("email" to "jezh@g.com", "login" to "ivan")
        val email = values["email"] ?: throw IllegalStateException("Email is missing!")
        val onemore = msg?: "null msg!"
        return email + " " + onemore
    }
}