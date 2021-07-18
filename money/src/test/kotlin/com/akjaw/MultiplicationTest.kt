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
}

data class Dollar(val amount: Int)

fun Dollar.times(multiplicator: Int): Dollar {
    return Dollar(amount * multiplicator)
}