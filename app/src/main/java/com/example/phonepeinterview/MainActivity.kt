package com.example.phonepeinterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addGameFragment()
    }

    private fun addGameFragment() {
        supportFragmentManager.beginTransaction().add(R.id.mainContainer,GameFragment.newInstance(),null).commit()
    }
}