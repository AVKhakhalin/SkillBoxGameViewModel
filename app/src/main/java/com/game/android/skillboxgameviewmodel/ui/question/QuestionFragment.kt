package com.game.android.skillboxgameviewmodel.ui.question

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.game.android.skillboxgameviewmodel.R
import com.game.android.skillboxgameviewmodel.core.Game
import com.game.android.skillboxgameviewmodel.model.Question


class QuestionFragment: Fragment() {
    /** Исходные данные */ //region
    private var currentQuestion: Question? = null
    //endregion

    companion object {
        fun newInstance() = QuestionFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_question,
            container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentQuestion = Game.getCurrentQuestion()
        currentQuestion?.let { question ->

            val textView = requireView().findViewById<TextView>(R.id.question_text)
            textView.text = question.question.toString()

            // Динамическое добавление кнопок
            repeat(question.answers.size) { questionIndex ->
                // Создание кнопки
                val answerButton = AppCompatButton(requireContext()).also {
                    it.setOnClickListener {
                        if (question.trueAnswerIndex == questionIndex)
                            Toast.makeText(requireContext(), "Правильный ответ",
                                Toast.LENGTH_SHORT).show()
                        else
                            Toast.makeText(requireContext(), "Не правильный ответ",
                                Toast.LENGTH_SHORT).show()
                    }
                }
                // Настройка кнопки
                answerButton.text = question.answers[questionIndex].answer
                answerButton.setTextColor(Color.BLACK)
                ViewCompat.setBackgroundTintList(answerButton,
                    ContextCompat.getColorStateList(requireContext(), R.color.primary_color))
                // Добавление кнопки в макет
                val linearLayout = requireActivity().findViewById(
                    R.id.buttons_container)
                    as LinearLayoutCompat
                val linearLayoutParams =
                    LinearLayoutCompat.LayoutParams(
                        LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                        LinearLayoutCompat.LayoutParams.WRAP_CONTENT
                    )
                linearLayout.addView(answerButton, linearLayoutParams)
            }
        }
    }
}