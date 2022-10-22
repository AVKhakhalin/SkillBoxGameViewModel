package com.game.android.skillboxgameviewmodel.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.game.android.skillboxgameviewmodel.base.BaseFragment
import com.game.android.skillboxgameviewmodel.core.Game
import com.game.android.skillboxgameviewmodel.databinding.FragmentMainBinding
import com.game.android.skillboxgameviewmodel.navigation.Navigation
import com.game.android.skillboxgameviewmodel.utils.UNDEAD_MODE

class MainFragment: BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    /** Исходные данные */ //region
    // Создание самой игры
    private val game: Game = Game
    // Создание ViewModel
    private lateinit var viewModel: MainViewModel
    // Инстанс данного класса
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonNormal = binding.buttonStartGame
        buttonNormal.setOnClickListener {
            Navigation.question(
                fragmentManager = parentFragmentManager,
                questionId = Game.startQuestionId
            )
        }
        val buttonUndead = binding.buttonStartUndeadGame
        buttonUndead.setOnClickListener {
            game.gameRegime = UNDEAD_MODE
            Navigation.question(
                fragmentManager = parentFragmentManager,
                questionId = Game.startQuestionId
            )
        }
    }
}