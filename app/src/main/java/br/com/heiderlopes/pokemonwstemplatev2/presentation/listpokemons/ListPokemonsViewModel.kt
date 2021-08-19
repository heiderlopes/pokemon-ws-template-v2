package br.com.heiderlopes.pokemonwstemplatev2.presentation.listpokemons

import androidx.lifecycle.ViewModel
import br.com.heiderlopes.pokemonwstemplatev2.domain.usecases.GetFirstGenerationPokemonsUseCase

class ListPokemonsViewModel(
    val getFirstGenerationPokemonsUseCase: GetFirstGenerationPokemonsUseCase
) : ViewModel() {


    fun getPokemons() {
        
    }

}