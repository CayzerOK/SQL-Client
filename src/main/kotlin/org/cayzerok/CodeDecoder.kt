package org.cayzerok



class UserListException(val code: Int, override var message:String): Exception(message)
class UserDataException(val code: Int, override var message:String): Exception(message)
class ProfileException(val code: Int, override var message:String): Exception(message)
class LoginException(val code: Int, override var message:String): Exception(message)
class LogoutException(val code: Int, override var message:String): Exception(message)
class UpdateException(val code: Int, override var message:String): Exception(message)
class RegisterException(val code: Int, override var message:String): Exception(message)
class BanException(val code: Int, override var message:String): Exception(message)
class DeleteException(val code: Int, override var message:String): Exception(message)
class MuteException(val code: Int, override var message:String): Exception(message)

var serverURL = "http://localhost:8080/"


