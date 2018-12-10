package com.example.android.androidcleanarchitecturemvvm

import android.app.Application
import com.example.android.androidcleanarchitecturemvvm.adapter.PokemonListAdapter
import com.example.android.androidcleanarchitecturemvvm.data.remote.PokemonApi
import com.example.android.androidcleanarchitecturemvvm.data.repository.PokemonRepository
import com.example.android.androidcleanarchitecturemvvm.data.repository.PokemonRepositoryImpl
import com.example.android.androidcleanarchitecturemvvm.domain.GetPokemonListUseCase
import com.example.android.androidcleanarchitecturemvvm.presentation.pokemon_list.PokemonListViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseApp : Application() {

    val kodein = Kodein {
        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .baseUrl(getString(R.string.BASE_URL))
                    .build()
        }
        bind<PokemonApi>() with singleton {
            (instance() as Retrofit).create(PokemonApi::class.java)
        }
        bind<PokemonRepository>() with provider { PokemonRepositoryImpl(instance()) }
        bind<GetPokemonListUseCase>() with provider { GetPokemonListUseCase(instance()) }
        bind<PokemonListViewModel>() with provider { PokemonListViewModel(instance()) }
        bind<PokemonListAdapter>() with provider { PokemonListAdapter() }
    }


}