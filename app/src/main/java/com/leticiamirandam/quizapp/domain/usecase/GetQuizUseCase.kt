package com.leticiamirandam.quizapp.domain.usecase

import com.leticiamirandam.quizapp.data.model.QuizResponse
import com.leticiamirandam.quizapp.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow

internal class GetQuizUseCase(
    private val repository: QuizRepository,
) {
    operator fun invoke(category: String, difficulty: String): Flow<QuizResponse> =
        repository.getQuiz(category, difficulty)
}