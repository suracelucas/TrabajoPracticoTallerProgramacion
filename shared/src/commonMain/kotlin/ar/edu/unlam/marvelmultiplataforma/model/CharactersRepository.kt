package ar.edu.unlam.marvelmultiplataforma.model

interface CharactersRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<Personaje>
}