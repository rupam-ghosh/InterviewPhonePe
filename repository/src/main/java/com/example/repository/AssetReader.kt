package com.example.repository

import android.content.Context
import java.io.InputStream

class AssetReader {
    fun readAsset(context: Context, fileName: String): String {
        val inputStream: InputStream = context.assets.open(fileName)
        return inputStream.bufferedReader().use{it.readText()}
    }
}