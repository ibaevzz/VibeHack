package ru.ibaevzz.vibehack.data.repo

import ru.ibaevzz.vibehack.domain.model.Task
import ru.ibaevzz.vibehack.domain.model.Volunteer
import ru.ibaevzz.vibehack.domain.model.VolunteerDetails
import ru.ibaevzz.vibehack.domain.model.VolunteerRequestStatus
import ru.ibaevzz.vibehack.domain.model.Ward
import ru.ibaevzz.vibehack.domain.repo.VolunteersRepository
import javax.inject.Inject
import kotlin.Int

class VolunteersRepositoryImpl @Inject constructor(): VolunteersRepository {
    override suspend fun getVolunteers(): Result<List<Volunteer>> {
        return Result.success(mockVolunteers)
    }

    override suspend fun getVolunteerDetails(id: Int): VolunteerDetails {
        TODO("Not yet implemented")
    }

    override suspend fun getTasks(): Result<List<Task>> {
        TODO("Not yet implemented")
    }

    override suspend fun getWards(): Result<List<Ward>> {
        return Result.success(mockWards)
    }

    private val mockVolunteers = listOf(
        Volunteer(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            status = VolunteerRequestStatus.Rejected,
        ),
        Volunteer(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            status = VolunteerRequestStatus.Approved,
        ),
        Volunteer(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            status = VolunteerRequestStatus.Approved,
        ),
        Volunteer(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            status = VolunteerRequestStatus.Rejected,
        ),
        Volunteer(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            status = VolunteerRequestStatus.Rejected,
        )
    )

    private val mockWards = listOf(
        Ward(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            phoneNumber = "+79289851280",
            careerGoals = "Я хочу найти стабильную работу в розничной торговле",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            works = listOf("pewofjcjeopr", "3iefjoier")
        ),
        Ward(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            phoneNumber = "+79289851280",
            careerGoals = "Я хочу найти стабильную работу в розничной торговле",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            works = listOf("pewofjcjeopr", "3iefjoier")
        ),
        Ward(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            phoneNumber = "+79289851280",
            careerGoals = "Я хочу найти стабильную работу в розничной торговле",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            works = listOf("pewofjcjeopr", "3iefjoier")
        ),
        Ward(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            phoneNumber = "+79289851280",
            careerGoals = "Я хочу найти стабильную работу в розничной торговле",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            works = listOf("pewofjcjeopr", "3iefjoier")
        ),
        Ward(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            phoneNumber = "+79289851280",
            careerGoals = "Я хочу найти стабильную работу в розничной торговле",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            works = listOf("pewofjcjeopr", "3iefjoier")
        ),
        Ward(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            phoneNumber = "+79289851280",
            careerGoals = "Я хочу найти стабильную работу в розничной торговле",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            works = listOf("pewofjcjeopr", "3iefjoier")
        ),
        Ward(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            phoneNumber = "+79289851280",
            careerGoals = "Я хочу найти стабильную работу в розничной торговле",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            works = listOf("pewofjcjeopr", "3iefjoier")
        ),
        Ward(
            id = 0,
            name = "Магомед Шариев",
            location = "Москва, Россия",
            phoneNumber = "+79289851280",
            careerGoals = "Я хочу найти стабильную работу в розничной торговле",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            works = listOf("pewofjcjeopr", "3iefjoier")
        ),

    )
}