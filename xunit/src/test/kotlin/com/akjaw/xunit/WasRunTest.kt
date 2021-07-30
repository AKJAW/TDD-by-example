package com.akjaw.xunit

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe

class TestCaseTest(testName: String): TestCase(testName) {

    private lateinit var test: WasRun

    override fun setUp() {
        test = WasRun("testMethod")
    }

    fun testRunning() {
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
    TestCaseTest("testRunning").run()
    TestCaseTest("testWasSetUp").run()
    TestCaseTest("testWasTearedDown").run()
}