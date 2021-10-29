package ar.edu.unlam.marvelmultiplataforma.android.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.edu.unlam.marvelmultiplataforma.android.data.MarvelCharactersClient
import ar.edu.unlam.marvelmultiplataforma.android.data.PublicKeyInterceptor
import ar.edu.unlam.marvelmultiplataforma.android.data.RetrofitCharactersRepository
import ar.edu.unlam.marvelmultiplataforma.android.model.CharactersService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PublicKeyInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiClient = retrofit.create(MarvelCharactersClient::class.java)

        val charactersApi = RetrofitCharactersRepository(apiClient)
        val charactersService = CharactersService(charactersApi)
        return CharactersViewModel(charactersService) as T
    }
}