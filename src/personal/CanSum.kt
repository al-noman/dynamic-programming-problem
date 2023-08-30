package personal

fun main() {
//    println(canSum(7, intArrayOf(2, 3)))
//    println(canSum(7, intArrayOf(5, 3, 4, 7)))
//    println(canSum(7, intArrayOf(2, 4)))
//    println(canSum(8, intArrayOf(2, 3, 5)))
//    println(canSum(300, intArrayOf(7, 14)))

    println(canSumDP(7, intArrayOf(2, 3)))
    println(canSumDP(7, intArrayOf(5, 3, 4, 7)))
    println(canSumDP(7, intArrayOf(2, 4)))
    println(canSumDP(8, intArrayOf(2, 3, 5)))
    println(canSumDP(300, intArrayOf(7, 14)))
}

fun canSum(target: Int, args: IntArray): Boolean {
    if (target == 0) return true
    if (target < 0) return false

    var result = false
    for (item in args) {
        if (canSum(target-item, args)) {
            result = true
            break
        }
    }
    return result
}

fun canSumDP(target: Int, args: IntArray, memo: MutableMap<Int, Boolean> = mutableMapOf()): Boolean {
    if (memo.containsKey(target)) return memo[target]!!
    if (target == 0) return true
    if (target < 0) return false

    var result = false
    for (item in args) {
        if (canSumDP(target-item, args, memo)) {
            result = true
            break
        }
    }
    memo[target] = result
    return result
}
