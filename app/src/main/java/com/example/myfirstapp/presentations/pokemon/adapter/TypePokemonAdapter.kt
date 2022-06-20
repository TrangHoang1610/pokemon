package com.example.myfirstapp.presentations.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfirstapp.R
import com.example.pokemon.common.Utis
import com.example.pokemon.models.detailpokemon.Type

class TypePokemonAdapter : RecyclerView.Adapter<TypePokemonAdapter.ViewHolder>() {
    var listData: ArrayList<Type> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgType: ImageView
        init {
            imgType = itemView.findViewById(R.id.img_Type)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.imgType.setImageResource(if(listData[position].type == Type.))
        listData[position].type?.name?.let { Utis.typePokemon(it) }?.let {
            holder.imgType.setImageResource(
                it
            )
        }
    }

    override fun getItemCount(): Int {
        return listData.count()
    }
}