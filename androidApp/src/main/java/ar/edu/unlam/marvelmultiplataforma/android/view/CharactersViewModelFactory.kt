package ar.edu.unlam.marvelmultiplataforma.android.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.edu.unlam.marvelmultiplataforma.Data.RepositorioDePersonajes
import ar.edu.unlam.marvelmultiplataforma.android.model.CharactersService

class CharactersViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        /*val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PublicKeyInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiClient = retrofit.create(MarvelCharactersClient::class.java)*/

        val charactersApi = RepositorioDePersonajes()
        val charactersService = CharactersService(charactersApi)
        return CharactersViewModel(charactersService) as T
    }
}