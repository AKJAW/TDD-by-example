package com.akjaw.xunit

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class TestCaseTest(testName: String): TestCase(testName) {

    fun testRunning() {
        val test = WasRun("testMethod")
        test.wasRun shouldBe false

        test.run()

        test.wasRun shouldBe true
    }
}

fun main() {
    TestCaseTest("testRunning").testRunning()
}