package org.cayzerok

import khttp.get
import khttp.post

fun LoginCall(email:String,password:String){
    val call = post(url+"login?email=$email&password=$password", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        println(call.text)
        throw LoginException(call.statusCode, call.text)
    }
    sessionID = mapOf("SESSION_ID" to call.cookies["SESSION_ID"]!!)
    ProfileCall()
}

fun LogoutCall() {
    val call = get(url + "logout", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        println(call.text)
        throw LogoutException(call.statusCode, call.text)
    }
    sessionID = mapOf("SESSION_ID" to "")
    profile = UserData()
}