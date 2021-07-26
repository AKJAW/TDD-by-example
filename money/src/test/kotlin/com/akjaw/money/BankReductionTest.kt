package com.akjaw.money

import io.kotest.assertions.asClue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class BankReductionTest {

    private val bank: Bank = Bank()

    @Test
    fun `Sum reduction with the same currency works`() {
        val dollar = Money.dollar(5)
        val sum = dollar.add(Money.dollar(5))

        val result = bank.reduce(sum, Currency.USD)

        result.asClue {
            it shouldBe Money.dollar(10)
        }
    }

    @Test
    fun `Money reduction for the same currency works`() {
        val dollar = Money.dollar(3)

        val result = bank.reduce(dollar, Currency.USD)

        result.asClue {
            it shouldBe Money.dollar(3)
        }
    }

    @Test
    fun `Money reduction for different currency with a 2-1 rate works`() {
        givenExchangeRate(usd = 2, chf = 1)
        val franc = Money.franc(3)

        val result = bank.reduce(franc, Currency.USD)

        result.asClue {
            it shouldBe Money.dollar(6)
        }
    }

    private fun givenExchangeRate(usd: Int, chf: Int) {
        /* Placeholder */
    }
}

