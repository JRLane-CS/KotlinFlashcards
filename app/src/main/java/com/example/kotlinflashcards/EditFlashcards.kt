package com.example.kotlinflashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class EditFlashcards : AppCompatActivity() {

    //set variables for screen ops
    private lateinit var textQuestion : TextView
    private lateinit var textAnswer : TextView
    private lateinit var btnAccept : Button
    private lateinit var btnDelete : Button
    private lateinit var btnDone : Button
    private lateinit var btnNext : Button
    private lateinit var btnPrevious : Button

    //set defaults for flashcard ops
    private var index = 0
    private var size = 0
    private var flashcardQuestions : MutableList<String>? = null
    private var flashcardAnswers : MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_flashcards)

        //link editTextView variables to editTextMultilineView boxes
        textQuestion = findViewById(R.id.etml_EnterQuestion)
        textAnswer = findViewById(R.id.etml_EnterAnswer)

        //get flashcard arrays for questions and answers
        //flashcardQuestions = intent.getStringArrayListExtra("questions")
        //flashcardAnswers = intent.getStringArrayListExtra("answers")





        //simulate new flashcard creation for data return
        flashcardQuestions = arrayListOf("What number question is this?",
                            "What number question is this?")
        flashcardAnswers = arrayListOf("1", "2")






        //get size of arrays
        if (flashcardQuestions != null) {
            size = flashcardAnswers!!.size -1
        }

        //display current question and answer in editTextView boxes
        textQuestion.text = flashcardQuestions?.get(index)
        textAnswer.text = flashcardAnswers?.get(index)

        //when Accept is pressed, save flashcard data in arrays
        btnAccept = findViewById(R.id.btn_Accept)
        btnAccept.setOnClickListener {

            //if index ? size, add flashcard to arrays, erase text in question and
            //answer text boxes, increment index

            //else replace flashcard data with input text data and advance index

            //show toast with flashcard added message
            clearSoftKeyboard()
            Toast.makeText(this, "Flashcard Added", Toast.LENGTH_SHORT).show()
        }

        //when next button is pressed, advance index and show data if available, if not
        //show toast of no more flashcards
        btnNext = findViewById(R.id.btn_Next)
        btnNext.setOnClickListener {

            //if index < size, increment index and show array data in the text boxes

            //else clear text boxes, increment index, and wait for user input, show toast
            //with no more flashcard message
            Toast.makeText(this, "There are no more flashcards!",
                Toast.LENGTH_SHORT).show()

            //clear soft keyboard
            clearSoftKeyboard()
        }

        //when previous button is pressed decrement index and show array data in text boxes if
        //available - if not, show toast of no more flashcards
        btnPrevious = findViewById(R.id.btn_Previous)
        btnPrevious.setOnClickListener {

            //if index > 0, decrement index and show array data in the text boxes

            //else show toast with no more flashcards message
            Toast.makeText(this, "There are no more flashcards!",
                Toast.LENGTH_SHORT).show()

            //clear soft keyboard
            clearSoftKeyboard()
        }

        //when delete button is pressed, remove flashcard data from arrays
        btnDelete = findViewById(R.id.btn_Delete)
        btnDelete.setOnClickListener {

            //remove flashcard data from arrays

            //adjust index, if > size clear text boxes

            //clear soft keyboard, show toast with flashcard deleted message
            clearSoftKeyboard()
            Toast.makeText(this, "Flashcard Deleted", Toast.LENGTH_SHORT).show()
        }

        //when quit button is pressed, end activity
        btnDone = findViewById(R.id.btn_Done)
        btnDone.setOnClickListener {

            //if quit is pressed, return to previous activity with new arrays if not null

            //else clear soft keyboard, show toast with flashcard deleted message
            clearSoftKeyboard()
            Toast.makeText(this, "You have no flashcards!", Toast.LENGTH_SHORT).show()
        }
    }

    fun clearSoftKeyboard() {

        //get rid of soft keyboard
        val view = this.currentFocus
        if (view != null) {
            val inputManager = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }
}