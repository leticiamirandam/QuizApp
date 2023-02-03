package com.leticiamirandam.quizapp.data.repository

import com.leticiamirandam.quizapp.data.datasource.QuizRemoteDataSource
import com.leticiamirandam.quizapp.data.model.QuizResponse
import com.leticiamirandam.quizapp.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow

internal class QuizRepositoryImpl(
    private val dataSource: QuizRemoteDataSource,
) : QuizRepository {
    override fun getQuiz(category: String, difficulty: String): Flow<QuizResponse> =
        dataSource.getQuiz(category, difficulty)
}