package com.example.kotlinflashcards

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class ManageFlashcards : AppCompatActivity() {


    //declare screen variables
    private lateinit var btnRun : Button
    private lateinit var btnEdit : Button
    private lateinit var btnLoad : Button
    private lateinit var btnSave : Button

    //declare result variable for child activity data return
    private var myActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {

        }
    }

    //declare default flashcard arrays variables
    private var questions : ArrayList<String> =
        arrayListOf("What is the first letter of today's English alphabet?",
            "What is the second letter of today's English alphabet?",
            "What is the last letter of today's English alphabet?")
    private var answers =
        arrayListOf("A", "B", "Z")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_flashcards)



        //link button variable to button and set on click listener for each,
        //pass question and answer arrays to child activity RunFlashcards
        btnRun = findViewById(R.id.btn_Run)
        btnRun.setOnClickListener {
            startActivity(Intent(this, RunFlashcards::class.java)
                .putStringArrayListExtra("questions", questions)
                .putStringArrayListExtra("answers", answers))
        }

        btnEdit = findViewById(R.id.btn_Edit)
        btnEdit.setOnClickListener {

            myActivityResultLauncher.launch(Intent(this, EditFlashcards::class.java))

        }

        //load saved flashcard set
        btnLoad = findViewById(R.id.btn_Load)
        btnLoad.setOnClickListener {

            Toast.makeText(this, "Not Yet Implemented", Toast.LENGTH_SHORT).show()
        }

        //save current flashcard set
        btnSave = findViewById(R.id.btn_Save)
        btnSave.setOnClickListener {

            Toast.makeText(this, "Not Yet Implemented", Toast.LENGTH_SHORT).show()
        }
    }
}