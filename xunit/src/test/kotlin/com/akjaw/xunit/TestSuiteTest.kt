package com.akjaw.xunit

import io.kotest.matchers.shouldBe

class TestSuiteTest(testName: String): TestCase(testName) {

    fun testSuitePassesAllTests() {
        val suite = TestSuite()
        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testMethod"))

        val result = suite.run()

        result.summary shouldBe "3 run, 0 failed"
    }

    fun testSuiteFailsAllTests() {
        val suite = TestSuite()
        suite.add(BrokenTestCase("testBrokenMethod"))
        suite.add(BrokenTestCase("testBrokenMethod"))

        val result = suite.run()

        result.summary shouldBe "2 run, 2 failed"
    }

    fun testSuitePassesPartiallyTests() {
        val suite = TestSuite()
        suite.add(WasRun("testMethod"))
        suite.add(BrokenTestCase("testBrokenMethod"))

        val result = suite.run()

        result.summary shouldBe "2 run, 1 failed"
    }
}

fun main() {
    TestSuiteTest("testSuitePassesAllTests").run().summary shouldBe "1 run, 0 failed"
    TestSuiteTest("testSuiteFailsAllTests").run().summary shouldBe "1 run, 0 failed"
    TestSuiteTest("testSuitePassesPartiallyTests").run().summary shouldBe "1 run, 0 failed"
}