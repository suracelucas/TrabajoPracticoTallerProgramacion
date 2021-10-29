package ar.edu.unlam.marvelmultiplataforma.android.data

import ar.edu.unlam.marvelmultiplataforma.android.model.Character
import ar.edu.unlam.marvelmultiplataforma.android.model.CharactersRepository

class RetrofitCharactersRepository(private val apiClient: MarvelCharactersClient) : CharactersRepository{
    override suspend fun getCharacters(timestamp: Long, md5: String): List<Character> {
        return apiClient.getAllCharacters(timestamp, md5).toModel()
    }

    private fun CharactersResponse.toModel(): List<Character>{
        return this.characters.list.map{
            Character(it.name, it.description, it.thumbnail.toUrl())
        }
    }

}