package com.example.android.androidcleanarchitecturemvvm.data.remote

import com.example.android.androidcleanarchitecturemvvm.data.model.PokemonModel
import com.example.android.androidcleanarchitecturemvvm.data.model.PokemonResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon")
    fun pokemonList():Deferred<PokemonResponse>

    @GET("pokemon/{pokemonName}")
    fun pokemonList(@Path("pokemonName") pokemonName:String):Deferred<PokemonResponse>
}