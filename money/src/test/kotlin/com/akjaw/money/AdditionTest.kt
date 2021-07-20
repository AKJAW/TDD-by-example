package com.akjaw.money

import io.kotest.assertions.asClue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class AdditionTest {

    @Test
    fun `Addition with the same currency works`() {
        val dollar = Money.dollar(5)

        val result = dollar.add(Money.dollar(5))

        result.asClue {
            it shouldBe Money.dollar(10)
        }
    }
}
