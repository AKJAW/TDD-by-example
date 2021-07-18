package com.akjaw.money

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