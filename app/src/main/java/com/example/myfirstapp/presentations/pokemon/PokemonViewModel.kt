package com.example.myfirstapp.presentations.pokemon

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfirstapp.data.model.pokemons.Pokemon
import com.example.myfirstapp.data.network.ApiService
import com.example.myfirstapp.data.network.ApiUntils
import com.example.myfirstapp.data.model.pokemons.PokemonModel
import com.example.myfirstapp.repository.DataRepository
import com.example.myfirstapp.repository.DataRepositoryImpl
import com.example.pokemon.models.detailpokemon.DetailPokemon
import retrofit2.Call
import retrofit2.Response

class PokemonViewModel: ViewModel() {
    private  val data: DataRepository = DataRepositoryImpl(ApiUntils().getApiService())
    var pokemons: MutableLiveData<PokemonModel> = MutableLiveData()
    var pokemon: MutableLiveData<ArrayList<Pokemon>> = MutableLiveData(arrayListOf())
    var detailPokemons: MutableLiveData<ArrayList<DetailPokemon>> = MutableLiveData(arrayListOf())
    fun getAllPokemon(offset: Int){
        data.getPokemon(offset, 20)
            .enqueue(object : retrofit2.Callback<PokemonModel>{
                override fun onResponse(
                    call: Call<PokemonModel>,
                    response: Response<PokemonModel>
                ) {
                    if (response.isSuccessful) {
                        Log.d("pokemon", "pokemon loaded from API")
                        pokemons.postValue(response.body())
                        pokemon.value = (response.body()?.results ?: arrayListOf())
                        getDetailPokeMon(pokemon.value ?: arrayListOf())
                    } else {
                        Log.d("pokemon", response.message() + response.code())
                        pokemons.postValue(null)
                        pokemon.value = arrayListOf()
                    }
                }

                override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                    Log.d("pokemon", "error loading from API getAll")
                    pokemons.postValue(null)
                    pokemon.value = arrayListOf()
                }

            })

    }

    private fun getDetailPokeMon(value: ArrayList<Pokemon>) {
        value.forEachIndexed {index, element->
            data.getDetailPokemon(index+1)
                .enqueue(object : retrofit2.Callback<DetailPokemon>{
                    override fun onResponse(
                        call: Call<DetailPokemon>,
                        response: Response<DetailPokemon>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("pokemon", "pokemon loaded from API")

                            // gan data giua 2 list
                            val details  = detailPokemons.value
                            details?.add(response.body()!!)
                            detailPokemons.value = details
                        } else {
                            Log.d("pokemon", response.message() + response.code())
                            pokemons.postValue(null)
                            pokemon.value = arrayListOf()
                        }
                    }

                    override fun onFailure(call: Call<DetailPokemon>, t: Throwable) {
                        Log.d("pokemon", "error loading from API getAll")
                        pokemons.postValue(null)
                        pokemon.value = arrayListOf()
                    }

                })
        }

    }
}