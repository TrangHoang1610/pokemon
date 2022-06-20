package com.example.myfirstapp.data.model.pokemons

import com.google.gson.annotations.SerializedName

class Pokemon(
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)
