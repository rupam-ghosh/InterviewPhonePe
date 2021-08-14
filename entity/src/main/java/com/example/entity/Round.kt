package com.example.entity

data class Round(val questions: List<Logo>, var result: HashMap<Logo,RoundResult>)
