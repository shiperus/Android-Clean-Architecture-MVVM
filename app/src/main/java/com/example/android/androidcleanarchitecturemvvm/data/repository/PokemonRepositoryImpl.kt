package com.example.android.androidcleanarchitecturemvvm.data.repository

import android.util.Log
import com.example.android.androidcleanarchitecturemvvm.data.model.PokemonResponse
import com.example.android.androidcleanarchitecturemvvm.data.remote.PokemonApi
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositoryImpl(
        private val pokemonApi: PokemonApi
): PokemonRepository {

    override fun getPokemonList(): Deferred<PokemonResponse> {
        return pokemonApi.pokemonList()
    }
}