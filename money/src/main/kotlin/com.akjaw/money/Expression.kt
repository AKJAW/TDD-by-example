package com.akjaw.money

interface Expression {

    fun calculate(currency: Currency): Money
}
