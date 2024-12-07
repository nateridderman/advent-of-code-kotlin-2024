fun main() {
    fun part1(input: List<String>): Int {
        val rules = input.takeWhile { it.trim().isEmpty() }
            .map { val(f,t) = it.split("|").map{ it.toInt() }; f to t }

        val messages = input.dropWhile { it.trim().isEmpty() }
            .map { it.split(",").map { it.toInt() }}
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("Day01Test.txt")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
