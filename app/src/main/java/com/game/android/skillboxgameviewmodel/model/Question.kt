package com.game.android.skillboxgameviewmodel.model

data class Question(
    val question: String,
    val hint: String,
    val trueAnswerIndex: Int,
    val answers: List<Answer>
)

