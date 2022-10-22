package com.game.android.skillboxgameviewmodel.core

import com.game.android.skillboxgameviewmodel.model.Answer
import com.game.android.skillboxgameviewmodel.model.Question

object Game {
    /** Исходные данные */ //region
    // Список вопросов
    private val questions: MutableList<Question> = mutableListOf()
    // Счётчик заданных вопросов
    private var currentQuestionIndex: Int = 0
    //endregion

    // Задание вопросов и их перемешивание
    fun initialiseAndPrepareQuestions() {
        // Добавление вопросов с ответами
        questions.add(
            Question(
                question = "Сколько вам лет?",
                hint = "Нужно указать свой примерный возраст",
                trueAnswerIndex = 0,
                answers = listOf(
                    Answer(
                        answer = "12",
                        description = "Я ещё ребенок",
                        indexAnswer = 0
                    ),
                    Answer(
                        answer = "23",
                        description = "Я уже взрослый",
                        indexAnswer = 1
                    )
                ),
            )
        )
        questions.add(
            Question(
                question = "Где вы живёте?",
                hint = "Нужно указать название своего города",
                trueAnswerIndex = 1,
                answers = listOf(
                    Answer(
                        answer = "г. Москва",
                        description = "Большой город",
                        indexAnswer = 0
                    ),
                    Answer(
                        answer = "г. Коломна",
                        description = "Красивый город",
                        indexAnswer = 1
                    )
                ),
            )
        )
        // Случайное перемешивание вопросов
        questions.shuffle()
    }

    // Получение текущего вопроса
    fun getCurrentQuestion(): Question? {
        return if (currentQuestionIndex + 1 <= questions.size - 1)
            questions[currentQuestionIndex++]
        else
            null
    }
}