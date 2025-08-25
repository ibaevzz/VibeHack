package ru.ibaevzz.vibehack.data.network.requests

data class CheckCodeRequest(
    val phoneNumber: String,
    val code: String
)