package ar.edu.unlam.marvelmultiplataforma

import ar.edu.unlam.marvelmultiplataforma.model.Personaje
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json


class RepositorioDePersonajes (){
    private val httpClient = HttpClient(){
        install(Logging){
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag="HttpClient", message = message)
                }
            }
        }
        install(JsonFeature){
            val json = Json {ignoreUnknownKeys = true}
            serializer = KotlinxSerializer(json)
        }
    }.also {
        initLogger()
    }

    suspend fun obtenerPersonajes(): List<Personaje> {
        return httpClient.get("https://gateway.marvel.com/")
    }
}