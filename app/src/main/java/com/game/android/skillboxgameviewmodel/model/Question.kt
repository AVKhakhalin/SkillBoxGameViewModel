package com.game.android.skillboxgameviewmodel.model

data class Question(
    val questionId: Int,
    val question: String,
    val hint: String,
    val trueAnswerIndex: Int,
    var answers: List<Answer>
)

