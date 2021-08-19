package br.com.heiderlopes.pokemonwstemplatev2.data.remote.mapper

import br.com.heiderlopes.pokemonwstemplatev2.data.remote.model.PokemonResponse
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.utils.Mapper

class PokemonResponseToPokemonMapper : Mapper<PokemonResponse, Pokemon> {
    override fun map(source: PokemonResponse): Pokemon {
        return Pokemon(
            number = source.numero,
            name = source.nome,
            imageURL =  source.imageURL,
            ps = source.ps,
            attack = source.ataque,
            defense =  source.defesa,
            velocity = source.velocidade
        )
    }
}