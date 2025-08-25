package ru.ibaevzz.vibehack.domain.model

data class Task(
    val name: String,
    val inProgress: Boolean,
    val description: String?,
)