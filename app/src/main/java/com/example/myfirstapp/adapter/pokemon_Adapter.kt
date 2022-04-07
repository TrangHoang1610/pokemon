package com.example.myfirstapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.R
import com.example.myfirstapp.model.PokemonModel

class pokemon_Adapter : RecyclerView.Adapter<pokemon_Adapter.ViewHolder>() {

    private var titles =
        arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8")
    private var detail = arrayOf(
        "Item 1 detail",
        "Item 2 detail",
        "Item 3 detail",
        "Item 4 detail",
        "Item 5 detail",
        "Item 6 detail",
        "Item 7 detail",
        "Item 8 detail"
    )
    private var images = intArrayOf(
        R.drawable.ic_pokemon_default,
        R.drawable.ic_pokemon_default,
        R.drawable.ic_pokemon_default,
        R.drawable.ic_pokemon_default,
        R.drawable.ic_pokemon_default,
        R.drawable.ic_pokemon_default,
        R.drawable.ic_pokemon_default,
        R.drawable.ic_pokemon_default
    )

    companion object {
        const val VIEW_TYPE_ITEM = 0
        const val VIEW_TYPE_LOADING = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pokemon_Adapter.ViewHolder {
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
        holder.itemName.text = titles[position]
        holder.itemImage.setImageResource(images[position])
        holder.itemId.text = detail[position]

    }

    override fun getItemCount(): Int {
        return titles.size
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.imgPokemon)
        var itemName: TextView = itemView.findViewById(R.id.tvName)
        var itemId: TextView = itemView.findViewById(R.id.tvId)
        var constrain: ConstraintLayout = itemView.findViewById(R.id.constrainLayout)
        var recyclerView: RecyclerView = itemView.findViewById(R.id.rv_Type)


    }

}