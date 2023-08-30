package personal

fun main() {
    println("Hello world!")
//    println(simpleGridTraveller(Pair(1, 1)))
//    println(simpleGridTraveller(Pair(2, 3)))
//    println(simpleGridTraveller(Pair(3, 2)))
//    println(simpleGridTraveller(Pair(3, 3)))
//    println(simpleGridTraveller(Pair(18, 18)))

    println(dynamicGridTraveller(Pair(1, 1)))
    println(dynamicGridTraveller(Pair(2, 3)))
    println(dynamicGridTraveller(Pair(3, 2)))
    println(dynamicGridTraveller(Pair(3, 3)))
    println(dynamicGridTraveller(Pair(18, 18)))
}

fun simpleGridTraveller(position: Pair<Long, Long>): Long {
    val x = position.first
    val y = position.second

    if (x == 1L && y == 1L) return 1
    if (x == 0L || y == 0L) return 0

    return simpleGridTraveller(Pair(x-1, y)) + simpleGridTraveller(Pair(x, y - 1))
}

fun dynamicGridTraveller(position: Pair<Long, Long>, memo: MutableMap<Pair<Long, Long>, Long> = mutableMapOf()): Long {
    if (memo.containsKey(position)) return memo[position]!!

    val x = position.first
    val y = position.second

    if (x == 1L && y == 1L) return 1
    if (x == 0L || y == 0L) return 0

    val result = dynamicGridTraveller(Pair(x-1, y), memo) + dynamicGridTraveller(Pair(x, y - 1), memo)
    memo[position] = result
    return result
}