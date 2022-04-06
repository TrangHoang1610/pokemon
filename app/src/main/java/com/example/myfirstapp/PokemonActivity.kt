package com.example.myfirstapp

import android.os.Bundle
import android.os.PersistableBundle
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

 class PokemonActivity : AppCompatActivity(), View.OnKeyListener, SwipeRefreshLayout.OnRefreshListener{
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setActionBar()
         setContentView(R.layout.activity_pokemon)
     }
     private fun setActionBar(){
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