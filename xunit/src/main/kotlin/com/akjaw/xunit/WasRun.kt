package com.akjaw.xunit

class WasRun(testName: String) : TestCase(testName) {

    val functionsCalled: MutableList<String> = mutableListOf()

    override fun setUp() {
        functionsCalled.add("setUp")
    }

    override fun tearDown() {
        functionsCalled.add("tearDown")
    }

    fun testMethod() {
        functionsCalled.add("testMethod")
    }

    fun testBrokenMethod() {
        functionsCalled.add("testBrokenMethod")
        throw IllegalAccessException()
    }
}