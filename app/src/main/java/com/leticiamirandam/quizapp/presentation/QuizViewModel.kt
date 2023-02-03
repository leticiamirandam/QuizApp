package com.leticiamirandam.quizapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leticiamirandam.quizapp.data.model.QuizResponse
import com.leticiamirandam.quizapp.domain.usecase.GetQuizUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

internal class QuizViewModel(
    private val getQuizUseCase: GetQuizUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    fun getQuiz() {
        viewModelScope.launch {
            getQuizUseCase("DevOps", "Easy")
                .flowOn(dispatcher)
                .catch { showError(it) }
                .collect { logQuizResponse(it) }
        }
    }

    private fun showError(throwable: Throwable) {
        throwable.message.let {
            Log.i("Erro: ", throwable.message!!)
        }
    }

    private fun logQuizResponse(response: QuizResponse) {
        Log.i("QUIZ RESPONSE: ", response.toString())
    }
}