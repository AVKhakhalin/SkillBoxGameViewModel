package com.game.android.skillboxgameviewmodel.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.game.android.skillboxgameviewmodel.R
import com.game.android.skillboxgameviewmodel.navigation.Navigation

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            // Загрузка стартового фрагмента
            Navigation.main(supportFragmentManager)
        }
    }
}