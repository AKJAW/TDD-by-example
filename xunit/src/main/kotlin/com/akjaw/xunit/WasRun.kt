package com.akjaw.xunit

class WasRun(private val testName: String) {

    var wasRun: Boolean = false

    fun testMethod() {
        wasRun = true
    }

    fun run() {
        val currentClass = this::class.java.methods.find { it.name == testName }
        currentClass!!.invoke(this)
    }
}