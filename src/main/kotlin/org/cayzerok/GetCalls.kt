package org.cayzerok

import com.google.gson.reflect.TypeToken
import khttp.get

fun RefreshProfile(): UserData {
    val call= get(url+"profile", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw ProfileException(call.statusCode, call.text)
    }
    val thisProfile: UserData = gson.fromJson(call.text, object : TypeToken<UserData>() {}.type)
    profile = thisProfile
    return thisProfile
}

fun GetUser(email:String): UserData {
    val call = get(url+"users?email=$email", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw UserDataException(call.statusCode, call.text)
    }
    val thisProfile: UserData = gson.fromJson(call.text, object : TypeToken<UserData>() {}.type)
    return thisProfile
}

fun GetUserList(page:Int=1, limit:Int=4): List<UserData> {
    val call = get(url+"users?page=$page&limit=$limit", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw UserListException(call.statusCode, call.text)
    }
    val userList:List<UserData> = gson.fromJson(call.text, object : TypeToken<List<UserData>>() {}.type)
    return userList
}