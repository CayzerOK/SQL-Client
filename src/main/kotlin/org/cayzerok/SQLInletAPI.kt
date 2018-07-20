package org.cayzerok

data class Language(val name: String, val hotness: Int)

class SQLInletAPI {
    fun kotlinLanguage() = Language("Kotlin", 10)
}