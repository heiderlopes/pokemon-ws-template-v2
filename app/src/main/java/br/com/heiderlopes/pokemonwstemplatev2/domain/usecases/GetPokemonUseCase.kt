package br.com.heiderlopes.pokemonwstemplatev2.domain.usecases

import br.com.heiderlopes.pokemonwstemplatev2.domain.repository.PokemonRepository

class GetPokemonUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(number: String) = pokemonRepository.getPokemon(
        number
    )
}
