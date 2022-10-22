package com.game.android.skillboxgameviewmodel.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.game.android.skillboxgameviewmodel.core.Game
import com.game.android.skillboxgameviewmodel.R
import com.game.android.skillboxgameviewmodel.ui.question.QuestionFragment

class MainFragment: Fragment() {
    /** Исходные данные */ //region
    // Создание самой игры
    private val game: Game = Game
    // Создание ViewModel
    private lateinit var viewModel: MainViewModel
    companion object {
        fun newInstance() = MainFragment()
    }
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Инициализация списка вопросов
        game.initialiseAndPrepareQuestions()
        // Инициализация ViewModel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val textView = requireView().findViewById<TextView>(R.id.logo_game_name)
//        textView.text = Game().title

        val button = requireView().findViewById<AppCompatButton>(R.id.button_start_game)
        button.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, QuestionFragment.newInstance())
                .commit()
        }
    }

}