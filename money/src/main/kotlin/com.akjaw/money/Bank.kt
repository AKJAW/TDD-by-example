package com.akjaw.money

private typealias CurrencyPair = Pair<Currency, Currency>

class Bank {

    private val rates = mutableMapOf<CurrencyPair, Int>()

    fun addRate(from: Currency, to: Currency, rate: Int) {
        rates[CurrencyPair(from, to)] = rate
    }

    fun reduce(expression: Expression, currency: Currency): Expression {
        return expression.calculate(this, currency)
    }

    fun getExchangeRate(from: Currency, to: Currency): Int {
        return rates[CurrencyPair(from, to)] ?: 1
    }
}
