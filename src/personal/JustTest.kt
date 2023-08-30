package personal

import kotlin.math.pow


fun main() {
    println(solution(intArrayOf(2, 3, 1, 3)))
    println(solution(intArrayOf(3, 7, 0, 5)))
    println(solution(intArrayOf(4, 10, 7, 2, 7)))
}

fun solution(A: IntArray): Int {
    val computedArray = A.clone()

    for (i in 0 until A.size) {
        var leftSum = 0
        var rightSum = 0

        for (j in 0 until i) {
            leftSum += (A[j] * 2.toDouble().pow(j)).toInt()
        }
        leftSum = (leftSum / 2.toDouble().pow(i)).toInt()

        for (j in i+1 until A.size) {
            rightSum += (A[j] * 2.toDouble().pow(A.size-j-1)).toInt()
        }
        rightSum = (rightSum / 2.toDouble().pow(A.size-i-1)).toInt()

        computedArray[i] = A[i] + leftSum + rightSum
    }

    return computedArray.maxOrNull() ?: 0
}