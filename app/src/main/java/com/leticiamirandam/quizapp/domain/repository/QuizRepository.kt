package com.leticiamirandam.quizapp.domain.repository

import com.leticiamirandam.quizapp.data.model.QuizResponse
import kotlinx.coroutines.flow.Flow

internal interface QuizRepository {
    fun getQuiz(category: String, difficulty: String): Flow<QuizResponse>
}