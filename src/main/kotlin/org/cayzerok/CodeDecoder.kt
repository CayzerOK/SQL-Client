package org.cayzerok



class UserListException(code: Int, override var message:String): Exception(message)
class UserDataException(code: Int, override var message:String): Exception(message)
class ProfileException(code: Int, override var message:String): Exception(message)
class LoginException(code: Int, override var message:String): Exception(message)
class LogoutException(code: Int, override var message:String): Exception(message)
class UpdateException(code: Int, override var message:String): Exception(message)
class RegisterException(code: Int, override var message:String): Exception(message)
class DataStringException(override var message:String): Exception(message)
class BanException(code: Int, override var message:String): Exception(message)
class DeleteException(code: Int, override var message:String): Exception(message)
class MuteException(code: Int, override var message:String): Exception(message)

var serverURL = "http://localhost:8080/"


