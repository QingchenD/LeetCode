package mykotlin

import java.util.HashMap
import java.util.concurrent.atomic.AtomicLong

class KotLinTestMain {
    private val name = "KotLinTestMain"
    fun run() {
        val c = AtomicLong()

        val i = 5.5
        when(i) {

            in 4..6  -> println("i in 4..6 ")
            in 1.0..10.0 -> println("i in 1..10")
        }

        if (Double.NaN >= Double.MAX_VALUE);

        if (-0.0f < 0.0f) {
            println(" -0.0 < 0.0")
        } else {
            println(" -0.0 >= 0.0")
        }

        val map = HashMap<String, Any>()
        map["1"] = "hi"
        val o = (map as java.util.Map<String, Any>).getOrDefault("1", "null")
        if (o is String) {
            println(o.toString())
        }


        val numbers = setOf("one", "two", "three")
        println(numbers union setOf("four", "five"))
        println(setOf("four", "five") union numbers)

    }

    inner class Test {
        private val value = 1
        private val copyName = name
    }
}