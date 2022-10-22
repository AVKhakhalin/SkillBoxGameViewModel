package com.game.android.skillboxgameviewmodel.model

sealed class AppState {
    data class Success(val question: List<Question>): AppState()
    data class Error(val error: Throwable): AppState()
    data class Loading(val progress: Int?): AppState()
}