package com.akjaw.xunit

open class TestCase(private val testName: String) {

    open fun setUp() { /* Empty */ }

    open fun tearDown() { /* Empty */ }

    fun run() {
        setUp()
        val testMethod = getMethod(testName)
        testMethod!!.invoke(this)
        tearDown()
    }

    private fun getMethod(methodName: String) =
        this::class.java.methods.find { it.name == methodName }
}