package br.com.heiderlopes.pokemonwstemplatev2.presentation.listpokemons

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.domain.usecases.GetFirstGenerationPokemonsUseCase
import br.com.heiderlopes.pokemonwstemplatev2.presentation.model.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListPokemonsViewModel(
    val getFirstGenerationPokemonsUseCase: GetFirstGenerationPokemonsUseCase
) : ViewModel() {

    val pokemonResult = MutableLiveData<ViewState<List<Pokemon>>>()

    fun getPokemons() {

        pokemonResult.postValue(ViewState.Loading)

        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                getFirstGenerationPokemonsUseCase()
            }.onSuccess {
                pokemonResult.postValue(ViewState.Success(it.getOrDefault(listOf())))
            }.onFailure {
                pokemonResult.postValue(ViewState.Failure(it))
            }
        }
    }
}