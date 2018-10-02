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
        throw LoginException(call.response.status.value,call.response.status.description)
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
        throw LogoutException(call.response.status.value,call.response.status.description)
    } else profile = User()
}

suspend fun GetProfile() {
    val call = client.call(serverURL + "profile") {
        method = HttpMethod.Get
        contentType(ContentType.Application.Json)
    }
    if (call.response.status.value != 200) {
        throw ProfileException(call.response.status.value,call.response.status.description)
    }
    profile = gson.fromJson(call.response.readText(), object : TypeToken<User>() {}.type)
}
suspend fun Register(email: String, username:String, password: String) {
    val call = client.call(serverURL + "users?email=$email&username=$username&password=$password") {
        method = HttpMethod.Put
        contentType(ContentType.Application.Json)
    }
    if (call.response.status.value != 200) {
        throw RegisterException(call.response.status.value,call.response.status.description)
    }
}
