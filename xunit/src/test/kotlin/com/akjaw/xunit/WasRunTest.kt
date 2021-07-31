package com.akjaw.xunit

import io.kotest.matchers.shouldBe

class TestCaseRunningTest(testName: String): TestCase(testName) {

    private lateinit var test: WasRun

    override fun setUp() {
        test = WasRun("testMethod")
    }

    fun testRunningBetweenSetUpAndTearDown() {
        test.run()

        test.functionsCalled[1] shouldBe "testMethod"
    }

    fun testWasSetUp() {
        test.run()

        test.functionsCalled.first() shouldBe "setUp"
    }

    fun testWasTearedDown() {
        test.run()

        test.functionsCalled.last() shouldBe "tearDown"
    }
}

fun main() {
    val testSuite = TestSuite()
    testSuite.add(TestCaseRunningTest("testRunningBetweenSetUpAndTearDown"))
    testSuite.add(TestCaseRunningTest("testWasSetUp"))
    testSuite.add(TestCaseRunningTest("testWasTearedDown"))
    testSuite.run().assertResult(numberOfTests = 3, failure = 0)
}

