import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val listOfPairs = input.map {
            it.split("   ").map { it.trim().toInt() }
        }
        val leftSorted = listOfPairs.map { it[0] }.sorted()
        val rightSorted = listOfPairs.map { it[1] }.sorted()
        val sumOfDiffs = leftSorted.mapIndexed { index, i ->
            abs(rightSorted[index] - i)
        }.sum()

        return sumOfDiffs
    }

    fun part2(input: List<String>): Int {
        val listOfPairs = input.map {
            it.split("   ").map { it.trim().toInt() }
        }
        val leftSorted = listOfPairs.map { it[0] }.sorted().groupBy { it }
        val rightSorted = listOfPairs.map { it[1] }.sorted().groupBy { it }

        val answer = leftSorted.mapNotNull {
            val right = rightSorted[it.key]?.size
            right?.times(it.key)?.times(it.value.size)
        }.sum()

        println(answer)
        return answer
    }

    // Test if implementation meets criteria from the description, like:
    check(part2(readInput("Day01Test")) == 31)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
