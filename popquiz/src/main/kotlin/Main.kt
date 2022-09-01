fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = "" // from example and not to be changed
    s1.isEmptyOrNull() eq true
    s2.isEmptyOrNull() eq true

    val s3 = "   "
    s3.isEmptyOrNull() eq false
}

private infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}

private fun String?.isEmptyOrNull(): Boolean {
    return this == null || this.isEmpty()
}
