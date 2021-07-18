package com.akjaw

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

abstract class Money {

    companion object {

        fun dollar(amount: Int): Money =
            Dollar(amount, Currency.USD)

        fun franc(amount: Int): Money =
            Franc(amount, Currency.CHF)
    }

    abstract val currency: Currency

    abstract val amount: Int

    abstract fun times(multiplicator: Int): Money

    override fun equals(other: Any?): Boolean {
        val money = other as? Money
        return this.javaClass == other?.javaClass &&
                money?.amount == this.amount
    }

    override fun hashCode(): Int {
        return amount
    }

    override fun toString(): String {
        return "${this.javaClass}(amount=$amount)"
    }

    private class Franc(override val amount: Int, override val currency: Currency) : Money() {

        override fun times(multiplicator: Int): Money {
            return Franc(amount * multiplicator, currency)
        }
    }

    private class Dollar(override val amount: Int, override val currency: Currency) : Money() {

        override fun times(multiplicator: Int): Money {
            return Dollar(amount * multiplicator, currency)
        }
    }
}

enum class Currency {
    USD,
    CHF
}
