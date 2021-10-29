package ar.edu.unlam.marvelmultiplataforma.android.model

interface CharactersRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<Character>
}