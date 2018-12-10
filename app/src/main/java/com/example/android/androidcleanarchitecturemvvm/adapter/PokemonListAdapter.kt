package com.example.android.androidcleanarchitecturemvvm.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.androidcleanarchitecturemvvm.R
import com.example.android.androidcleanarchitecturemvvm.data.model.PokemonModel

class PokemonListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var pokemonList: List<PokemonModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewPokemonLayoutItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_pokemon_item,parent,false)
        return PokemonItemViewHolder(viewPokemonLayoutItem)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PokemonItemViewHolder) {
            holder.textViewPokemonName.text = pokemonList.get(position).name
        }
    }

    class PokemonItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewPokemonName: TextView = itemView.findViewById(R.id.tv_pokemon_name)

    }

}