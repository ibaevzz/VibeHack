package ru.ibaevzz.vibehack.data.network.api

import kotlinx.coroutines.delay
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.ibaevzz.vibehack.data.network.dto.CheckCodeDto
import ru.ibaevzz.vibehack.data.network.dto.SendCodeDto
import ru.ibaevzz.vibehack.data.network.dto.UserMeDto
import ru.ibaevzz.vibehack.data.network.requests.CheckCodeRequest
import ru.ibaevzz.vibehack.data.network.requests.SendCodeRequest

interface UserApi {

    @POST("/users/send-verification-code")
    suspend fun sendCode(@Body request: SendCodeRequest): Response<SendCodeDto>

    @POST("/users/check-code")
    suspend fun checkCode(@Body request: CheckCodeRequest): Response<CheckCodeDto>

    @GET("/users/me")
    suspend fun usersMe(): Response<UserMeDto>

}

object MockUserApi: UserApi {
    override suspend fun sendCode(request: SendCodeRequest): Response<SendCodeDto> {
        delay(1000)
        return Response.success(SendCodeDto(code = "12345"))
    }

    override suspend fun checkCode(request: CheckCodeRequest): Response<CheckCodeDto> {
        delay(1000)
        return Response.success(CheckCodeDto(success = true, token = "token"))
    }

    override suspend fun usersMe(): Response<UserMeDto> {
        delay(1000)
        return Response.success(
            UserMeDto(
                userId = 0,
                phoneNumber = "+79289851280",
                name = "Zubai",
                type = "ward"
            )
        )
    }

}