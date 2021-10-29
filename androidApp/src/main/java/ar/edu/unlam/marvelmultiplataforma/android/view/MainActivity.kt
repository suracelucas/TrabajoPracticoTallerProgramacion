package ar.edu.unlam.marvelmultiplataforma.android.view

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unlam.marvelmultiplataforma.android.databinding.ActivityMainBinding
import ar.edu.unlam.marvelmultiplataforma.android.model.Character
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var charactersAdapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup del listado
        charactersAdapter = CharactersAdapter()
        val verticalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        with(binding.charactersList){
            this.adapter = charactersAdapter
            this.layoutManager = verticalLayoutManager
            this.addItemDecoration(VerticalSpaceItemDecoration(16))
        }

        // Listeb to Retrofit response
        val viewModel = ViewModelProvider(this, CharactersViewModelFactory())[CharactersViewModel::class.java]
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                viewModel.screenState.collect {
                    when(it){
                        ScreenState.Loading -> showLoading()
                        is ScreenState.ShowCharacters -> showCharacters(it.list)
                    }
                }
            }
        }
    }

    private fun showLoading(){

    }

    private fun showCharacters(list: List<Character>){
        charactersAdapter.submitList(list)
    }
}

class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int): RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = verticalSpaceHeight
    }
}
