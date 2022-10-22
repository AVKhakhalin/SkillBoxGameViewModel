package com.game.android.skillboxgameviewmodel.ui.end

import android.os.Bundle
import android.view.View
import com.game.android.skillboxgameviewmodel.base.BaseFragment
import com.game.android.skillboxgameviewmodel.databinding.FragmentEndBinding
import kotlin.system.exitProcess

class EndFragment: BaseFragment<FragmentEndBinding>(FragmentEndBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.exitButton.setOnClickListener { exitProcess(0) }
    }
}