package ar.edu.unlam.marvelmultiplataforma.android.view

import androidx.recyclerview.widget.RecyclerView
import ar.edu.unlam.marvelmultiplataforma.android.databinding.ListItemCharacterBinding
import ar.edu.unlam.marvelmultiplataforma.model.Personaje
import com.squareup.picasso.Picasso

class CharacterViewHolder(private val binding: ListItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Personaje) {
        binding.name.text = character.name
        binding.description.text = character.description
        if (character.thumbnailUrl.isNotEmpty()) {
            Picasso.get()
                .load(character.thumbnailUrl)
                .into(binding.image)
        } else {
            binding.image.setImageURI(null)
        }
    }

}
