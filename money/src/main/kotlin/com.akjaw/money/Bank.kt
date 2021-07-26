package com.akjaw.money

class Bank {

    fun reduce(expression: Expression, currency: Currency): Money {
        return expression.calculate(this, currency)
    }

    fun getExchangeRate(from: Currency, to: Currency): Int {
        return if (from == Currency.CHF && to == Currency.USD) 2 else 1
    }
}