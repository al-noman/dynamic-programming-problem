package personal

fun main() {
    println(dynamicHowSum(7, intArrayOf(2, 3))?.asList())
    println(dynamicHowSum(7, intArrayOf(5, 3, 4, 7))?.asList())
    println(dynamicHowSum(7, intArrayOf(2, 4))?.asList())
    println(dynamicHowSum(8, intArrayOf(2, 3, 5))?.asList())
    println(dynamicHowSum(300, intArrayOf(7, 14))?.asList())
    println()
    println(simpleHowSum(7, intArrayOf(2, 3))?.asList())
    println(simpleHowSum(7, intArrayOf(5, 3, 4, 7))?.asList())
    println(simpleHowSum(7, intArrayOf(2, 4))?.asList())
    println(simpleHowSum(8, intArrayOf(2, 3, 5))?.asList())
    println(simpleHowSum(300, intArrayOf(7, 14))?.asList())
}

fun simpleHowSum(targetSum: Int, nums: IntArray): IntArray? {
    if (targetSum == 0) return intArrayOf()
    if (targetSum < 0) return null

    for (item in nums) {
        var result = simpleHowSum(targetSum - item, nums)
        if (result != null) {
            result = result.plus(item)
            return result
        }
    }
    return null
}

fun dynamicHowSum(targetSum: Int, nums: IntArray, memo: MutableMap<Int, IntArray?> = mutableMapOf()): IntArray? {
    if (memo.containsKey(targetSum)) return memo[targetSum]
    if (targetSum == 0) return intArrayOf()
    if (targetSum < 0) return null

    for (item in nums) {
        var result = dynamicHowSum(targetSum - item, nums, memo)
        if (result != null) {
            result = result.plus(item)
            memo[targetSum] = result
            return result
        }
    }
    memo[targetSum] = null
    return null
}