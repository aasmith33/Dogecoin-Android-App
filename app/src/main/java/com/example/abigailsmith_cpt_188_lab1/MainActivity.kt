package com.example.abigailsmith_cpt_188_lab1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val Tag = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_doge, true),
        Question(R.string.question_blockchain, true) ,
        Question(R.string.question_shiba, false),
        Question(R.string.question_created, true),
        Question(R.string.question_elon, false),
        Question(R.string.question_billy, true))

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Tag, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        updateQuestion()
    }

    override fun onStart() {
        super.onStart()
        Log.d(Tag, "onStart() called")
    }
    override fun onResume(){
        super.onResume()
        Log.d(Tag, "onResume() called")
    }
    override fun onPause(){
        super.onPause()
        Log.d(Tag, "onPause() called")
    }
    override fun onStop(){
        super.onStop()
        Log.d(Tag, "onStop() called")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(Tag, "onDestroy() called")
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            val correctToast = R.string.correct_toast
            correctToast
        } else {
            val incorrectToast = R.string.incorrect_toast
            incorrectToast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
        }
    }

