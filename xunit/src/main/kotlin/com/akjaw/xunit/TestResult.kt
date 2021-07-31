package com.akjaw.xunit

class TestResult() {
    private var runCount: Int = 0
    private var failedCount: Int = 0

    val summary: String
        get() = "$runCount run, $failedCount failed"

    fun testStarted() {
        runCount++
    }

    fun testFailed() {
        failedCount++
    }
}
