package org.cayzerok

import com.google.gson.reflect.TypeToken
import khttp.*

fun RegisterCall(email:String, username:String, password:String): List<UserData> {
    val call = put(url+"users?email=$email&username=$username&password=$password", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        println(call.text)
        throw UserListException(call.statusCode, call.text)
    }
    val userList:List<UserData> = gson.fromJson(call.text, object : TypeToken<List<UserData>>() {}.type)
    return userList
}