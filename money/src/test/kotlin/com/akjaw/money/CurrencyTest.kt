package com.akjaw.money

import com.akjaw.money.Currency
import com.akjaw.money.Money
import io.kotest.assertions.asClue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class CurrencyTest {

    @Test
    fun `Dollar has the correct currency`() {
        Money.dollar(5).asClue {
            it.currency shouldBe Currency.USD
        }
    }

    @Test
    fun `Franc has the correct currency`() {
        Money.franc(5).asClue {
            it.currency shouldBe Currency.CHF
        }
    }
}
