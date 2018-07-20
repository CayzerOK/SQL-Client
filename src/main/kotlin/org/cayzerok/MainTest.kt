import io.ktor.client.*
import io.ktor.client.call.call
import io.ktor.client.engine.*
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.cookies.AcceptAllCookiesStorage
import io.ktor.client.features.cookies.HttpCookies
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.http.HttpMethod
import kotlinx.coroutines.experimental.*
import org.cayzerok.users

data class LoginData(val email:String, val password: String)


val client = HttpClient(Apache.config { followRedirects = true }) {
    install(JsonFeature) {
        serializer = GsonSerializer {
            serializeNulls()
            disableHtmlEscaping()
            setPrettyPrinting()
        }
    }

    install(HttpCookies) {
        storage = AcceptAllCookiesStorage()
    }
}

fun main(args: Array<String>) = runBlocking {
    val clientData = LoginData("cayzerok@gmail.com","1Qaz2wsx3ed")
    val call = client.call("http://127.0.0.1:8080/" +
            "login?email=${clientData.email}&password=${clientData.password}") {
        method = HttpMethod.Get
    }
    println(call.response.status)

    println(users().data)
}