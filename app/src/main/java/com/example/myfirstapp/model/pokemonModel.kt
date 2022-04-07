package com.example.myfirstapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class PokemonModel() {
    constructor(
        pokemonModel: PokemonModel
    ) : this() {
        this.count = pokemonModel.count
        this.next = pokemonModel.next
        this.previous = pokemonModel.previous
        this.results = pokemonModel.results
    }


    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("next")
    @Expose
    var next: String? = null
    @SerializedName("previous")
    @Expose
    var previous: String? = null
    @SerializedName("results")
    @Expose
    var results: List<Pokemon>? = null
}


class Pokemon constructor(types: String) {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    var id: String? = null

    var type: String? = null
}
