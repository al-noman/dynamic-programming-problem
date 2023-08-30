package personal

fun main() {
    var result = arrayOf<Array<String>>()
    val tmp = arrayOf(arrayOf("purpe", "le"), arrayOf("pu", "rple"))
    result = result.plus(tmp)
    println(result.contentDeepToString())


    val result2 = simpleAllConstruct("purple", arrayOf("purp", "p", "ur", "le", "purpl"))
    //println(simpleAllConstruct("purple", arrayOf("purp", "p", "ur", "le", "purpl")).contentDeepToString())
    //println(simpleAllConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd")))
    //println(simpleAllConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    //println(simpleAllConstruct("enterapotentpot", arrayOf("a", "p", "ent", "enter", "ot", "o", "t")))
    //println(simpleAllConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf("ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")))
}

fun simpleAllConstruct(targetString: String, src: Array<String>): Array<Array<String>>? {
    if (targetString.isEmpty()) return arrayOf()

    var result: Array<Array<String>>? = null
    for (item in src) {
        if (targetString.startsWith(item)) {
            var subResult = simpleAllConstruct(targetString.removePrefix(item), src)
            println("first " + result.contentDeepToString())
            if (subResult != null) {
                result = arrayOf()
                if (subResult.isEmpty()) {
                    result = result.plus(arrayOf(item))
                } else {
                    println("subresult " + subResult.contentDeepToString() + " item: $item")
                    for (i in subResult.indices) {
                        subResult[i] = subResult[i].plus(item)
                        result = result?.plus(subResult[i])
                    }
                    //println("subresult " + subResult.contentDeepToString())
                    //result = result.plus(subResult)
                }
            }
            println("result " + result.contentDeepToString())
        }
    }
    return result
}