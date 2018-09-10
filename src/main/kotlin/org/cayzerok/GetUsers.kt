package org.cayzerok
import client
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import io.ktor.client.call.call
import io.ktor.client.response.readText
import io.ktor.http.*

val gson = GsonBuilder().setPrettyPrinting().create()

data class User(val userID: Int? = null,
                val userEmail:String? = null,
                val userName:String? = null,
                val avatarURL:String? = null,
                val role:String? = null,
                val ban:Boolean? = null,
                val mute:Boolean? = null)

suspend fun GetUserList(page:Int=1, limit:Int=5): List<User> {
    try {

        val call = client.call("$serverURL/users?page=$page&limit=$limit") {
            method = HttpMethod.Get
            contentType(ContentType.Application.Json)
        }

        if (call.response.status.value != 200) {
            PrintException(call.response.status.value)
            throw UserListException("${call.response.status.value}")
        }
        val UserList: List<User> = gson.fromJson(call.response.readText(), object : TypeToken<List<User>>() {}.type)
        return UserList
    }
    catch (e:UserListException) {
        return emptyList()
    }
}