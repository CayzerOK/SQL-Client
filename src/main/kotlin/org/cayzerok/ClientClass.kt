package org.cayzerok

import io.ktor.client.HttpClient
import io.ktor.client.features.cookies.ConstantCookieStorage
import io.ktor.client.features.cookies.HttpCookies
import io.ktor.http.Cookie

import kotlinx.coroutines.experimental.runBlocking


val client = HttpClient {
    install(HttpCookies){
        storage = ConstantCookieStorage(Cookie("SESSION_ID",""))
    }
}

fun main(args : Array<String>) = runBlocking {


    println("User login:")
    try {
        Login("user@email.ru","12345")
        println("OK")
    } catch (exc:LoginException) { println("WRONG - "+exc.message) }
    println("------------------------------------------------------------------------------")
    println("Alredy-login login:")
    try {
        Login("user@email.ru","12345")
        println("WRONG")
    } catch (exc:LoginException) { println("OK - "+exc.message) }
    println("------------------------------------------------------------------------------")
    println("User GetUser call with valid email:")
    try {
        GetUser("user@email.ru")
        println("OK")
    } catch (exc:UserDataException) {println("WRONG - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("User GetUserList call:")
    try {
        GetUserList()
        println("OK")
    } catch (exc:UserListException) {println("WRONG - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("User Ban call:")
    try {
        Ban(1)
        println("WRONG")
    } catch (exc:BanException) {println("OK - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("User Delete call:")
    try {
        DeleteMe()
        println("OK")
    } catch (exc:DeleteException) {println("WRONG - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("User UpdateUser call:")
    try {
        UpdateUser(1, listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc:UpdateException) {println("OK - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("User invalid UpdateProfile call:")
    try {
        UpdateProfile(listOf("NotMatter"), listOf("NotMatter"))
        println("WRONG")
    } catch (exc:UpdateException) {println("OK - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("User valid UpdateProfile call:")
    try {
        UpdateProfile(listOf("email"), listOf("example@mail.ru"))
        println("OK")
    } catch (exc:UpdateException) {println("WRONG- "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("Logined registration call:")
    try {
        Register("example@email.ru","Gibbdara","123456")
        println("WRONG")
    } catch (exc:RegisterException) {println("OK - "+exc.message)}
    println("------------------------------------------------------------------------------")
    println("User mute call:")
    try {
        Mute(1)
        println("WRONG")
    } catch (exc:MuteException) { println("OK - "+exc.message) }
    println("------------------------------------------------------------------------------")
    println("User unmute call:")
    try {
        Unmute(1)
        println("WRONG")
    } catch (exc:MuteException) { println("OK - "+exc.message) }
    println("------------------------------------------------------------------------------")
    println("Logout:")
    try {
        Logout()
        println("OK")
    } catch (exc:LogoutException) {println("WRONG - "+exc.message)}
    println("------------------------------------------------------------------------------")

}