package com.game.android.skillboxgameviewmodel.ui.description

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.game.android.skillboxgameviewmodel.base.BaseFragment
import com.game.android.skillboxgameviewmodel.core.Game
import com.game.android.skillboxgameviewmodel.databinding.FragmentAnswerDescriptionBinding
import com.game.android.skillboxgameviewmodel.model.Answer
import com.game.android.skillboxgameviewmodel.model.Question
import com.game.android.skillboxgameviewmodel.navigation.Navigation
import com.game.android.skillboxgameviewmodel.utils.ANSWER_ID_KEY
import com.game.android.skillboxgameviewmodel.utils.QUESTION_ID_KEY

class AnswerDescriptionFragment:
    BaseFragment<FragmentAnswerDescriptionBinding>(FragmentAnswerDescriptionBinding::inflate) {
    /** Исходные данные */ //region
    companion object {
        fun newInstance(questionId: Int, answerId: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(QUESTION_ID_KEY, questionId)
            bundle.putInt(ANSWER_ID_KEY, answerId)
            return bundle
        }
    }
    //endregion

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionId: Int = requireArguments().getInt(QUESTION_ID_KEY)
        val answerId: Int = requireArguments().getInt(ANSWER_ID_KEY)
        val question = Game.questions[questionId]
        val answer = question.answers[answerId]

        binding.message.text = answer.description
        binding.continueButton.setOnClickListener { processAnswer(question, answer) }
    }

    private fun processAnswer(question: Question, answer: Answer) {
        when (answer.answerId) {
            question.trueAnswerIndex -> {
                if (question.questionId <= Game.questions.size - 1) {
                    if (question.questionId + 1 <= Game.questions.size - 1)
                        Navigation.question(parentFragmentManager, question.questionId + 1)
                    else
                        Navigation.end(parentFragmentManager)
                } else {
                    Navigation.end(parentFragmentManager)
                }
            }
            else -> {
                Navigation.question(parentFragmentManager, Game.startQuestionId)
            }
        }
    }
}