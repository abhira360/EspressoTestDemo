package com.example.emptytesting

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun assertEqualsTest() {
        val expected = 9

        assertEquals( "actual value is not $expected", expected, 9+0)
    }

    @Test
    fun assertNotEqualsTest() {

        val ob1 = "object"
        val ob2 = "objct"
        assertNotEquals("actual and unexpected are equal", ob1, ob2)

    }

    @Test
    fun assertTrueTest() {

        val s = "a"
        val s2 = "a"
        assertTrue("condition is not true",s==s2)
    }



    @Test
    fun assertFalseTest() {

        val s = "a"
        val s2 = "a"
        assertFalse("condition is true",s!=s2)
    }

    @Test
    fun assertNotNullTest() {

        val test: String? = "null"
        assertNotNull("$test object is null",test)

    }

    @Test
    fun assertNullTest() {

        val test: String? = null
        assertNull("$test object is not null",test)

    }

    @Test
    fun assertSameTest() {
        val ob1 = "3"
        val ob2 = "3"
        assertSame("objects are not same",ob1,ob2)
    }

    @Test
    fun assertNotSameTest() {
        val ob1 = 0
        val ob2 = 10
        assertNotSame("objects are same",ob1,ob2)
    }

    @Test
    fun assertArrayEquals() {

        val expected = arrayOf("a", "b", "c")
        val result = arrayOf("a", "b", "c")
        assertArrayEquals(expected,result)
    }

}
