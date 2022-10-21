package com.game.android.skillboxgameviewmodel.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.game.android.skillboxgameviewmodel.Game
import com.game.android.skillboxgameviewmodel.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = requireView().findViewById<TextView>(R.id.logo_game_name)
        textView.text = Game.title

        val button = requireView().findViewById<AppCompatButton>(R.id.button_start_game)
        button.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, QuestionFragment.newInstance())
                .commit()
        }
    }

}