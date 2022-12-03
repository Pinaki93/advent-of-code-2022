package day3

import util.readFileFromResources

private fun findCommonCharacter(s1: String, s2: String, s3: String): Char {
    val firstGroup = s1.toCharArray().toSortedSet()
    val secondGroup = s2.toCharArray().toSortedSet()
    val thirdGroup = s3.toCharArray().toSortedSet()
    return firstGroup.intersect(secondGroup).intersect(thirdGroup).first()
}

fun main() {
    val lines = readFileFromResources("/day3/input.txt")
    val groups = mutableListOf<List<String>>()
    val currentGroup = mutableListOf<String>()
    lines.forEachIndexed { index, s ->
        if (index > 0 && index % 3 == 0) {
            groups.add(currentGroup.toList())
            currentGroup.clear()
        }

        currentGroup.add(s)
    }

    if (currentGroup.isNotEmpty()) {
        groups.add(currentGroup)
    }

    var output = 0
    groups.forEach {
        val commonCharacter = findCommonCharacter(it[0], it[1], it[2])
        output += alphabetMap[commonCharacter]!!
    }

    println(output)
}