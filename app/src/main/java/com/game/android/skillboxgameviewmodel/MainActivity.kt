package com.game.android.skillboxgameviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.game.android.skillboxgameviewmodel.core.Game
import com.game.android.skillboxgameviewmodel.ui.main.MainFragment

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {

            // Загрузка стартового фрагмента
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}