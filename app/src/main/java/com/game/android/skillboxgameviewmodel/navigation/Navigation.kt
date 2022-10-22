package com.game.android.skillboxgameviewmodel.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.game.android.skillboxgameviewmodel.R
import com.game.android.skillboxgameviewmodel.ui.description.AnswerDescriptionFragment
import com.game.android.skillboxgameviewmodel.ui.end.EndFragment
import com.game.android.skillboxgameviewmodel.ui.main.MainFragment
import com.game.android.skillboxgameviewmodel.ui.question.QuestionFragment

object Navigation {
    fun main(fragmentManager: FragmentManager) = replace(
        fragmentManager = fragmentManager,
        fragmentClass = MainFragment::class.java,
    )

    fun end(fragmentManager: FragmentManager) = replace(
        fragmentManager = fragmentManager,
        fragmentClass = EndFragment::class.java,
    )

    fun question(fragmentManager: FragmentManager, questionId: Int) = replace(
        fragmentManager = fragmentManager,
        fragmentClass = QuestionFragment::class.java,
        args = QuestionFragment.newInstance(questionId = questionId),
    )

    fun answerDescription(
        fragmentManager: FragmentManager,
        questionId: Int,
        answerId: Int,
    ) = replace(
        fragmentManager,
        AnswerDescriptionFragment::class.java,
        AnswerDescriptionFragment.newInstance(
            questionId = questionId,
            answerId = answerId,
        )
    )

    // Функция смены фрагментов с анимацией
    private fun replace(
        fragmentManager: FragmentManager,
        fragmentClass: Class<out Fragment?>,
        args: Bundle? = null,
    ) {
        fragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.slide_in, R.anim.fade_out)
            .replace(R.id.container, fragmentClass, args)
            .commit()
    }
}