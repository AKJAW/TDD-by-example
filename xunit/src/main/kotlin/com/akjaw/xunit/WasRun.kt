package com.akjaw.xunit

class WasRun(testName: String) : TestCase(testName) {

    var wasRun: Boolean = false

    fun testMethod() {
        wasRun = true
    }
}