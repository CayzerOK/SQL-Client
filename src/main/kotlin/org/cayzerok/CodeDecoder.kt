package org.cayzerok

class UserListException(override var message:String): Exception(message)
class UserDataException(override var message:String): Exception(message)
class ProfileException(override var message:String): Exception(message)
class LoginException(override var message:String): Exception(message)
class LogoutException(override var message:String): Exception(message)
class UpdateException(override var message:String): Exception(message)
class RegisterException(override var message:String): Exception(message)

var serverURL = "http://localhost:8080/"

fun PrintException(statusCode: Int) {
    when(statusCode) {
        400 -> println("Call error: Bad Request. Check your call data")
        401 -> println("Call error: Unauthorized")
        403 -> println("Call error: Access Denied. Not enouth rights")
        404 -> println("Call error: Not Found. Check your server URL")
        422 -> println("Call error: Already logined/registred")
        in 500..599 -> println("Call error: Internal server error(code:$statusCode)")
        else -> println("Call error: Unknown error(code:$statusCode)")
    }
}

