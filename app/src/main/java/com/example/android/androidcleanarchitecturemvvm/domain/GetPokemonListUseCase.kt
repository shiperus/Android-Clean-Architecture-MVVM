package com.example.android.androidcleanarchitecturemvvm.domain

import com.example.android.androidcleanarchitecturemvvm.data.model.PokemonResponse
import com.example.android.androidcleanarchitecturemvvm.data.repository.PokemonRepository
import kotlinx.coroutines.Deferred

class GetPokemonListUseCase(
        private val pokemonRepository: PokemonRepository
) : BaseUseCase<PokemonResponse>() {
    override fun perform(): Deferred<PokemonResponse> {
        return pokemonRepository.getPokemonList()
    }

}