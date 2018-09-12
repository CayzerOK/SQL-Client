package org.cayzerok

import com.google.gson.reflect.TypeToken
import io.ktor.client.call.call
import io.ktor.client.response.readText
import io.ktor.http.*

var profile = User()

suspend fun Login(email:String, password:String) {
    val call = client.call(serverURL + "login?email=$email&password=$password") {
        method = HttpMethod.Post
    }
    if (call.response.status.value != 200) {
        PrintException(call.response.status)
        throw LoginException("${call.response.status.value}")
    } else {
        GetProfile()
    }
}

suspend fun Logout() {
    val call = client.call(serverURL +
            "logout") {
        method = HttpMethod.Get
    }
    if (call.response.status.value != 200) {
        PrintException(call.response.status)
        throw LogoutException("${call.response.status.value}")
    } else profile = User()
}

suspend fun GetProfile() {
    val call = client.call(serverURL + "profile") {
        method = HttpMethod.Get
        contentType(ContentType.Application.Json)
    }
    if (call.response.status.value != 200) {
        PrintException(call.response.status)
        throw ProfileException("${call.response.status.value}")
    }
    profile = gson.fromJson(call.response.readText(), object : TypeToken<User>() {}.type)
}
suspend fun Register(email: String, username:String, password: String) {
    val call = client.call(serverURL + "users?email=$email&username=$username&password=$password") {
        method = HttpMethod.Put
        contentType(ContentType.Application.Json)
    }
    if (call.response.status.value != 200) {
        PrintException(call.response.status)
        throw RegisterException("${call.response.status.value}")
    }
}
