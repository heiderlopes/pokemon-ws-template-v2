package br.com.heiderlopes.pokemonwstemplatev2.data.repository

import br.com.heiderlopes.pokemonwstemplatev2.data.remote.api.PokemonService
import br.com.heiderlopes.pokemonwstemplatev2.data.remote.mapper.PokemonResponseListToPokemonListMapper
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.domain.repository.PokemonRepository

class PokemonRespositoryImpl(
    val pokemonService: PokemonService
) : PokemonRepository {

    private val pokemonResponseListToPokemonListMapper = PokemonResponseListToPokemonListMapper()

    override suspend fun getPokemons(size: Int, sort: String): Result<List<Pokemon>> {
        return Result.success(
            pokemonResponseListToPokemonListMapper.map(pokemonService.getPokemons(size, sort).pokemons))
    }
}