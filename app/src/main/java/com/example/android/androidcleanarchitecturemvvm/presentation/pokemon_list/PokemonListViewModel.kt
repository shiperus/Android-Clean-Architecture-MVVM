package com.example.android.androidcleanarchitecturemvvm.presentation.pokemon_list

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.android.androidcleanarchitecturemvvm.BaseViewModel
import com.example.android.androidcleanarchitecturemvvm.ViewState
import com.example.android.androidcleanarchitecturemvvm.data.model.PokemonModel
import com.example.android.androidcleanarchitecturemvvm.domain.GetPokemonListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class PokemonListViewModel(
        private val getPokemonListUseCase: GetPokemonListUseCase
) : BaseViewModel(),CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    var pokemonListObservable: MutableLiveData<List<PokemonModel>> = MutableLiveData()
    private val arrayListPokemon = ArrayList<PokemonModel>()

    fun getListPokemon(){
        launch {
            viewState.value = ViewState(true)
            val response = getPokemonListUseCase.perform().await()
            delay(3000)
            viewState.value = ViewState(false)
            arrayListPokemon.clear()
            arrayListPokemon.addAll(response.results)
            pokemonListObservable.value = arrayListPokemon
        }
    }


}