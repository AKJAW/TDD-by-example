package com.akjaw.xunit

import io.kotest.matchers.shouldBe

class TestCaseTest(testName: String): TestCase(testName) {

    private lateinit var test: WasRun

    override fun setUp() {
        test = WasRun("testMethod")
    }

    fun testRunning() {
        test.wasRun shouldBe false

        test.run()

        test.wasRun shouldBe true
    }

    fun testWasSetUp() {
        test.wasSetUp shouldBe false

        test.run()

        test.wasSetUp shouldBe true
    }
}

fun main() {
    TestCaseTest("testRunning").run()
    TestCaseTest("testWasSetUp").run()
}