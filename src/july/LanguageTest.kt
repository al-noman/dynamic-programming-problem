package july

fun main() {
    val a = A()
    a.printMe()
    println(A.ca)
    A.someFunction("Name")
}


// It has its own toString(), hashCode(), equals(), copy() method automatically created
// Needs at least one parameter for the primary constructor
// Data classes can not be Abstract, Open, Sealed or even can not contain any Inner Data class. // No Abstract, open, sealed, inner data class
data class Person(
    val firstName: String,
    val lastName: String,
    val address: String
)

open class A(
    val firstName: String,
    val lastName: String,
    val address: String
) {
    val a: String = "a"

    constructor() : this("firstName", "lastName", "address") {
        println("Hello from secondary constructor")
    }

    companion object {
        const val ca = "Name"

        fun someFunction(x: String) {
            when(x) {
                "Name" -> println("I know you passed the string Name")
                else -> println("I dont know what you want")
            }
        }
    }

    open fun printParent() = println("Printing from parent")
}

fun A.printMe() {
    println("$firstName, $lastName, $address, $a")
}

class B: A() {
    override fun printParent() = println("printing from child")
}