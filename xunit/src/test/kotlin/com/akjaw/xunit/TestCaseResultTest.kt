package com.akjaw.xunit

import io.kotest.matchers.shouldBe

class TestCaseResultTest(testName: String): TestCase(testName) {

    fun testResultSignalsSuccess() {
        val test = WasRun("testMethod")

        val result = test.run()

        result.assertResult(numberOfTests = 1, failure = 0)
    }

    fun testResultSignalsFailure() {
        val test = BrokenTestCase("testBrokenMethod")

        val result = test.run()

        result.assertResult(numberOfTests = 1, failure = 1)
    }

    fun testResultSignalsFailureWhenBreaksDuringSetUp() {
        val test = BrokenTestCase("testMethod")

        val result = test.run()

        result.assertResult(numberOfTests = 1, failure = 1)
    }
}

fun main() {
    val testSuite = TestSuite()
    testSuite.add(TestCaseResultTest("testResultSignalsSuccess"))
    testSuite.add(TestCaseResultTest("testResultSignalsFailure"))
    testSuite.add(TestCaseResultTest("testResultSignalsFailureWhenBreaksDuringSetUp"))
    testSuite.run().assertResult(numberOfTests = 3, failure = 0)
}