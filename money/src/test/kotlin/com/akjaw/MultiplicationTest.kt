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

abstract class Money {

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
}

class Franc(override val amount: Int) : Money() {

    override fun times(multiplicator: Int): Money {
        return Franc(amount * multiplicator)
    }
}

class Dollar(override val amount: Int) : Money() {

    override fun times(multiplicator: Int): Money {
        return Dollar(amount * multiplicator)
    }
}
