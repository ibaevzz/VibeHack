package ru.ibaevzz.vibehack.data.network.dto

data class VolunteerRequestDto(
    val id: Int,
    val name: String,
    val status: String,
    val createdAt: String
)