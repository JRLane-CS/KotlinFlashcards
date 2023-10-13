package com.example.kotlinflashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class ManageFlashcards : AppCompatActivity() {

    //declare screen variables
    private lateinit var btnRun : Button
    private lateinit var btnEdit : Button
    private lateinit var btnLoad : Button
    private lateinit var btnSave : Button

    //declare result launcher variable for child activity data return
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    //declare default flashcard arrays variables
    private var questions =
        arrayListOf("What is the capital first letter of today's English alphabet?",
            "What is the capital second letter of today's English alphabet?",
            "What is the capital last letter of today's English alphabet?")
    private var answers =
        arrayListOf("A", "B", "Z")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_flashcards)

        //prepare result launcher for child to parent arrays transfer
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {dataReturned ->
            if (dataReturned.resultCode == RESULT_OK) {
                questions = dataReturned.data?.getStringArrayListExtra(
                    "questions") as ArrayList<String>
                answers = dataReturned.data?.getStringArrayListExtra(
                    "answers") as ArrayList<String>
            }
        }

        //link button variable to button and set on click listener for each,
        //pass question and answer arrays to child activity RunFlashcards
        btnRun = findViewById(R.id.btn_Run)
        btnRun.setOnClickListener {
            startActivity(Intent(this, RunFlashcards::class.java)
                .putStringArrayListExtra("questions", questions)
                .putStringArrayListExtra("answers", answers))
        }

        //when edit button is pressed, launch editFlashcards activity and pass arrays
        btnEdit = findViewById(R.id.btn_Edit)
        btnEdit.setOnClickListener {

            //launch result launcher, creating EditFlashcards activity and passing arrays
            //when activity ends, the question and answer arrays will be updated as noted
            //in the instantiation above
            resultLauncher.launch(
                Intent(this, EditFlashcards::class.java)
                    .putStringArrayListExtra("questions", questions)
                    .putStringArrayListExtra("answers", answers))
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