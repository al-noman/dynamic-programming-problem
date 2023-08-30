package personal

fun main() {
    println(dynamicCountConstruct("purple", arrayOf("purp", "p", "ur", "le", "purpl")))
    println(dynamicCountConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd")))
    println(dynamicCountConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(dynamicCountConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t")))
    println(dynamicCountConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")))
    println()
    println(simpleCountConstruct("purple", arrayOf("purp", "p", "ur", "le", "purpl")))
    println(simpleCountConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd")))
    println(simpleCountConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(simpleCountConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t")))
    println(simpleCountConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")))
}

fun simpleCountConstruct(targetString: String, src: Array<String>): Int {
    if (targetString.isEmpty()) return 1;

    var count = 0
    for (item in src) {
        if (targetString.startsWith(item)) {
            count += simpleCountConstruct(targetString.removePrefix(item), src)
        }
    }
    return count
}

fun dynamicCountConstruct(targetString: String, src: Array<String>, memo: MutableMap<String, Int> = mutableMapOf()): Int {
    if (memo.containsKey(targetString)) return memo[targetString]!!
    if (targetString.isEmpty()) return 1;

    var count = 0
    for (item in src) {
        if (targetString.startsWith(item)) {
            count += dynamicCountConstruct(targetString.removePrefix(item), src, memo)
        }
    }
    memo[targetString] = count
    return count
}