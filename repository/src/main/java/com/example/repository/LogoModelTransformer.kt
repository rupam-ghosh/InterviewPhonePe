package com.example.repository

import com.example.entity.Logo
import com.example.repository.gson.LogoModel
import java.util.stream.Collectors

class LogoModelTransformer {
    companion object {
        fun convertToLogos(models: List<LogoModel>): List<Logo>? {
            return models.stream()
                .filter { elt -> elt != null }
                .map { elt -> Logo(elt.imgUrl, elt.name) }
                .collect(Collectors.toList())
        }
    }
}