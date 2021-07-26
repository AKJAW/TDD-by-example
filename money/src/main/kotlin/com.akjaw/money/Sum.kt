package com.akjaw.money

class Sum(
    private val augend: Money,
    private val addend: Money
) : Expression {

    override fun calculate(bank: Bank, toCurrency: Currency): Money {
        val exchangedAugendAmount = exchange(bank, source = augend, toCurrency = toCurrency)
        val exchangedAddendAmount = exchange(bank, source = addend, toCurrency = toCurrency)
        return Money(
            currency = toCurrency,
            amount = exchangedAugendAmount + exchangedAddendAmount
        )
    }

    private fun exchange(bank: Bank, source: Money, toCurrency: Currency) =
        source.amount * bank.getExchangeRate(source.currency, toCurrency)
}