package com.akjaw.money

class Bank {

    fun reduce(expression: Expression, currency: Currency): Money {
        return expression.calculate(currency)
    }
}