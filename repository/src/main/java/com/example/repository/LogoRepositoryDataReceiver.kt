package com.example.repository

import com.example.entity.Logo

abstract class LogoRepositoryDataReceiver {
    abstract fun onReceive(logos: List<Logo>)
}