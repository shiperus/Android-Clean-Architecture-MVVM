package com.example.android.androidcleanarchitecturemvvm.presentation.pokemon_list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.android.androidcleanarchitecturemvvm.BaseActivity
import com.example.android.androidcleanarchitecturemvvm.R
import com.example.android.androidcleanarchitecturemvvm.adapter.PokemonListAdapter
import org.kodein.di.direct
import org.kodein.di.generic.instance

class PokemonListActivity : BaseActivity<PokemonListViewModel>() {
    private val pokemonListAdapter: PokemonListAdapter by instance()
    private lateinit var recyclerViewPokemonList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = kodein.direct.instance()
        setContentView(R.layout.activity_pokemon)
        initLayout()
        observeViewState()
        initObservedVar()
        viewModel.getListPokemon()
    }

    private fun initObservedVar() {
        viewModel.pokemonListObservable.observe(this, Observer {
            if (null != it) {
                pokemonListAdapter.pokemonList = it
                pokemonListAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun initLayout() {
        recyclerViewPokemonList = findViewById(R.id.rv_pokemon_list)
        recyclerViewPokemonList.layoutManager = LinearLayoutManager(this)
        recyclerViewPokemonList.adapter = pokemonListAdapter
    }
}
