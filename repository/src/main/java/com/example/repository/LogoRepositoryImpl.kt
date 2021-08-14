package com.example.repository

import android.content.Context
import com.example.repository.gson.LogoModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LogoRepositoryImpl: LogoRepository {
    override fun fetchRandomLogos(context: Context, receiver: LogoRepositoryDataReceiver) {
        val itemListJsonString = AssetReader().readAsset(context, "logo-response.txt")
        val gson = Gson()
        val itemType = object : TypeToken<List<LogoModel>>() {}.type
        val itemList: List<LogoModel> = gson.fromJson<List<LogoModel>>(itemListJsonString, itemType)
        val logos = LogoModelTransformer.convertToLogos(itemList)
        if (logos != null) {
            receiver.onReceive(logos)
        }
    }
}