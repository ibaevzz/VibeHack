package ru.ibaevzz.vibehack.domain.model

enum class UserType {
    Curator, Ward, Volunteer;

    companion object {
        fun fromString(type: String) =
            UserType.entries.find { it.name.lowercase() == type }
    }
}