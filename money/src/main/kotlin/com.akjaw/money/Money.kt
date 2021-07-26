package com.akjaw.money

data class Money(
    val currency: Currency,
    val amount: Int
) : Expression {

    companion object {

        fun dollar(amount: Int): Money =
            Money(currency = Currency.USD, amount = amount)

        fun franc(amount: Int): Money =
            Money(currency = Currency.CHF, amount = amount)
    }

    fun times(multiplicator: Int): Money {
        return Money(currency = currency, amount = amount * multiplicator)
    }

    fun add(money: Money): Expression {
        return Sum(this, money)
    }

    override fun calculate(bank: Bank, toCurrency: Currency): Money {
        val exchangeRate = bank.getExchangeRate(this.currency, toCurrency)
        return this.copy(amount = this.amount * exchangeRate, currency = toCurrency)
    }
}
