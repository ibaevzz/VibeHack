package ru.ibaevzz.vibehack.domain.repo

import ru.ibaevzz.vibehack.domain.model.Volunteer
import ru.ibaevzz.vibehack.domain.model.VolunteerDetails

interface VolunteersRepository {

    fun getVolunteers(): Result<List<Volunteer>>

    fun getVolunteerDetails(id: Int): VolunteerDetails

}