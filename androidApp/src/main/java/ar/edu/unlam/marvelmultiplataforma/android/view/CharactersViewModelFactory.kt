package ar.edu.unlam.marvelmultiplataforma.android.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.edu.unlam.marvelmultiplataforma.Data.RepositorioDePersonajes
import ar.edu.unlam.marvelmultiplataforma.android.model.CharactersService

class CharactersViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val charactersApi = RepositorioDePersonajes()
        val charactersService = CharactersService(charactersApi)
        return CharactersViewModel(charactersService) as T
    }
}