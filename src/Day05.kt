fun main() {
    fun part1(input: List<String>): Int {
        val separatorIndex = input.mapIndexedNotNull { index, s ->
            if (s.trim().isEmpty()) {
                return@mapIndexedNotNull index
            } else {
                return@mapIndexedNotNull null
            }
        }.first()

        val rules = input.take(separatorIndex)
            .map { val(f,t) = it.split("|").map{ it.toInt() }; f to t }

        val messages = input.drop(separatorIndex+1)
            .map { it.split(",").map { it.toInt() }}

        val result = messages.filter { message ->
            if (
                rules.any { rule ->
                    val firstIndex = message.indexOf(rule.first)
                    val secondIndex = message.indexOf(rule.second)
                    if (firstIndex != -1 && secondIndex != -1) {
                        if (firstIndex > secondIndex) {
                            return@any true
                        }
                    }
                    return@any false
                }) {
                return@filter false
            }
            true
        }.sumOf {
            it[it.size.floorDiv(2)]
        }

        return result
    }

    fun part2(input: List<String>): Int {
        return input.size
    }


    // read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day05Test")
    check(part1(testInput) == 143)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}
