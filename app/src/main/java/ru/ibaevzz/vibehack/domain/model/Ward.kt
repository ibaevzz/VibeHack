package ru.ibaevzz.vibehack.domain.model

data class Ward(
    val id: Int,
    val name: String,
    val location: String,
    val phoneNumber: String,
    val careerGoals: String,
    val skills: List<String>,
    val works: List<String>
)