package com.akjaw.xunit

import io.kotest.matchers.shouldBe

class TestSuiteTest(testName: String): TestCase(testName) {

    fun testSuitePassesAllTests() {
        val suite = TestSuite()
        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testMethod"))

        val result = suite.run()

        result.assertResult(numberOfTests = 3, failure = 0)
    }

    fun testSuiteFailsAllTests() {
        val suite = TestSuite()
        suite.add(BrokenTestCase("testBrokenMethod"))
        suite.add(BrokenTestCase("testBrokenMethod"))

        val result = suite.run()

        result.assertResult(numberOfTests = 2, failure = 2)
    }

    fun testSuitePassesPartiallyTests() {
        val suite = TestSuite()
        suite.add(WasRun("testMethod"))
        suite.add(BrokenTestCase("testBrokenMethod"))

        val result = suite.run()

        result.assertResult(numberOfTests = 2, failure = 1)
    }
}

fun main() {
    TestSuiteTest("testSuitePassesAllTests").run().assertResult(numberOfTests = 1, failure = 0)
    TestSuiteTest("testSuiteFailsAllTests").run().assertResult(numberOfTests = 1, failure = 0)
    TestSuiteTest("testSuitePassesPartiallyTests").run().assertResult(numberOfTests = 1, failure = 0)
}

fun TestResult.assertResult(numberOfTests: Int, failure: Int) {
    summary shouldBe "$numberOfTests run, $failure failed"
}