package ru.ibaevzz.vibehack.domain.model

data class VolunteerDetails(
    val id: Int,
    val name: String,
    val location: String,
    val skills: List<String>,
    val wards: List<Ward>
)