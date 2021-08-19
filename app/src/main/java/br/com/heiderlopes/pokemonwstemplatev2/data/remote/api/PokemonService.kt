package br.com.heiderlopes.pokemonwstemplatev2.data.remote.api

import br.com.heiderlopes.pokemonwstemplatev2.data.remote.model.PokemonListResponse
import retrofit2.http.Query

interface PokemonService {

    suspend fun getPokemons(
        @Query("size") size: Int,
        @Query("sort") sort: String
    ) : PokemonListResponse

}