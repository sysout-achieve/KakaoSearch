package com.gun.kakaosearch

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun functionTest() {
        kotlinFun(1)
        kotlinFun(0)
        val nameAge : (String,Int) -> String= {name :String , age : Int ->
            "My name is ${name} I'm ${age}"
        }
        println(nameAge("Geon", 30))
    }

    fun kotlinFun(score: Int) {
        when (score) {
            0 -> println("this is 0")
            else -> println(score)
        }
    }


}
