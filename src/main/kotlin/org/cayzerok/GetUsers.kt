package org.cayzerok

import client
import io.ktor.client.call.call
import io.ktor.client.response.readText
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType

data class UserPublicData(val user_email:String, val user_name:String, val avatar_url:String, val access_lvl:Int)
data class returnData(val data:String, val statusCode: HttpStatusCode)
suspend fun users(page:Int=1, limit:Int=4): returnData {
    val users = client.call("http://127.0.0.1:8080/users?page=$page&limit=$limit"){
        method = HttpMethod.Get
        contentType(ContentType.Application.Json)
        body = UserPublicData("","","",0)
    }
    val upd = returnData(users.response.readText(), users.response.status)
    return upd
}