package com.akjaw.money

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MultiplicationTest {

    @Test
    fun `Correctly multiplies dollars`() {
        val dollar = Money.dollar(5)

        val result = dollar.times(2)

        result shouldBe Money.dollar(10)
    }

    @Test
    fun `Correctly multiplies francs`() {
        val franc = Money.franc(5)

        val result = franc.times(2)

        result shouldBe Money.franc(10)
    }
}

