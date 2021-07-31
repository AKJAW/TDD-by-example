package com.akjaw.xunit

class TestSuite {
    private val testCases = mutableListOf<TestCase>()

    fun add(testCase: TestCase) {
        testCases.add(testCase)
    }

    fun run(): TestResult {
        val result = TestResult()
        testCases.forEach { testCase ->
            testCase.run(result)
        }
        return result
    }
}
