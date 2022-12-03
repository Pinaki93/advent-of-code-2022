package day1

import util.then
import util.otherwise
import util.otherwiseOrIf
import util.readFileFromResources

fun main() {
    val lines = readFileFromResources("/day1/input.txt")
    val top3 = mutableListOf(-1, -1, -1)
    var current = 0
    lines.forEach { line ->
        line.isNotBlank()
            .then { current += line.toInt() }
            .otherwiseOrIf(lines.last() == line) {
                top3.first()
                    .takeIf { it < current }
                    ?.run {
                        top3[0] = current
                        top3.sort()
                    }
                current = 0
            }
    }
    println(top3)
    println(top3.filter { it >= 0 }.sum())
}