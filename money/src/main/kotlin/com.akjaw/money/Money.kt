package com.akjaw.money

data class Money(
    val currency: Currency,
    val amount: Int
) {

    companion object {

        fun dollar(amount: Int): Money =
            Money(currency = Currency.USD, amount = amount)

        fun franc(amount: Int): Money =
            Money(currency = Currency.CHF, amount = amount)
    }

    fun times(multiplicator: Int): Money {
        return Money(currency = currency, amount = amount * multiplicator)
    }

    fun add(dollar: Money): Expression {
        return Sum(this, dollar)
    }
}
