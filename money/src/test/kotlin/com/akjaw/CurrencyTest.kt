package com.akjaw

import io.kotest.assertions.asClue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
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
