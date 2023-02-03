package com.leticiamirandam.quizapp.data.model

class QuizResponse : ArrayList<QuizResponseItem>()

data class QuizResponseItem(
    val answers: Answers,
    val category: String,
    val correct_answers: CorrectAnswers,
    val description: String,
    val difficulty: String,
    val explanation: String,
    val id: Int,
    val multiple_correct_answers: String,
    val question: String,
    val tags: List<Any>,
    val tip: Any
)

data class Answers(
    val answer_a: String,
    val answer_b: String,
    val answer_c: String,
    val answer_d: String,
    val answer_e: Any,
    val answer_f: Any
)

data class CorrectAnswers(
    val answer_a_correct: String,
    val answer_b_correct: String,
    val answer_c_correct: String,
    val answer_d_correct: String,
    val answer_e_correct: String,
    val answer_f_correct: String
)