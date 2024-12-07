import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val ansah = input.map {
            val lineLevels = it.split(" ").map { it.toInt() }
            val lineDiffs = lineLevels.zipWithNext().map { it.first - it.second }
            lineDiffs
        }.filter {
            it.all { it > 0 && it < 4 } || it.all { it < 0 && it > -4}
        }.size

        return ansah
    }

    fun part2(input: List<String>): Int {
        val answer = input.map {
            it.split(" ").map { it.toInt() }
        }.map { ints: List<Int> ->
            val newLists = MutableList(ints.size) { index: Int ->
                val newLine = ints.toMutableList()
                newLine.removeAt(index)
                newLine.toList().zipWithNext().map { it.first - it.second }
            }
            newLists.add(ints.zipWithNext().map { it.first - it.second })
            newLists
        }.sumOf { it:List<List<Int>> ->
            if (it.any { it.all { it in 1..3 } || it.all { it in -3 .. -1} } )
                //not redundant. weird SAM conversion https://youtrack.jetbrains.com/issue/KT-46360/Type-inference-fails-to-infer-type-for-sumOf-call-with-integer-literal-Overload-resolution-ambiguity-TypeVariableT-Int-Long
                1.toInt()
            else
                0
        }

        return answer
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(readInput("Day02Test")) == 2)
    check(part2(readInput("Day02Test")) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
