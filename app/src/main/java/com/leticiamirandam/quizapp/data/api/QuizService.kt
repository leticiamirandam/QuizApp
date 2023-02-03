package com.leticiamirandam.quizapp.data.api

import com.leticiamirandam.quizapp.data.model.QuizResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizService {

    @GET("questions")
    suspend fun getQuiz(
        @Query("category") category: String,
        @Query("difficulty") difficulty: String
    ): QuizResponse
}