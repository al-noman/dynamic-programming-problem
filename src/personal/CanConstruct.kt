package personal

fun main() {
    println(dynamicCanConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd")))
    println(dynamicCanConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(dynamicCanConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t")))
    println(dynamicCanConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")))
    println()
    println(simpleCanConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd")))
    println(simpleCanConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(simpleCanConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t")))
    println(simpleCanConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")))
}

fun simpleCanConstruct(targetString: String, src: Array<String>): Boolean {
    if (targetString.isEmpty()) return true

    for (item in src) {
        if (targetString.startsWith(item)) {
            if (simpleCanConstruct(targetString.removePrefix(item), src)) return true
        }
    }
    return false
}

fun dynamicCanConstruct(targetString: String, src: Array<String>, memo: MutableMap<String, Boolean> = mutableMapOf()): Boolean {
    if (memo.containsKey(targetString)) return memo[targetString]!!
    if (targetString.isEmpty()) return true

    for (item in src) {
        if (targetString.startsWith(item)) {
            if (dynamicCanConstruct(targetString.removePrefix(item), src, memo)) {
                memo[targetString] = true
                return true
            }
        }
    }
    memo[targetString] = false
    return false
}