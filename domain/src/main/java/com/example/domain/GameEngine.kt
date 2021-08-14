package com.example.domain

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.entity.Logo
import com.example.entity.Round
import com.example.entity.RoundResult
import com.example.repository.LogoRepository
import com.example.repository.LogoRepositoryDataReceiver
import com.example.repository.LogoRepositoryImpl
import java.lang.Exception
import java.lang.ref.WeakReference

class GameEngine {
    val logoRepository: LogoRepository
    var currentGame: Game? = null
    val liveData: MutableLiveData<Game> = MutableLiveData<Game>();
    val context: WeakReference<Context>

    constructor(context: Context) {
        logoRepository = LogoRepositoryImpl()
        this.context = WeakReference(context)
    }

    fun startGame() {
        if(currentGame != null){
            throw Exception("game cannot be started again")
        }

        currentGame = Game()
        notifyData()
    }

    fun startRound() {
        if(currentGame?.currentRound != null){
            throw Exception("round cannot be started again")
        }

        context.get()?.let {
            logoRepository.fetchRandomLogos(it, object: LogoRepositoryDataReceiver() {
                override fun onReceive(logos: List<Logo>) {
                    currentGame?.startRound(Round(logos, hashMapOf()))
                }
            })
        }
    }

    fun stopRound(result: HashMap<Logo,RoundResult>) {
        if(currentGame?.currentRound == null){
            throw Exception("round cannot be stopped as it is not even started")
        }
        setResultForRound(result)
    }

    fun stopGame() {
        if(currentGame == null){
            throw Exception("game cannot be stopped as it is not even started")
        }

        if(currentGame?.currentRound != null){
            throw Exception("please stop the currentRound first")
        }
    }

    fun getGameLiveData(): LiveData<Game> {
        return liveData
    }

    fun setResultForRound(result: HashMap<Logo,RoundResult>) {
        currentGame?.setResultForRound(result)
        notifyData()
    }

    fun notifyData() {
        liveData.postValue(currentGame)
    }
}