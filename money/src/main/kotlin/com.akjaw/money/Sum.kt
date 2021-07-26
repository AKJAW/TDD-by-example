package com.akjaw.money

class Sum(
    private val augend: Money,
    private val addend: Money
) : Expression {

    override fun calculate(bank: Bank, toCurrency: Currency): Money {
        return Money(currency = toCurrency, amount = augend.amount + addend.amount)
    }
}