package com.akjaw.money

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MultiplicationTest {

    @Test
    fun `Correctly multiplies`() {
        val dollar = Money.dollar(5)

        val result = dollar.times(2)

        result shouldBe Money.dollar(10)
    }
}

