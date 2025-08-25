package ru.ibaevzz.vibehack.data.network.dto

data class UserMeDto(
    val userId: Int,
    val phoneNumber: String,
    val name: String,
    val type: String,
)