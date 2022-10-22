package com.game.android.skillboxgameviewmodel.core

import android.util.Log
import com.game.android.skillboxgameviewmodel.model.Answer
import com.game.android.skillboxgameviewmodel.model.Question
import com.game.android.skillboxgameviewmodel.utils.FALLING_ANSWER_TEXT
import com.game.android.skillboxgameviewmodel.utils.SUCCESS_ANSWER_TEXT

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
                question = "Проспал ли я собеседование на позицию Android-разработчик?",
                hint = "Никогда не поздно найти новую работу",
                trueAnswerIndex = 1,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "Да",
                        description = "Проспал, но всё равно хочу быть Android-разработчиком",
                    ),
                    Answer(
                        answerId = 1,
                        answer = "Нет",
                        description =
                        "Вовремя проснулся!\nНа hh.ru много вакансий, только нужно подтянуть знания",
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 1,
                question = "Какова алгоритмическая сложность для операций чтения и записи в хеш таблицу (в среднем случае)?",
                hint = "Вопрос по структурам данных и алгоритмам",
                trueAnswerIndex = 1,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "О(log n)",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "O(1)",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 2,
                        answer = "O(n)",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 3,
                        answer = "O(n!)",
                        description = FALLING_ANSWER_TEXT,
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 2,
                question = "Какая структура данных позволяет получить максимальный из хранящихся в ней элементов наиболее оптимальным способом (с наименьшей алгоритмической сложностью в среднем)?",
                hint = "Вопрос по структурам данных и алгоритмам",
                trueAnswerIndex = 2,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "Хэштаблица",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "Связанны список",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 2,
                        answer = "Бинарное дерево поиска",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 3,
                        answer = "Массив",
                        description = FALLING_ANSWER_TEXT,
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 3,
                question = "Каким образом можно выключить k-ый бит в числе?",
                hint = "Вопрос по Java",
                trueAnswerIndex = 1,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "num |= (1<<k)",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "num &= ~(1<<k)",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 2,
                        answer = "num ^=(1<<k)",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 3,
                        answer = "num &=(1>>k)",
                        description = FALLING_ANSWER_TEXT,
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 4,
                question = "Какая ООП-концепция предоставляет только необходимую информацию вызывающим функциям?",
                hint = "Вопрос по Java",
                trueAnswerIndex = 1,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "Абстракция",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "Инкапсуляция",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 2,
                        answer = "Полиморфизм",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 3,
                        answer = "Наследование",
                        description = FALLING_ANSWER_TEXT,
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 5,
                question = "Что из нижеследующего не может использоваться в качестве объекта класса Context?",
                hint = "Вопрос по Android",
                trueAnswerIndex = 3,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "Service",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "Application",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 2,
                        answer = "Activity",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 3,
                        answer = "Fragment",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 6,
                question = "Может ли Android-приложение (отличное от Google Play и других " +
                        "стандартных магазинов приложений) устанавливать другие приложения?",
                hint = "Вопрос по Android",
                trueAnswerIndex = 0,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "Да, если пользователь разрешит установку из этого источника",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "Нет, никогда",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 2,
                        answer = "Да, всегда",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 3,
                        answer = "Да, если прописать необходимое разрешение в манифесте",
                        description = FALLING_ANSWER_TEXT,
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 7,
                question = "Что является уникальным идентификатором приложения для OC Android?",
                hint = "Вопрос по Android",
                trueAnswerIndex = 2,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "Комбинация \"имя приложения + имя пакета\"",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "Имя приложения",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 2,
                        answer = "Имя пакета",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 3,
                        answer = "Комбинация \"имя приложения + издатель\"",
                        description = FALLING_ANSWER_TEXT,
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 8,
                question = "Какой интерфейс предназначен для того, чтобы сохранить объект " +
                        "и потом восстановить его в другом инстансе JVM?",
                hint = "Вопрос по Android",
                trueAnswerIndex = 0,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "Serializable",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "Cloneable",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 2,
                        answer = "Readable",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 3,
                        answer = "Constructable",
                        description = FALLING_ANSWER_TEXT,
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 9,
                question = "Какой интерфейс коллекции стоит выбрать, если необходимо избежать " +
                        "хранения дубликатов и хранить элементы в порядке добавления?",
                hint = "Вопрос по Android",
                trueAnswerIndex = 0,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "Set",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "Map",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 2,
                        answer = "Deque",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 3,
                        answer = "List",
                        description = FALLING_ANSWER_TEXT,
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 10,
                question = "Как можно остановить выполнение запущенной цепочки действий в RxJava?",
                hint = "Вопрос по Android",
                trueAnswerIndex = 2,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "Остановить выполнение невоможно",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "Нужно вызвать cancel у Observable",
                        description = FALLING_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 2,
                        answer = "Нужно использовать Disposable",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 3,
                        answer = "Нужно использовать специальные скоупы",
                        description = FALLING_ANSWER_TEXT,
                    ),
                ),
            )
        )
        questions.add(
            Question(
                questionId = 11,
                question = "По умолчанию Observable является холодным или горячим источником?",
                hint = "Вопрос по Android",
                trueAnswerIndex = 0,
                answers = listOf(
                    Answer(
                        answerId = 0,
                        answer = "Холодным",
                        description = SUCCESS_ANSWER_TEXT,
                    ),
                    Answer(
                        answerId = 1,
                        answer = "Горячим",
                        description = FALLING_ANSWER_TEXT,
                    ),
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