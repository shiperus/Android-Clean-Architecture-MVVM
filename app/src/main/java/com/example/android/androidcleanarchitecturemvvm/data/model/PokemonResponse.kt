package com.example.android.androidcleanarchitecturemvvm.data.model

import com.google.gson.annotations.SerializedName

class PokemonResponse {
    @SerializedName("results")
    var results: List<PokemonModel> = ArrayList()
}