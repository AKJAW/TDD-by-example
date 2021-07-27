package com.akjaw.xunit

open class TestCase(private val testName: String) {

    fun run() {
        val currentClass = this::class.java.methods.find { it.name == testName }
        currentClass!!.invoke(this)
    }
}