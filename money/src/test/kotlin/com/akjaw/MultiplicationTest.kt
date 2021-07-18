package com.akjaw

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MultiplicationTest {

    @Test
    fun `Correctly multiplies dollars`() {
        val dollar = Dollar(5)

        val result = dollar.times(2)

        result shouldBe Dollar(10)
    }

    @Test
    fun `Correctly multiplies francs`() {
        val franc = Franc(5)

        val result = franc.times(2)

        result shouldBe Franc(10)
    }
}

data class Franc(val amount: Int)

fun Franc.times(multiplicator: Int): Franc {
    return Franc(amount * multiplicator)
}

data class Dollar(val amount: Int)

fun Dollar.times(multiplicator: Int): Dollar {
    return Dollar(amount * multiplicator)
}