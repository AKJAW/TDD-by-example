package com.akjaw.xunit

import java.lang.IllegalStateException

class BrokenTestCase(testName: String) : TestCase(testName) {

    override fun setUp() {
        throw IllegalStateException()
    }

    fun testMethod() {

    }

    fun testBrokenMethod() {
        throw IllegalAccessException()
    }
}