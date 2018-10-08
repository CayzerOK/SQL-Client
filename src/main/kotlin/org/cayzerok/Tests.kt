package org.cayzerok

fun GuestTest() {
    println("Guest GetUser call with invalid email:")
    try {
        GetUser("invalidemail")
        throw Exception("EmailValidEmail")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+ exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest GetUser call with wrong email:")
    try {
        GetUser("wrong@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest GetUser call with banned email:")
    try {
        GetUser("banned@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest GetUser call with deleted email:")
    try {
        GetUser("deleted@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest GetUser call with valid email:")
    try {
        GetUser("user@email.ru")
        println("OK")
    } catch (exc: UserDataException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest GetUserList call:")
    try {
        GetUserList()
        println("OK")
    } catch (exc: UserListException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Bad page Guest GetUserList call:")
    try {
        GetUserList(-1, 2).forEach { println(it) }
        println("WRONG")
    } catch (exc: UserListException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Bad limit Guest GetUserList call:")
    try {
        GetUserList(1, -241).forEach { println(it) }
        println("WRONG")
    } catch (exc: UserListException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest Ban call:")
    try {
        Ban(1)
        println("WRONG")
    } catch (exc: BanException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest Unban call:")
    try {
        Unban(1)
        println("WRONG")
    } catch (exc: BanException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest Mute call:")
    try {
        Mute(1)
        println("WRONG")
    } catch (exc: MuteException) {
        println("OK - " + exc.code+" "+ exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest Mute call:")
    try {
        Unmute(1)
        println("WRONG")
    } catch (exc: MuteException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest Delete call:")
    try {
        DeleteMe()
        println("WRONG")
    } catch (exc: DeleteException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest UpdateUser call:")
    try {
        Update(1, listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Guest UpdateProfile call:")
    try {
        UpdateProfile(listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
}
fun RegLogTest() {
    println("Invalid email registration call:")
    try {
        Register("eeads","USERNAME","HASHEDPAS")
        println("WRONG")
    } catch (exc:RegisterException) {println("OK - "+exc.code+" "+ exc.message)}
    println("------------------------------------------------------------------------------")
    println("Invalid username registration call:")
    try {
        Register("example@email.ru","1","HASHEDPAS")
        println("WRONG")
    } catch (exc:RegisterException) {println("OK - "+exc.code+" "+ exc.message)}
    println("------------------------------------------------------------------------------")
    println("Invalid password registration call:")
    try {
        Register("example@email.ru","Gibbdara","1")
        println("WRONG")
    } catch (exc:RegisterException) {println("OK - "+exc.code+" "+ exc.message)}
    println("------------------------------------------------------------------------------")
    println("Valid registration call:")
    try {
        Register("example@email.ru","Gibbdara","123456")
        println("OK")
    } catch (exc:RegisterException) {println("WRONG - "+exc.code+" "+ exc.message)}
    println("------------------------------------------------------------------------------")
    println("Login with wrong email:")
    try {
        Login("wrong@email.ru","12345")
        println("WRONG")
    } catch (exc:LoginException) {println("OK - "+exc.code+" "+ exc.message)}
    println("------------------------------------------------------------------------------")
    println("Login with wrong password:")
    try {
        Login("user@email.ru","1")
        println("WRONG")
    } catch (exc:LoginException) {println("OK - "+exc.code+" "+ exc.message)}
    println("------------------------------------------------------------------------------")
    println("Invalid email login:")
    try {
        Login("rurvrbtrrrf","12345")
        println("WRONG")
    } catch (exc:LoginException) { println("OK - "+exc.code+" "+ exc.message) }
    println("------------------------------------------------------------------------------")
    println("Banned login:")
    try {
        Login("banned@emai.ru","12345")
        println("WRONG")
    } catch (exc:LoginException) { println("OK - "+exc.code+" "+ exc.message) }
    println("------------------------------------------------------------------------------")
    println("Deleted login:")
    try {
        Login("deleted@emai.ru","12345")
        println("WRONG")
    } catch (exc:LoginException) { println("OK - "+exc.code+" "+ exc.message) }
    println("------------------------------------------------------------------------------")
}
fun UserTest() {
    println("Login:")
    try {
        Login("user@email.ru","123456")
        println("OK")
    } catch (exc:LoginException) {println("WRONG - "+exc.code+" "+ exc.message)}
    println("------------------------------------------------------------------------------")
    println("User GetUser call with invalid email:")
    try {
        GetUser("invalidemail")
        throw Exception("EmailValidEmail")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+ exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User GetUser call with wrong email:")
    try {
        GetUser("wrong@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User GetUser call with banned email:")
    try {
        GetUser("banned@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User GetUser call with deleted email:")
    try {
        GetUser("deleted@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User GetUser call with valid email:")
    try {
        GetUser("user@email.ru")
        println("OK")
    } catch (exc: UserDataException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User GetUserList call:")
    try {
        GetUserList()
        println("OK")
    } catch (exc: UserListException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Bad page User GetUserList call:")
    try {
        GetUserList(-1, 2).forEach { println(it) }
        println("WRONG")
    } catch (exc: UserListException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Bad limit User GetUserList call:")
    try {
        GetUserList(1, -241).forEach { println(it) }
        println("WRONG")
    } catch (exc: UserListException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User Ban call:")
    try {
        Ban(1)
        println("WRONG")
    } catch (exc: BanException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User Unban call:")
    try {
        Unban(1)
        println("WRONG")
    } catch (exc: BanException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User Mute call:")
    try {
        Mute(1)
        println("WRONG")
    } catch (exc: MuteException) {
        println("OK - " + exc.code+" "+ exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User Mute call:")
    try {
        Unmute(1)
        println("WRONG")
    } catch (exc: MuteException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User Delete call:")
    try {
        DeleteMe()
        println("OK")
    } catch (exc: DeleteException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User invalid dataType UpdateUser call:")
    try {
        Update(1, listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User not equal lists UpdateUser call:")
    try {
        Update(1, listOf("NotMatter","Notmatter"), listOf("NotMatter"))
        println("WRONG")
    }
    catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User wrong DataType UpdateProfile call:")
    try {
        UpdateProfile(listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User UpdateProfile call:")
    try {
        UpdateProfile(listOf("role"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("User not equal lists UpdateProfile call:")
    try {
        UpdateProfile(listOf("NotMatter","NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Logout:")
    try {
        Logout()
        println("OK")
    } catch (exc: LogoutException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")

}
fun ModerTest() {
    println("Login:")
    try {
        Login("moder@email.ru","123456")
        println("OK")
    } catch (exc:LoginException) {println("WRONG - "+exc.code+" "+ exc.message)}
    println("------------------------------------------------------------------------------")
    println("Moder GetUser call with invalid email:")
    try {
        GetUser("invalidemail")
        throw Exception("EmailValidEmail")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+ exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder GetUser call with wrong email:")
    try {
        GetUser("wrong@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder GetUser call with banned email:")
    try {
        GetUser("banned@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder GetUser call with deleted email:")
    try {
        GetUser("deleted@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder GetUser call with valid email:")
    try {
        GetUser("user@email.ru")
        println("OK")
    } catch (exc: UserDataException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder GetUserList call:")
    try {
        GetUserList()
        println("OK")
    } catch (exc: UserListException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Bad page Moder GetUserList call:")
    try {
        GetUserList(-1, 2).forEach { println(it) }
        println("WRONG")
    } catch (exc: UserListException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Bad limit Moder GetUserList call:")
    try {
        GetUserList(1, -241).forEach { println(it) }
        println("WRONG")
    } catch (exc: UserListException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder Ban call:")
    try {
        Ban(1)
        println("WRONG")
    } catch (exc: BanException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder Unban call:")
    try {
        Unban(1)
        println("WRONG")
    } catch (exc: BanException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder Mute call:")
    try {
        Mute(1)
        println("OK")
    } catch (exc: MuteException) {
        println("WRONG - " + exc.code+" "+ exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder Mute call:")
    try {
        Unmute(1)
        println("OK")
    } catch (exc: MuteException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder Delete call:")
    try {
        DeleteMe()
        println("OK")
    } catch (exc: DeleteException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder invalid dataType UpdateUser call:")
    try {
        Update(1, listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder not equal lists UpdateUser call:")
    try {
        Update(1, listOf("NotMatter","Notmatter"), listOf("NotMatter"))
        println("WRONG")
    }
    catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder wrong DataType UpdateProfile call:")
    try {
        UpdateProfile(listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder role UpdateProfile call:")
    try {
        UpdateProfile(listOf("role"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder invalid email UpdateProfile call:")
    try {
        UpdateProfile(listOf("email"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder valid email UpdateProfile call:")
    try {
        UpdateProfile(listOf("email"), listOf("example@email.re"))
        println("OK")
    } catch (exc: UpdateException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder avatarURL UpdateProfile call:")
    try {
        UpdateProfile(listOf("avatarURL"), listOf("NotMatter"))
        println("OK")
    } catch (exc: UpdateException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Moder not equal lists UpdateProfile call:")
    try {
        UpdateProfile(listOf("NotMatter","NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Logout:")
    try {
        Logout()
        println("OK")
    } catch (exc: LogoutException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
}
fun AdminTest() {
    println("Login:")
    try {
        Login("admin@email.ru","123456")
        println("OK")
    } catch (exc:LoginException) {println("WRONG - "+exc.code+" "+ exc.message)}
    println("------------------------------------------------------------------------------")
    println("Admin GetUser call with invalid email:")
    try {
        GetUser("invalidemail")
        throw Exception("EmailValidEmail")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+ exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin GetUser call with wrong email:")
    try {
        GetUser("wrong@email.ru")
        println("WRONG")
    } catch (exc: UserDataException) {
        println("OK - " +exc.code+" "+exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin GetUser call with banned email:")
    try {
        GetUser("banned@email.ru")
        println("OK")
    } catch (exc: UserDataException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin GetUser call with deleted email:")
    try {
        GetUser("deleted@email.ru")
        println("OK")
    } catch (exc: UserDataException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin GetUser call with valid email:")
    try {
        GetUser("user@email.ru")
        println("OK")
    } catch (exc: UserDataException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin GetUserList call:")
    try {
        GetUserList()
        println("OK")
    } catch (exc: UserListException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Bad page Admin GetUserList call:")
    try {
        GetUserList(-1, 2).forEach { println(it) }
        println("WRONG")
    } catch (exc: UserListException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Bad limit Admin GetUserList call:")
    try {
        GetUserList(1, -241).forEach { println(it) }
        println("WRONG")
    } catch (exc: UserListException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin Ban call:")
    try {
        Ban(1)
        println("OK")
    } catch (exc: BanException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin Unban call:")
    try {
        Unban(1)
        println("OK")
    } catch (exc: BanException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin Mute call:")
    try {
        Mute(1)
        println("OK")
    } catch (exc: MuteException) {
        println("WRONG - " + exc.code+" "+ exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin Mute call:")
    try {
        Unmute(1)
        println("OK")
    } catch (exc: MuteException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin Delete call:")
    try {
        DeleteMe()
        println("OK")
    } catch (exc: DeleteException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin invalid dataType UpdateUser call:")
    try {
        Update(1, listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin not equal lists UpdateUser call:")
    try {
        Update(1, listOf("NotMatter","Notmatter"), listOf("NotMatter"))
        println("WRONG")
    }
    catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin wrong DataType UpdateProfile call:")
    try {
        UpdateProfile(listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin role UpdateProfile call:")
    try {
        UpdateProfile(listOf("role"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin invalid email UpdateProfile call:")
    try {
        UpdateProfile(listOf("email"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin valid email UpdateProfile call:")
    try {
        UpdateProfile(listOf("email"), listOf("example@email.re"))
        println("OK")
    } catch (exc: UpdateException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin avatarURL UpdateProfile call:")
    try {
        UpdateProfile(listOf("avatarURL"), listOf("NotMatter"))
        println("OK")
    } catch (exc: UpdateException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Admin not equal lists UpdateProfile call:")
    try {
        UpdateProfile(listOf("NotMatter","NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc: UpdateException) {
        println("OK - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
    println("Logout:")
    try {
        Logout()
        println("OK")
    } catch (exc: LogoutException) {
        println("WRONG - " +exc.code+" "+  exc.message)
    }
    println("------------------------------------------------------------------------------")
}
