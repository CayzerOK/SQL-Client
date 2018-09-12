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

fun main(args: Array<String>) = runBlocking {
    Login("GenericEmail", "GenericPassword")
    GetUserList(1,4).forEach {println(it)}
    //...some actions
    Logout()
}