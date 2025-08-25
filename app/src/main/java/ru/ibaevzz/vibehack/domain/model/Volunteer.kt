package ru.ibaevzz.vibehack.domain.model

data class Volunteer(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val status: VolunteerRequestStatus,
    val location: String,
    val skills: List<String>,
)