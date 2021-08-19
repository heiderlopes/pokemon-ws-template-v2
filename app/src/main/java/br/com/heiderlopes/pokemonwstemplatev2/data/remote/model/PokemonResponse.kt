package br.com.heiderlopes.pokemonwstemplatev2.data.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("number") val numero: String,
    @SerializedName("name") val nome: String,
    @SerializedName("imageURL") val imageURL: String,
    @SerializedName("ps") var ps: Int,
    @SerializedName("attack") var ataque: Int,
    @SerializedName("defense") var defesa: Int,
    @SerializedName("velocity") var velocidade: Int,
    @SerializedName("description") val descricao: String
)