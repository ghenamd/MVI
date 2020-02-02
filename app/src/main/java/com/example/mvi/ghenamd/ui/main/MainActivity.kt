package com.example.mvi.ghenamd.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvi.ghenamd.R

const val TAG = "MAIN_FRAGMENT"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showMainFragment()
    }

    private fun showMainFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,
                MainFragment(), TAG
            )
            .commit()
    }
}
