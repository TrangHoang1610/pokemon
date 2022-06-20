package com.example.myfirstapp.presentations.pokemon.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfirstapp.R
import com.example.myfirstapp.data.model.pokemons.Pokemon
import com.example.pokemon.common.Utis
import com.example.pokemon.models.detailpokemon.DetailPokemon
import java.util.*
import kotlin.math.log

class PokemonAdapter(var onClick: (Int) -> Unit) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    var pokemons:ArrayList<Pokemon> = arrayListOf()
    set(value) {
        field = value
        Log.d(TAG, "{value} ")
        notifyDataSetChanged()
    }

    var listDetailPokemon: ArrayList<DetailPokemon> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    companion object {
        const val VIEW_TYPE_ITEM = 0
        const val VIEW_TYPE_LOADING = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
            ViewHolder(view)
        } else {
            val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false)
            ViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = pokemons[position].name?.let { Utis.toUpperCase(it) }
        if(listDetailPokemon.size>0) {
            var detail:DetailPokemon? = null
            listDetailPokemon.forEach{
                if(it.id == position+1) detail = it
            }
            detail?.let {
                Glide.with(holder.itemImage.context)
                    .load(detail!!.sprites?.other?.officialArtwork?.frontDefault)
                    .placeholder(R.drawable.pokemon_placeholder)
                    .into(holder.itemImage)
                holder.itemId.text = detail!!.id.toString()
                holder.adapter.listData = ArrayList(detail!!.types ?: arrayListOf())
            }
        }
        holder.itemView.setOnClickListener {
            onClick(position+1)
        }
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.imgPokemon)
        var itemName: TextView = itemView.findViewById(R.id.tvName)
        var itemId: TextView = itemView.findViewById(R.id.tvId)
        var recyclerView: RecyclerView = itemView.findViewById(R.id.rv_Type)
        var adapter:TypePokemonAdapter
        init{
            adapter = TypePokemonAdapter()
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}