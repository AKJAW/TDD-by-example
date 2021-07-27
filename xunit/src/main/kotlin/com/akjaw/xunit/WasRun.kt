package com.akjaw.xunit

class WasRun(testName: String) : TestCase(testName) {

    var wasSetUp: Boolean = false
    var wasRun: Boolean = false

    override fun setUp() {
        wasSetUp = true
    }

    fun testMethod() {
        wasRun = true
    }
}