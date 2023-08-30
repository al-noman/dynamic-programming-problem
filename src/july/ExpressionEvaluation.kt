package july

fun main() {
    println("Print Hello For Abdullah")
    println('+'.isOperator())
    println('-'.isOperator())
    println('/'.isOperator())
    println('*'.isOperator())
    println('.'.isOperator())
    println('('.isOperator())
}

fun evaluateExpression(inputExpression: String): Int {
    // Evaluate 4 different types of characters
    // opening bracket, closing bracket, operator, digit

    for (token in inputExpression) {
        when {
            token.isDigit() -> println("Hello my digit: $token")
            token.isOperator() -> println("Hello my operator: $token")
        }
    }

    return 0
}

fun Char.isOperator(): Boolean {
    return arrayOf('+', '-', '*', '/').contains(this)
}