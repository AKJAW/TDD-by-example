package com.akjaw

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class EqualsTest {

    @Test
    fun `Two dollars with the same value are equal`() {
        Dollar(5) shouldBe Dollar(5)
    }

    @Test
    fun `Two dollars with the different value are not equal`() {
        Dollar(10) shouldNotBe Dollar(5)
    }

    @Test
    fun `Two francs with the same value are equal`() {
        Franc(5) shouldBe Franc(5)
    }

    @Test
    fun `Two francs with the different value are not equal`() {
        Franc(10) shouldNotBe Franc(5)
    }
}
