package ar.edu.unlam.marvelmultiplataforma.android.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unlam.marvelmultiplataforma.android.databinding.ListItemCharacterBinding
import ar.edu.unlam.marvelmultiplataforma.android.model.Character

class CharactersAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    private val characterList = mutableListOf<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ListItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItemAt(position))
    }

    override fun getItemCount() = characterList.size

    fun submitList(characters : List<Character>){
        with(characterList){
            clear()
            addAll(characters)
        }
        notifyDataSetChanged()
    }

    private fun getItemAt(position: Int) = characterList[position]

}