package ru.ibaevzz.vibehack.domain.repo

import ru.ibaevzz.vibehack.domain.model.Task
import ru.ibaevzz.vibehack.domain.model.Volunteer
import ru.ibaevzz.vibehack.domain.model.VolunteerDetails

interface VolunteersRepository {

    suspend fun getVolunteers(): Result<List<Volunteer>>

    suspend fun getVolunteerDetails(id: Int): VolunteerDetails

    suspend fun getTasks() : Result<List<Task>>

}