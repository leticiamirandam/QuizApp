package com.leticiamirandam.quizapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leticiamirandam.quizapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: QuizViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getQuiz()
    }
}