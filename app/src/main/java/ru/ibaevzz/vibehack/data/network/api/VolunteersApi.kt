package ru.ibaevzz.vibehack.data.network.api

import retrofit2.Response
import retrofit2.http.GET
import ru.ibaevzz.vibehack.data.network.dto.GetAllVolunteersDto
import ru.ibaevzz.vibehack.data.network.dto.VolunteerRequestDto

interface VolunteersApi {

    @GET("/curator/volunteers")
    fun getAllVolunteers(): Response<List<GetAllVolunteersDto>>

    @GET("/curator/volunteer-requests")
    fun getVolunteerRequest(): Response<List<VolunteerRequestDto>>

}