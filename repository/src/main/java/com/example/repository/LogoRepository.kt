package com.example.repository

import android.content.Context

interface LogoRepository {
    fun fetchRandomLogos(context: Context, receiver: LogoRepositoryDataReceiver)
}