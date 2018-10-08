package org.cayzerok

import com.google.gson.GsonBuilder
import javax.jws.WebParam

val url = "http://localhost:8080/"
var profile = UserData()
val gson = GsonBuilder().setPrettyPrinting().create()
var sessionID:Map<String,String> = mapOf("SESSION_ID" to "")

data class UserData(val userID: Int?=null,
                    val userEmail: String?=null,
                    val userName: String?=null,
                    val avatarURL: String?=null,
                    val role: String?=null,
                    val mute: Boolean?=null)

fun main(args : Array<String>){
   // GuestTest()
    //UserTest()
    //RegLogTest()
    //ModerTest()
    AdminTest()
}