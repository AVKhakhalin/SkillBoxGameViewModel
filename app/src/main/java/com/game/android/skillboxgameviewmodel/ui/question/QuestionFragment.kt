package com.game.android.skillboxgameviewmodel.ui.question

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.game.android.skillboxgameviewmodel.R
import com.game.android.skillboxgameviewmodel.base.BaseFragment
import com.game.android.skillboxgameviewmodel.core.Game
import com.game.android.skillboxgameviewmodel.databinding.FragmentQuestionBinding
import com.game.android.skillboxgameviewmodel.navigation.Navigation
import com.game.android.skillboxgameviewmodel.utils.QUESTION_ID_KEY
import com.game.android.skillboxgameviewmodel.utils.TEXT_SIZE_DOWN_BUTTON
import com.game.android.skillboxgameviewmodel.utils.UNDEAD_MODE
import com.google.android.material.snackbar.Snackbar

class QuestionFragment: BaseFragment<FragmentQuestionBinding>(FragmentQuestionBinding::inflate) {
    /** Исходные данные */ //region
    var questionId: Int = 0
    // Кнопки выбора
    val answerButtons: MutableList<AppCompatButton> = mutableListOf()
    // Режим деактивации кнопок с неправильным ответом
    var isDeactivatedRegimeOn: Boolean = false
    // Инстанс данного фрагмента
    companion object {
        fun newInstance(questionId: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(QUESTION_ID_KEY, questionId)
            return bundle
        }
    }
    //endregion

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionId = requireArguments().getInt(QUESTION_ID_KEY)
        val currentQuestion = Game.getCurrentQuestion(questionId)
        currentQuestion?.let { question ->
            val textView = binding.questionText
            textView.text = question.question
            // Динамическое добавление кнопок
            repeat(question.answers.size) { answerIndex ->
                // Создание кнопки
                val answerButton = AppCompatButton(requireContext()).also { answerButton ->
                    answerButton.setOnClickListener {
                        if (!isDeactivatedRegimeOn) {
                            if (Game.gameRegime != UNDEAD_MODE) {
                                Navigation.answerDescription(
                                    fragmentManager = parentFragmentManager,
                                    questionId = question.questionId,
                                    answerId = answerIndex
                                )
                            } else {
                                if (question.trueAnswerIndex !=
                                    question.answers[answerIndex].answerId) {
                                    Navigation.question(
                                        fragmentManager = parentFragmentManager,
                                        questionId = if (question.questionId > 0)
                                            question.questionId - 1 else 0
                                    )
                                } else {
                                    Navigation.answerDescription(
                                        fragmentManager = parentFragmentManager,
                                        questionId = question.questionId,
                                        answerId = answerIndex
                                    )
                                }
                            }
                        } else {
                            if (question.trueAnswerIndex !=
                                question.answers[answerIndex].answerId) {
                                answerButton.visibility = View.INVISIBLE
                            } else {
                                Navigation.answerDescription(
                                    fragmentManager = parentFragmentManager,
                                    questionId = question.questionId,
                                    answerId = answerIndex
                                )
                            }
                        }
                    }
                }
                answerButtons.add(answerButton)
                // Настройка кнопки
                answerButton.text = question.answers[answerIndex].answer
                answerButton.textSize = TEXT_SIZE_DOWN_BUTTON
                answerButton.setTextColor(Color.BLACK)
                ViewCompat.setBackgroundTintList(answerButton,
                    ContextCompat.getColorStateList(requireContext(), R.color.primary_color))
                answerButton.isAllCaps = false
                // Добавление кнопки в макет
                val linearLayout: LinearLayoutCompat = binding.buttonsContainer
                val linearLayoutParams =
                    LinearLayoutCompat.LayoutParams(
                        LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                        LinearLayoutCompat.LayoutParams.WRAP_CONTENT
                    )
                linearLayout.addView(answerButton, linearLayoutParams)
            }

            // Настрока подсказок
            binding.hintButtonLeft.setOnClickListener {
                Snackbar.make(
                    binding.root,
                    currentQuestion.hint,
                    Snackbar.LENGTH_LONG,
                ).show()
            }
            binding.hintButtonRight.setOnClickListener {
                isDeactivatedRegimeOn = true
                Snackbar.make(
                    binding.root,
                    requireContext().getString(R.string.deactivate_on_hint),
                    Snackbar.LENGTH_LONG,
                ).show()
            }
        }
    }
}