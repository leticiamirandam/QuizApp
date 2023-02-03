package com.leticiamirandam.quizapp.data.datasource

import com.leticiamirandam.quizapp.data.api.QuizService
import kotlinx.coroutines.flow.flow

internal class QuizRemoteDataSourceImpl(
    private val service: QuizService
): QuizRemoteDataSource {
    override fun getQuiz(category: String, difficulty: String) = flow {
        emit(service.getQuiz(category, difficulty))
    }
}