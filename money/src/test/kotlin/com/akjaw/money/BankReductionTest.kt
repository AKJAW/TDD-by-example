package com.akjaw.money

import io.kotest.assertions.asClue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class BankReductionTest {

    private val bank: Bank = Bank()

    @Test
    fun `Sum reduction with the same currency works`() {
        val dollar = Money.dollar(5)
        val expression = dollar.add(Money.dollar(5))

        val result = bank.reduce(expression, Currency.USD)

        result.asClue {
            it shouldBe Money.dollar(10)
        }
    }

    @Test
    fun `Money reduction works`() {
        val dollar = Money.dollar(3)

        val result = bank.reduce(dollar, Currency.USD)

        result.asClue {
            it shouldBe Money.dollar(3)
        }
    }
}

