import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Long {
        return input.sumOf {
            var rawInput = it
            val matches = mutableListOf<Long>()
            while (true) {
                val regex = Regex("mul\\((\\d+),(\\d+)\\)")
                val match = regex.find(rawInput)
                if (match != null) {
                    val ( num1, num2) = match.destructured
//                    print("( $num1, $num2 ) ")
                    rawInput = rawInput.drop(match.range.last)
                    matches.add(num1.toLong() * num2.toLong())
                } else {
                    break
                }
            }
            matches.sum()
        }
    }

    fun part2(input: List<String>): Long {
        val matches = mutableListOf<Long>()
        var enabled = true
        input.forEach {
            var rawInput = it
            while (true) {
                val regex = Regex("(mul\\((\\d+),(\\d+)\\))|(don't\\(\\))|(do\\(\\))")
                val match = regex.find(rawInput)
                if (match != null) {
                    if (match.value == "do()") {
                        enabled = true
                    } else if (match.value == "don't()") {
                        enabled = false
                    } else {
                        val ( match, num1, num2) = match.destructured
//                        print("( $num1, $num2 ) ")
                        if (enabled) {
                            matches.add(num1.toLong() * num2.toLong())
                        }
                    }
                    rawInput = rawInput.drop(match.range.last)
                } else {
                    break
                }
            }
            matches.sum()
        }
        return matches.sum()
    }


    // Test if implementation meets criteria from the description, like:
    check(part1(readInput("Day03Test")) == 161L)
//    check(part2(readInput("Day02Test")) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
