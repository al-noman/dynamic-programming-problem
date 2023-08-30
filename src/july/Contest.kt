package july

fun main() {
//    println("Hello world")
//
//    println(solution(arrayOf("039", "4", "14", "32", "", "34", "7")))
//    println(solution(arrayOf("801234567", "180234567", "0", "189234567", "891234567", "98", "9")))
//    println(solution(arrayOf("5421", "245", "1452", "0345", "53", "354")))


    println(BrushCount(intArrayOf(1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2)))
    println(BrushCount(intArrayOf(5, 8)))
    println(BrushCount(intArrayOf(1, 1, 1, 1)))
}


fun solution(E: Array<String>): Int {
    val dayMap = mutableMapOf<Int, MutableList<Int>>()
    for (i in 0 until 10) {
        dayMap[i] = mutableListOf()
    }

    for (i in E.indices) {
        for (j in 0 until 10) {
            val ej = Character.forDigit(j, 10)
            if (E[i].contains(ej)) {
                dayMap[j]?.add(i)
            }
        }
    }

    var maximumEmployee = 0
    for (i in 0 until 10) {
        for (j in i+1 until 10) {
            val ithDayEmployees = dayMap[i]!!
            val jthDayEmployees = dayMap[j]!!
            val totalEmployees = ithDayEmployees.plus(jthDayEmployees).toSet()

            if (totalEmployees.size > maximumEmployee) maximumEmployee = totalEmployees.size
        }
    }

    return maximumEmployee
}

fun BrushCount(A: IntArray): Int {
    var brushCount = 0
    var prevHeight = 0
    for (i in A.indices) {
        if (A[i] > prevHeight) brushCount += (A[i] - prevHeight)
        prevHeight = A[i]
    }
    return brushCount
}