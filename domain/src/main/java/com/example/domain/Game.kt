package com.example.domain

import com.example.entity.Logo
import com.example.entity.Round
import com.example.entity.RoundResult

class Game {
    val rounds: ArrayList<Round>
    var currentRound: Round? = null
    constructor() {
        rounds = arrayListOf()
    }

    fun setResultForRound(result: HashMap<Logo, RoundResult>) {
        currentRound?.result = result
        currentRound?.let { rounds.add(it) }
        currentRound = null
    }

    fun startRound(round: Round) {
        currentRound = round
    }
}