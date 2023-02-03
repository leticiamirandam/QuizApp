package com.leticiamirandam.quizapp.data.datasource

import com.leticiamirandam.quizapp.data.model.QuizResponse
import kotlinx.coroutines.flow.Flow

internal interface QuizRemoteDataSource {
    fun getQuiz(category: String, difficulty: String): Flow<QuizResponse>
}