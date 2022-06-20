package com.example.myfirstapp.presentations.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Guideline
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myfirstapp.R
import com.example.myfirstapp.presentations.pokemon.PokemonViewModel
import com.example.pokemon.common.Utis
import java.util.ArrayList

class DetailActivity : AppCompatActivity() {
    lateinit var viewModel: DetailViewModel
    lateinit var nameOfPokemon: TextView
    lateinit var topOfInformation: TextView
    lateinit var name: TextView
    lateinit var description: TextView
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        initView()
        initEventViewmodel()
        val id = intent.getIntExtra("id", -1)
        Log.e("DetailActivity", "id ${id}")
        if (id != -1)
            viewModel.getData(id)
    }

    private fun initEventViewmodel() {
        viewModel.detailPokemon.observe(this, {
            nameOfPokemon.text = it.name?.let { Utis.toUpperCase(it) }
            Glide.with(this)
                .load(it!!.sprites?.other?.officialArtwork?.frontDefault)
                .placeholder(R.drawable.pokemon_placeholder)
                .into(imageView)
//            topOfInformation.text = it.
        })
    }

    private fun initView() {
        nameOfPokemon = findViewById(R.id.tv_Name)
        imageView = findViewById(R.id.img_avatar)
        topOfInformation = findViewById(R.id.tv_topOfInformation)
//        i = findViewById(R.id.img_tag)
        description = findViewById(R.id.tv_description)
    }
}