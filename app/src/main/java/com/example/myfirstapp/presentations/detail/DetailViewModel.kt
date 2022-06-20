package com.example.myfirstapp.presentations.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfirstapp.data.model.pokemons.PokemonModel
import com.example.myfirstapp.data.network.ApiUntils
import com.example.myfirstapp.repository.DataRepository
import com.example.myfirstapp.repository.DataRepositoryImpl
import com.example.pokemon.models.detailpokemon.DetailPokemon
import retrofit2.Call
import retrofit2.Response

class DetailViewModel: ViewModel() {
    val detailPokemon:MutableLiveData<DetailPokemon> = MutableLiveData()
    private  val data: DataRepository = DataRepositoryImpl(ApiUntils().getApiService())
    fun getData(id:Int){
       data.getDetailPokemon(id).enqueue(object : retrofit2.Callback<DetailPokemon>{
           override fun onResponse(
               call: Call<DetailPokemon>,
               response: Response<DetailPokemon>
           ) {
               if (response.isSuccessful) {
                   Log.d("detailPokemon", "detailPokemon loaded from API")
                   detailPokemon.value = response.body()
               } else {
                   Log.d("detailPokemon", response.message() + response.code())
                   detailPokemon.postValue(null)
               }
           }

           override fun onFailure(call: Call<DetailPokemon>, t: Throwable) {
               Log.d("detailPokemon", "error loading from API getAll")
               detailPokemon.postValue(null)
           }

       })
    }
}