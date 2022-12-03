package day1

import util.readFileFromResources
import kotlin.math.max

fun main() {
    val lines = readFileFromResources("/day1/input.txt")
    var max = 0
    var current = 0
    lines.forEach { line ->
        if (line.isBlank()) {
            max = max(max, current)
            current = 0
        } else {
            current += line.toInt()
        }
    }

    println(max)
}