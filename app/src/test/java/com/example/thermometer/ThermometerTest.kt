package com.example.thermometer

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
class ThermometerTest {
    @Test
    fun `water freezes at 32F`(){
        assertEquals(32.0,celsiusToFahrenheit(0.0),0.001)
    }

    @Test
    fun `absolute zero blcks`(){
        assertThrows(IllegalArgumentException::class.java){
            celsiusToFahrenheit(-274.0)
        }
    }

}