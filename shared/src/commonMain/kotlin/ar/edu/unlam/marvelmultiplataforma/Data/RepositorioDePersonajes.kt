package ar.edu.unlam.marvelmultiplataforma.Data

import ar.edu.unlam.marvelmultiplataforma.initLogger
import ar.edu.unlam.marvelmultiplataforma.model.CharactersRepository
import ar.edu.unlam.marvelmultiplataforma.model.Personaje
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class RepositorioDePersonajes() : CharactersRepository {
    private val httpClient = HttpClient() {
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HttpClient", message = message)
                }
            }
        }
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }.also {
        initLogger()
    }

    private fun CharactersResponse.toModel(): List<Personaje> {
        return this.characters.list.map {
            Personaje(it.name, it.description, it.thumbnail.toUrl())
        }
    }

    override suspend fun getCharacters(timestamp: Long, md5: String): List<Personaje> {
        return httpClient.get<CharactersResponse>{
            headers {
                append("Accept", "application/json")
            }
            url("https://gateway.marvel.com/v1/public/characters")
            parameter("ts", timestamp)
            parameter("apikey", "e75eec951d753bfed4752777abfb4cd8")
            parameter("hash", md5)
        }.toModel()
    }
}