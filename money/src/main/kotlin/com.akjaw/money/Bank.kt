package com.akjaw.money

class Bank {

    fun calculate(expression: Expression, currency: Currency): Money {
        return expression.calculate(currency)
    }
}