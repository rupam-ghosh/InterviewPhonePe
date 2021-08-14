package com.example.domain

import com.example.entity.Round

abstract class GameDataReceiver {
    abstract fun onReceive(logos: Round)
}