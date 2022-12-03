package day3

import util.readFileFromResources

val alphabetMap: Map<Char, Int> = ('a'..'z')
    .zip((1..26).toList()).toMap() + ('A'..'Z').zip((27..52).toList()).toMap()

fun findCommonCharacter(list1: List<Char>, list2: List<Char>): Char {
    val sortedList1 = list1.sorted()
    val sortedList2 = list2.sorted()

    var firstIndex = 0
    var secondIndex = 0
    while (firstIndex < sortedList1.size && secondIndex < sortedList2.size) {
        if (sortedList1[firstIndex] == sortedList2[secondIndex]) {
            return sortedList1[firstIndex]
        } else if (sortedList1[firstIndex] < sortedList2[secondIndex]) {
            firstIndex++
        } else {
            secondIndex++
        }
    }
    throw IllegalArgumentException("No common character found")
}

fun splitString(input: String): Pair<List<Char>, List<Char>> {
    val midpoint = input.length / 2
    return Pair(input.substring(0, midpoint).toList(), input.substring(midpoint).toList())
}

fun main() {
    val lines = readFileFromResources("/day3/input.txt")
    var output = 0
    lines.forEach { line ->
        val (firstHalf, secondHalf) = splitString(line)
        val commonCharacter = findCommonCharacter(firstHalf, secondHalf)
        output += alphabetMap[commonCharacter]!!
    }

    println(output)
}