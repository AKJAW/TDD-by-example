package com.akjaw.xunit

import io.kotest.matchers.shouldBe

class TestCaseResultTest(testName: String): TestCase(testName) {

    fun testResultSignalsSuccess() {
        val test = WasRun("testMethod")

        val result = test.run()

        result.summary shouldBe "1 run, 0 failed"
    }

    fun testResultSignalsFailure() {
        val test = BrokenTestCase("testBrokenMethod")

        val result = test.run()

        result.summary shouldBe "1 run, 1 failed"
    }

    fun testResultSignalsFailureWhenBreaksDuringSetUp() {
        val test = BrokenTestCase("testMethod")

        val result = test.run()

        result.summary shouldBe "1 run, 1 failed"
    }
}

fun main() {
    TestCaseResultTest("testResultSignalsSuccess").run().summary shouldBe "1 run, 0 failed"
    TestCaseResultTest("testResultSignalsFailure").run().summary shouldBe "1 run, 0 failed"
    TestCaseResultTest("testResultSignalsFailureWhenBreaksDuringSetUp").run().summary shouldBe "1 run, 0 failed"
}