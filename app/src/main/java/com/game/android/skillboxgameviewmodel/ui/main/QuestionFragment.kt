package com.game.android.skillboxgameviewmodel.ui.main

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.game.android.skillboxgameviewmodel.Game
import com.game.android.skillboxgameviewmodel.R

class QuestionFragment: Fragment() {

    companion object {
        fun newInstance() = QuestionFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = requireView().findViewById<TextView>(R.id.question_text)
        val animator = ObjectAnimator.ofFloat(
            textView,
            "alpha",
            0F
        )
        animator.duration = 2_000
        animator.start()
    }
}