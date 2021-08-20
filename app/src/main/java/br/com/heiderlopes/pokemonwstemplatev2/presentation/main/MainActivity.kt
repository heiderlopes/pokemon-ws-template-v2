package br.com.heiderlopes.pokemonwstemplatev2.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.heiderlopes.pokemonwstemplatev2.R
import br.com.heiderlopes.pokemonwstemplatev2.databinding.ActivityMainBinding
import br.com.heiderlopes.pokemonwstemplatev2.presentation.listpokemons.ListPokemonsActivity
import br.com.heiderlopes.pokemonwstemplatev2.presentation.pokedex.PokedexActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val viewBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btPokedex.setOnClickListener {
            startActivity(Intent(this, PokedexActivity::class.java))
        }

        viewBinding.btPokemonList.setOnClickListener {
            startActivity(Intent(this, ListPokemonsActivity::class.java))
        }

        viewBinding.btClose.setOnClickListener {
            finish()
        }
    }
}