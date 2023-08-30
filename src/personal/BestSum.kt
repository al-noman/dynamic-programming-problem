package personal

fun main() {
    println(dynamicBestSum(7, intArrayOf(5, 3, 4, 7))?.asList())
    println(dynamicBestSum(8, intArrayOf(2, 3, 5))?.asList())
    println(dynamicBestSum(8, intArrayOf(1, 4, 5))?.asList())
    println(dynamicBestSum(100, intArrayOf(1, 2, 5, 25))?.asList())
    println()
    println(simpleBestSum(7, intArrayOf(5, 3, 4, 7))?.asList())
    println(simpleBestSum(8, intArrayOf(2, 3, 5))?.asList())
    println(simpleBestSum(8, intArrayOf(1, 4, 5))?.asList())
    println(simpleBestSum(100, intArrayOf(1, 2, 5, 25))?.asList())
}

fun simpleBestSum(targetSum: Int, nums: IntArray): IntArray? {
    if (targetSum == 0) return intArrayOf()
    if (targetSum < 0) return null

    var bestSum: IntArray? = null
    for (item in nums) {
        var result = simpleBestSum(targetSum-item, nums)
        if (result != null) {
            result = result.plus(item)
            bestSum = bestSum?.let {
                if (it.size > result.size) result else it
            } ?: result
        }
    }
    return bestSum
}

fun dynamicBestSum(targetSum: Int, nums: IntArray, memo: MutableMap<Int, IntArray?> = mutableMapOf()): IntArray? {
    if (memo.containsKey(targetSum)) return memo[targetSum]
    if (targetSum == 0) return intArrayOf()
    if (targetSum < 0) return null

    var bestSum: IntArray? = null
    for (item in nums) {
        var result = dynamicBestSum(targetSum-item, nums, memo)
        if (result != null) {
            result = result.plus(item)
            bestSum = bestSum?.let {
                if (it.size > result.size) result else it
            } ?: result
        }
    }
    memo[targetSum] = bestSum
    return bestSum
}