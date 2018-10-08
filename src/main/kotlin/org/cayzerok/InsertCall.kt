package org.cayzerok

import com.google.gson.reflect.TypeToken
import khttp.*

fun Register(email:String, username:String, password:String) {
    val call = put(url+"users?email=$email&username=$username&password=$password", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw RegisterException(call.statusCode, call.text)
    }
}

fun Update(userID:Int,dataTypes:List<String>,newData:List<String>) {
    val call = post(url+"users?userID=$userID&"+ MakeDataString(dataTypes,newData), cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw UpdateException(call.statusCode, call.text)
    }
    if(userID==profile.userID) {RefreshProfile()}
}

fun Ban(userID:Int) {
    val call = post(url+"users?userID=$userID&dataType=role&newValue=BANNED", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw BanException(call.statusCode, call.text)
    }
}
fun DeleteMe() {
    val call = delete(url+"profile", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw DeleteException(call.statusCode, call.text)
    }
}
fun Unban(userID:Int) {
    val call = post(url+"users?userID=$userID&dataType=role&newValue=User", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw BanException(call.statusCode, call.text)
    }
}
fun Unmute(userID: Int) {
    val call = post(url+"users?userID=$userID&dataType=mute&newValue=False", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw MuteException(call.statusCode, call.text)
    }
}

fun Mute(userID: Int) {
    val call = post(url+"users?userID=$userID&dataType=mute&newValue=true", cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw MuteException(call.statusCode, call.text)
    }
}

fun UpdateProfile(dataTypes:List<String>,newData:List<String>) {
    val call = post(url+"profile?"+MakeDataString(dataTypes,newData), cookies = sessionID)
    if (call.statusCode !in 200..299) {
        throw UpdateException(call.statusCode, call.text)
    }
    RefreshProfile()
}

fun MakeDataString(dataType: List<String>, data: List<String>): String {
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