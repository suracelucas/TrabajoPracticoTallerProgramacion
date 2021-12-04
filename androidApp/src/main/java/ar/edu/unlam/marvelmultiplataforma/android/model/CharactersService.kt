package ar.edu.unlam.marvelmultiplataforma.android.model

import ar.edu.unlam.marvelmultiplataforma.android.BuildConfig
import ar.edu.unlam.marvelmultiplataforma.md5
import ar.edu.unlam.marvelmultiplataforma.model.CharactersRepository
import ar.edu.unlam.marvelmultiplataforma.model.Personaje

class CharactersService(
    private val charactersRepository: CharactersRepository
) {
    suspend fun getCharacters(): List<Personaje> {
        val timestamp = System.currentTimeMillis()
        return charactersRepository.getCharacters(
            timestamp,
            md5(timestamp.toString() + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY)
        )
    }
}