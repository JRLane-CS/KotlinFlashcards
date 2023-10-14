package com.example.kotlinflashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //Create Start Button variable
    private lateinit var btnStart : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //link button variable to Start button and activate listener
        //if Start button is clicked on, transfer activity to ManageFlashcards activity
        btnStart = findViewById(R.id.btn_Start)
        btnStart.setOnClickListener {
            startActivity(Intent(this, ManageFlashcards::class.java))
            finish()
        }

    }
}