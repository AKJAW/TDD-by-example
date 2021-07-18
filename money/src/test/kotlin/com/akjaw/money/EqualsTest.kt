package com.akjaw.money

import com.akjaw.money.Money
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class EqualsTest {

    @Test
    fun `Two dollars with the same value are equal`() {
        Money.dollar(5) shouldBe Money.dollar(5)
    }

    @Test
    fun `Two dollars with the different value are not equal`() {
        Money.dollar(10) shouldNotBe Money.dollar(5)
    }

    @Test
    fun `Two francs with the same value are equal`() {
        Money.franc(5) shouldBe Money.franc(5)
    }

    @Test
    fun `Two francs with the different value are not equal`() {
        Money.franc(10) shouldNotBe Money.franc(5)
    }

    @Test
    fun `A dollar and a franc with the same value are not equal`() {
        Money.dollar(10) shouldNotBe Money.franc(10)
    }

    @Test
    fun `A dollar and a franc with a different value are not equal`() {
        Money.dollar(5) shouldNotBe Money.franc(10)
    }
}
