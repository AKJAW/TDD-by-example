package com.akjaw.money

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MultiplicationTest {

    @Test
    fun `Correctly multiplies money`() {
        val dollar = Money.dollar(5)

        val result = dollar.times(2)

        result shouldBe Money.dollar(10)
    }

    @Test
    fun `Correctly multiplies sum`() {
        val bank = Bank()
        bank.addRate(Currency.CHF, Currency.USD, 2)
        val dollar = Money.dollar(3)
        val franc = Money.franc(3)
        val sum = Sum(dollar, franc)

        val result = sum.times(2)

        val reduced = bank.reduce(result, Currency.USD)
        reduced shouldBe Money.dollar(18)
    }
}

