package org.cayzerok

import io.ktor.http.HttpStatusCode


class UserListException(override var message:String): Exception(message)
class UserDataException(override var message:String): Exception(message)
class ProfileException(override var message:String): Exception(message)
class LoginException(override var message:String): Exception(message)
class LogoutException(override var message:String): Exception(message)
class UpdateException(override var message:String): Exception(message)
class RegisterException(override var message:String): Exception(message)

var serverURL = "http://localhost:8080/"

fun PrintException(statusCode: HttpStatusCode) {
    when(statusCode.value) {
        400 -> println("Call error: ${statusCode.description}. Check your call data")
        401 -> println("Call error: ${statusCode.description}")
        403 -> println("Call error: ${statusCode.description}. Not enouth rights")
        404 -> println("Call error: ${statusCode.description}. Check your server URL")
        422 -> println("Call error: ${statusCode.description}")
        in 500..599 -> println("Call error: Internal server error(code:$statusCode)")
        else -> println("Call error: Unknown error(code:$statusCode)")
    }
}

