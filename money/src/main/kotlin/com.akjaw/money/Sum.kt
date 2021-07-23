package com.akjaw.money

class Sum(
    private val augend: Money,
    private val addend: Money
) : Expression {

    override fun calculate(currency: Currency): Money {
        return Money(currency = currency, amount = augend.amount + addend.amount)
    }
}