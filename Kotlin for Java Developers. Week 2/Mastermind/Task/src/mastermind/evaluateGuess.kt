package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int) {
    private val codeLength = 4
    fun isComplete(): Boolean = rightPosition == codeLength
}

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPosition = secret.zip(guess).count { it.first == it.second }

    val commonPosition = ('A'..'F').sumBy { ch -> minOf(secret.count { it == ch }, guess.count { it == ch }) }
    return Evaluation(rightPosition, commonPosition - rightPosition)
}
