package com.game.android.skillboxgameviewmodel.core

import android.util.Log
import com.game.android.skillboxgameviewmodel.model.Answer
import com.game.android.skillboxgameviewmodel.model.Question

object Game {
    /** Исходные данные */ //region
    // Индекс стартового вопроса
    val startQuestionId: Int = 0
    // Список вопросов
    var questions: MutableList<Question> = mutableListOf()
    //endregion

    // Задание вопросов и их перемешивание
    fun initialiseAndPrepareQuestions() {
        // Добавление вопросов с ответами
        questions.add(
            Question(
                questionId = 0,
                question = "Сколько вам лет?",
                hint = "Нужно указать свой примерный возраст",
                trueAnswerIndex = 0,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "12",
                        description = "Я ещё ребенок",
                    ),
                    Answer(
                        answerId = 1,
                        answer = "23",
                        description = "Я уже взрослый",
                    ),
                    Answer(
                        answerId = 1,
                        answer = "43",
                        description = "Я уже очень взрослый",
                    ),
                    Answer(
                        answerId = 1,
                        answer = "53",
                        description = "Я уже старый",
                    ),
                    Answer(
                        answerId = 1,
                        answer = "63",
                        description = "Я уже супер старый",
                    )
                ),
            )
        )
        questions.add(
            Question(
                questionId = 1,
                question = "Где вы живёте?",
                hint = "Нужно указать название своего города",
                trueAnswerIndex = 0,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "г. Москва",
                        description = "Большой город",
                    ),
                    Answer(
                        answerId = 1,
                        answer = "г. Коломна",
                        description = "Красивый город",
                    )
                ),
            )
        )
        // Случайное перемешивание ответов
        questions.forEachIndexed { index, questions ->
            val newQuestions = questions.answers.shuffled()
            questions.answers = newQuestions
        }
    }

    // Получение текущего вопроса
    fun getCurrentQuestion(questionId: Int): Question? {
        return if (questionId <= questions.size - 1)
            questions[questionId]
        else
            null
    }
}