package com.example.myfirstapp.data.network

import com.example.myfirstapp.data.model.pokemons.PokemonModel
import com.example.pokemon.models.detailpokemon.DetailPokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon")
    fun getPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<PokemonModel>

    @GET("pokemon/{id}")
    fun getDetailPokemon(
        @Path("id") id: Int,
    ): Call<DetailPokemon>
}