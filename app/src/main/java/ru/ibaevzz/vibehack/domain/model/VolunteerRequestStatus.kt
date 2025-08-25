package ru.ibaevzz.vibehack.domain.model

enum class VolunteerRequestStatus {
    Pending, Approved, Rejected;

    companion object {
        fun fromString(status: String) =
            VolunteerRequestStatus.entries.find { it.name.lowercase() == status }
    }
}