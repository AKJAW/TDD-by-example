package com.akjaw.money

interface Expression {

    fun calculate(bank: Bank, toCurrency: Currency): Money

    fun add(addend: Expression): Expression

    fun times(multiplicator: Int): Expression
}
