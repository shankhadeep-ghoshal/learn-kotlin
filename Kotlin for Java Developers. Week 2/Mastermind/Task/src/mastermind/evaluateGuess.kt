package mastermind

import kotlin.math.min

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val mappedSecret = convertToMap(secret)
    val mappedGuess = convertToMap(guess)

    var wrongPos = 0
    var rightPos = 0
    mappedSecret.filter { (key, _) -> mappedGuess.containsKey(key) }.forEach {(key, value) ->
        run {
            val guessEntry = mappedGuess[key]
            val commonIndices = guessEntry?.intersect(value)
            rightPos += commonIndices?.size ?: 0
            value.minus(commonIndices!!)
            guessEntry.minus(commonIndices)
            wrongPos += min(value.minus(commonIndices).size, guessEntry.minus(commonIndices).size)
        }
    }

    return Evaluation(rightPos,wrongPos)
}

fun convertToMap(str: String): MutableMap<Char, MutableSet<Int>> {
    val map = HashMap<Char, MutableSet<Int>>()
    for (i in str.indices) {
        if (map.containsKey(str[i])) {
            map[str[i]]?.add(i)
        } else {
            map[str[i]] = mutableSetOf(i)
        }
    }

    return map
}
