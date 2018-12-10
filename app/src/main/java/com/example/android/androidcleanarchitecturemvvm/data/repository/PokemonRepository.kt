package com.example.android.androidcleanarchitecturemvvm.data.repository

import com.example.android.androidcleanarchitecturemvvm.data.model.PokemonResponse
import kotlinx.coroutines.Deferred

interface PokemonRepository {
    fun getPokemonList() : Deferred<PokemonResponse>

}