import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.cookies.ConstantCookieStorage
import io.ktor.client.features.cookies.HttpCookies
import io.ktor.client.features.json.*
import io.ktor.http.*
import kotlinx.coroutines.experimental.runBlocking
import org.cayzerok.*


data class LoginData(val email:String, val password: String)

val client = HttpClient(Apache.config {
    customizeClient {setMaxConnTotal(1)}}) {
    install(HttpCookies){
        storage = ConstantCookieStorage(Cookie("SESSION_ID",""))}
    install(JsonFeature) {
        serializer = GsonSerializer {serializeNulls()}
    }
}



fun main(args: Array<String>) = runBlocking {

    val clientData = LoginData("ignore@me.com", "1Qaz2wsx3ed")
    println(profile)
    Login(clientData.email,clientData.password)
    println(profile)
    Logout()
    println(profile)
    println(GetProfile())

}