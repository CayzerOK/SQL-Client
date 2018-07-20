package com.cayzerok

import org.cayzerok.SQLInletAPI
import org.junit.Assert.assertEquals
import org.junit.Test

class SQLInletApiTest {
    @Test fun testMyLanguage() {
        assertEquals("Kotlin", SQLInletAPI().kotlinLanguage().name)
        assertEquals(10, SQLInletAPI().kotlinLanguage().hotness)
    }
}