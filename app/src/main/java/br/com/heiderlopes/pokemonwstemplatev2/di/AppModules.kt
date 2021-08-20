package br.com.heiderlopes.pokemonwstemplatev2.di

import br.com.heiderlopes.pokemonwstemplatev2.data.remote.api.PokemonService
import br.com.heiderlopes.pokemonwstemplatev2.data.remote.picasso.PicassoClient
import br.com.heiderlopes.pokemonwstemplatev2.data.remote.retrofit.HttpClient
import br.com.heiderlopes.pokemonwstemplatev2.data.remote.retrofit.RetrofitClient
import br.com.heiderlopes.pokemonwstemplatev2.data.repository.PokemonRespositoryImpl
import br.com.heiderlopes.pokemonwstemplatev2.domain.repository.PokemonRepository
import br.com.heiderlopes.pokemonwstemplatev2.domain.usecases.GetFirstGenerationPokemonsUseCase
import br.com.heiderlopes.pokemonwstemplatev2.domain.usecases.GetPokemonUseCase
import br.com.heiderlopes.pokemonwstemplatev2.domain.usecases.UpdatePokemonUseCase
import br.com.heiderlopes.pokemonwstemplatev2.presentation.formpokemon.FormPokemonViewModel
import br.com.heiderlopes.pokemonwstemplatev2.presentation.listpokemons.ListPokemonsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModules = module{
    factory { GetFirstGenerationPokemonsUseCase(pokemonRepository = get()) }
    factory { GetPokemonUseCase(pokemonRepository = get()) }
    factory { UpdatePokemonUseCase(pokemonRepository = get()) }
}

val dataModules = module {
    factory<PokemonRepository> { PokemonRespositoryImpl(pokemonService = get()) }
}

val networkModules = module {
    single { PicassoClient(application = androidContext()).newInstance() }
    single { RetrofitClient(application = androidContext()).newInstance() }
    single { HttpClient(get ()) }
    factory { get<HttpClient>().create(PokemonService::class.java)  }
}

val presentationModules = module {
    viewModel { ListPokemonsViewModel(getFirstGenerationPokemonsUseCase = get()) }
    viewModel { FormPokemonViewModel(getPokemonUseCase = get(), updatePokemonUseCase = get()) }

}