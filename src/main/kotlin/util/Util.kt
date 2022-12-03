package util

import java.io.BufferedReader
import java.io.InputStreamReader

fun readFileFromResources(fileName: String): List<String> {
    val lines = mutableListOf<String>()
    val inputStream = object {}.javaClass.getResourceAsStream(fileName)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    var line = bufferedReader.readLine()
    while (line != null) {
        lines.add(line)
        line = bufferedReader.readLine()
    }
    return lines
}