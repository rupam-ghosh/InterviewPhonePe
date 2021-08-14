package com.example.phonepeinterview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.domain.Game
import com.example.domain.GameEngine
import com.example.entity.Logo
import com.example.entity.RoundResult

class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val gameEngine: GameEngine
    init {
        gameEngine = GameEngine(application)
        gameEngine.startGame()
    }

    fun getGameLiveData(): LiveData<Game> {
        return gameEngine.getGameLiveData()
    }

    fun stopGame() {
        gameEngine.stopGame()
    }

    fun startRound() {
        gameEngine.startRound()
    }

    fun stopRound(result: HashMap<Logo, RoundResult>) {
        gameEngine.stopRound(result)
    }
}