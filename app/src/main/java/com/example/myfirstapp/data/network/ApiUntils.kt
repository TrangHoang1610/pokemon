package com.example.myfirstapp.data.network

class ApiUntils {
    private  var BASE_URL = "https://pokeapi.co/api/v2/"
    fun getApiService (): ApiService {
        return  RetrofitClient.getClient(BASE_URL)!!.create(ApiService::class.java)
    }
}