package com.akjaw.money

class Sum(
    private val augend: Expression,
    private val addend: Expression
) : Expression {

    override fun calculate(bank: Bank, toCurrency: Currency): Money {
        val exchangedAugendAmount = exchange(bank, source = augend, toCurrency = toCurrency)
        val exchangedAddendAmount = exchange(bank, source = addend, toCurrency = toCurrency)
        return Money(
            currency = toCurrency,
            amount = exchangedAugendAmount + exchangedAddendAmount
        )
    }

    override fun add(addend: Expression): Expression {
        return Sum(this, addend)
    }

    override fun times(multiplicator: Int): Expression {
        return Sum(augend.times(multiplicator), addend.times(multiplicator))
    }

    private fun exchange(bank: Bank, source: Expression, toCurrency: Currency) =
        source.calculate(bank, toCurrency).amount
}