package com.akjaw.xunit

open class TestCase(private val testName: String) {

    open fun setUp() { /* Empty */ }

    open fun tearDown() { /* Empty */ }

    fun run(): TestResult {
        val testResult = TestResult()
        testResult.testStarted()
        setUp()
        try {
            val testMethod = getMethod(testName)
            testMethod!!.invoke(this)
        } catch (e: Throwable) {
            testResult.testFailed()
        }
        tearDown()
        return testResult
    }

    private fun getMethod(methodName: String) =
        this::class.java.methods.find { it.name == methodName }
}