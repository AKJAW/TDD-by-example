package com.akjaw.xunit

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class WasRunTest {

    @Test
    fun `Correctly runs`() {
        val test = WasRun("testMethod")

        test.run()

        test.wasRun shouldBe true
    }
}