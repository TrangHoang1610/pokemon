package com.example.myfirstapp.presentations.pokemon

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myfirstapp.R
import com.example.myfirstapp.presentations.detail.DetailActivity
import com.example.myfirstapp.presentations.pokemon.adapter.PokemonAdapter

class PokemonActivity : AppCompatActivity(), View.OnKeyListener,
    SwipeRefreshLayout.OnRefreshListener {
    lateinit var recyclerView: RecyclerView
    lateinit var pokemonAdapter: PokemonAdapter
    lateinit var viewModel:PokemonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActionBar()
        setContentView(R.layout.activity_pokemon)
        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        initView()
        initEventViewModel()
        viewModel.getAllPokemon(0)
    }

    private fun initEventViewModel() {
        viewModel.pokemons.observe(this, Observer {

        })
        viewModel.pokemon.observe(this, {
            pokemonAdapter.pokemons =it
        })
        viewModel.detailPokemons.observe(this){
            pokemonAdapter.listDetailPokemon = it
        }
    }

    private fun initView() {
        recyclerView = findViewById(R.id.recyclerView)
        pokemonAdapter = PokemonAdapter {id ->
            // push du lieu giua 2 man
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
        recyclerView.adapter = pokemonAdapter
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
    }

    private fun setActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )
    }

    override fun onRefresh() {
        TODO("Not yet implemented")
    }

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        TODO("Not yet implemented")
    }
}