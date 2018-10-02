package org.cayzerok

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
                val mute:Boolean? = null)

suspend fun GetUserList(page:Int=1, limit:Int=5): List<User> {
    val call = client.call("$serverURL/users?page=$page&limit=$limit") {
        method = HttpMethod.Get
        contentType(ContentType.Application.Json)
    }
    if (call.response.status.value != 200) {
        throw UserListException(call.response.status.value, call.response.status.description)
    }
    val UserList: List<User> = gson.fromJson(call.response.readText(), object : TypeToken<List<User>>() {}.type)
    return UserList
}

suspend fun GetUser(email:String): User? {
    val call = client.call("$serverURL/users?email=$email") {
        method = HttpMethod.Get
        contentType(ContentType.Application.Json)
    }
    if (call.response.status.value != 200) {
        throw UserDataException(call.response.status.value,call.response.status.description)
    }
    val UserData: User = gson.fromJson(call.response.readText(), object : TypeToken<User>() {}.type)
    return UserData
}
suspend fun Ban(userID:Int) {
    val call = client.call("$serverURL/users?userID=$userID&dataType=role&newValue=BANNED") {
        method = HttpMethod.Post
        contentType(ContentType.Application.Json)
    }
    if (call.response.status.value != 200) {
        throw BanException(call.response.status.value,call.response.status.description)
    }
}
suspend fun Mute(userID:Int) {
    val call = client.call("$serverURL/users?userID=$userID&dataType=mute&newValue=true") {
        method = HttpMethod.Post
        contentType(ContentType.Application.Json)
    }
    if (call.response.status.value != 200) {
        throw MuteException(call.response.status.value,call.response.status.description)
    }
}
suspend fun Unmute(userID:Int) {
    val call = client.call("$serverURL/users?userID=$userID&dataType=mute&newValue=false") {
        method = HttpMethod.Post
        contentType(ContentType.Application.Json)
    }
    if (call.response.status.value != 200) {
        throw MuteException(call.response.status.value,call.response.status.description)
    }
}
suspend fun DeleteMe() {
    val call = client.call("$serverURL/profile") {
        method = HttpMethod.Delete
        contentType(ContentType.Application.Json)
    }
    if (call.response.status.value != 200) {
        throw DeleteException(call.response.status.value,call.response.status.description)
    }
}


suspend fun UpdateUser(userID:Int,dataType: List<String>, data: List<String>) {
    val call = client.call("$serverURL/users?userID=$userID&dataType=${MakeDataString(dataType, data)}") {
        method = HttpMethod.Post
    }
    if (call.response.status.value != 200) {
        throw UpdateException(call.response.status.value,call.response.status.description)
    }
}

suspend fun UpdateProfile(dataType: List<String>, data: List<String>) {
    val call = client.call("$serverURL/profile?${MakeDataString(dataType, data)}") {
        method = HttpMethod.Post
    }
    if (call.response.status.value != 200) {
        throw UpdateException(call.response.status.value,call.response.status.description)
    } else {
        GetProfile()
    }
}

fun MakeDataString(dataType: List<String>, data: List<String>): String {
    if (data.size != dataType.size){
        throw DataStringException("Bad data list or dataType list.\n DataType list:" + dataType + "\n Data list:" + data)
    }
    var dataString =""
    dataType.forEach {            //Добавление типов данных
        dataString = dataString + "dataType=" + it +"&"
    }
    data.forEach {                //Добавление самих данных
        dataString = dataString + "newValue=" + it +"&"
    }
    dataString = dataString.dropLast(1) //удаление последнего знака (&)
return dataString
}