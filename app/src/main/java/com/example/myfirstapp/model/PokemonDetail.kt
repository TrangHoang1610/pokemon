package com.example.myfirstapp.model

data class PokemonDetail(
    var abilities: List<Ability>,
    var base_experience: Int,
    var forms: List<Form>,
    var game_indices: List<GameIndice>,
    var height: Int,
    var held_items: List<Any>,
    var id: Int,
    var is_default: Boolean,
    var location_area_encounters: String,
    var moves: List<Move>,
    var name: String,
    var order: Int,
    var past_types: List<Any>,
    var species: Species,
    var sprites: Sprites,
    var stats: List<Stat>,
    var types: List<Type>,
    var weight: Int
)