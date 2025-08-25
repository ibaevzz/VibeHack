package ru.ibaevzz.vibehack.domain.repo

import ru.ibaevzz.vibehack.domain.model.UserType

interface UserRepository {

    suspend fun sendCode(phoneNumber: String): Result<String>

    suspend fun checkCode(code: String, phoneNumber: String): Result<Boolean>

    suspend fun getType(): UserType?

}