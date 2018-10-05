package org.cayzerok

import com.google.gson.reflect.TypeToken
import khttp.get

fun ProfileCall(): UserData {
    val call= get(url+"profile", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        println(call.text)
        throw ProfileException(call.statusCode, call.text)
    }
    val thisProfile: UserData = gson.fromJson(call.text, object : TypeToken<UserData>() {}.type)
    profile = thisProfile
    return thisProfile
}

fun GetUserCall(email:String): UserData {
    val call = get(url+"users?email=$email", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        println(call.text)
        throw UserDataException(call.statusCode, call.text)
    }
    val thisProfile: UserData = gson.fromJson(call.text, object : TypeToken<UserData>() {}.type)
    return thisProfile
}

fun GetUserListCall(page:Int=1, limit:Int=4): List<UserData> {
    val call = get(url+"users?page=$page&limit=$limit", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        println(call.text)
        throw UserListException(call.statusCode, call.text)
    }
    val userList:List<UserData> = gson.fromJson(call.text, object : TypeToken<List<UserData>>() {}.type)
    return userList
}