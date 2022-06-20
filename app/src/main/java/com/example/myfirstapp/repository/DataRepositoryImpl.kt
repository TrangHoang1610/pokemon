package com.example.myfirstapp.repository

import com.example.myfirstapp.data.model.pokemons.PokemonModel
import com.example.myfirstapp.data.network.ApiService
import com.example.pokemon.models.detailpokemon.DetailPokemon
import retrofit2.Call

class DataRepositoryImpl(val api:ApiService):DataRepository {
    override fun getPokemon(offset: Int, limit: Int): Call<PokemonModel> {
        return api.getPokemon(offset, limit)
    }

    override fun getDetailPokemon(id: Int): Call<DetailPokemon> {
        return api.getDetailPokemon(id)
    }
}