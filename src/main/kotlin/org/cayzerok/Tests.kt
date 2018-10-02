package org.cayzerok

suspend fun GuestTest() {
    println("Guest GetUser call with invalid email:")
    try {
        GetUser("invalidemail")
        throw Exception("EmailValidEmail")
    } catch (exc: UserDataException) {
        println("OK - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest GetUser call with wrong email:")
    try {
        GetUser("wrong@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest GetUser call with banned email:")
    try {
        GetUser("banned@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest GetUser call with deleted email:")
    try {
        GetUser("deleted@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest GetUser call with valid email:")
    try {
        GetUser("user@email.ru")
        println("OK")
    } catch (exc: UserDataException) {
        println("WRONG - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest GetUserList call:")
    try {
        GetUserList()
        println("OK")
    } catch (exc: UserListException) {
        println("WRONG - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Bad page Guest GetUserList call:")
    try {
        GetUserList(-1, 2).forEach { println(it) }
        println("WRONG")
    } catch (exc: UserListException) {
        println("OK - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Bad limit Guest GetUserList call:")
    try {
        GetUserList(1, -241).forEach { println(it) }
        println("WRONG")
    } catch (exc: UserListException) {
        println("OK - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest Ban call:")
    try {
        Ban(1)
        println("WRONG")
    } catch (exc: BanException) {
        println("OK - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest Delete call:")
    try {
        DeleteMe()
        println("WRONG")
    } catch (exc: DeleteException) {
        println("OK - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest UpdateUser call:")
    try {
        UpdateUser(1, listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest UpdateProfile call:")
    try {
        UpdateProfile(listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " + exc.message)
    }
    println("------------------------------------------------------------------------------")
}
suspend fun RegLogTest() {
    println("Invalid email registration call:")
    try {
        Register("eeads","USERNAME","HASHEDPAS")
        println("WRONG")
    } catch (exc:RegisterException) {println("OK - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("Invalid username registration call:")
    try {
        Register("example@email.ru","1","HASHEDPAS")
        println("WRONG")
    } catch (exc:RegisterException) {println("OK - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("Invalid password registration call:")
    try {
        Register("example@email.ru","Gibbdara","1")
        println("WRONG")
    } catch (exc:RegisterException) {println("OK - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("Valid registration call:")
    try {
        Register("example@email.ru","Gibbdara","123456")
        println("OK")
    } catch (exc:RegisterException) {println("WRONG - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("Login with wrong email:")
    try {
        Login("wrong@email.ru","12345")
        println("WRONG")
    } catch (exc:LoginException) {println("OK - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("Login with wrong password:")
    try {
        Login("user@email.ru","1")
        println("WRONG")
    } catch (exc:LoginException) {println("OK - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("Invalid email login:")
    try {
        Login("rurvrbtrrrf","12345")
        println("WRONG")
    } catch (exc:LoginException) { println("OK - "+exc.message) }
    println("------------------------------------------------------------------------------")
    println("Banned login:")
    try {
        Login("banned@emai.ru","12345")
        println("WRONG")
    } catch (exc:LoginException) { println("OK - "+exc.message) }
    println("------------------------------------------------------------------------------")
    println("Deleted login:")
    try {
        Login("deleted@emai.ru","12345")
        println("WRONG")
    } catch (exc:LoginException) { println("OK - "+exc.message) }
    println("------------------------------------------------------------------------------")
}