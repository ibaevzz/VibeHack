package ru.ibaevzz.vibehack.data.repo

import ru.ibaevzz.vibehack.R
import ru.ibaevzz.vibehack.data.db.dao.UserDao
import ru.ibaevzz.vibehack.data.db.entities.UserEntity
import ru.ibaevzz.vibehack.data.network.api.UserApi
import ru.ibaevzz.vibehack.data.network.requests.CheckCodeRequest
import ru.ibaevzz.vibehack.data.network.requests.SendCodeRequest
import ru.ibaevzz.vibehack.domain.model.UserType
import ru.ibaevzz.vibehack.domain.repo.UserRepository
import ru.ibaevzz.vibehack.utils.ResourceUtils
import ru.ibaevzz.vibehack.utils.safeCallApi
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val userDao: UserDao,
    private val resourceUtils: ResourceUtils,
): UserRepository {

    override suspend fun sendCode(phoneNumber: String): Result<String> = safeCallApi {
        val response = userApi.sendCode(SendCodeRequest(phoneNumber))

        if (!response.isSuccessful)
            return Result.failure(Exception(resourceUtils.getString(R.string.backend_error)))

        val code = response.body()?.code
            ?: return Result.failure(Exception(resourceUtils.getString(R.string.backend_error)))

        return Result.success(code)
    }

    override suspend fun checkCode(
        code: String,
        phoneNumber: String
    ): Result<Boolean> = safeCallApi {
        val checkCodeResponse = userApi.checkCode(CheckCodeRequest(code = code, phoneNumber = phoneNumber))

        if (!checkCodeResponse.isSuccessful)
            return Result.failure(Exception(resourceUtils.getString(R.string.backend_error)))

        val success = checkCodeResponse.body()?.success
            ?: return Result.failure(Exception(resourceUtils.getString(R.string.backend_error)))
        if (!success) return Result.success(false)

        val token = checkCodeResponse.body()?.token
            ?: return Result.failure(Exception(resourceUtils.getString(R.string.backend_error)))
        userDao.insertUser(UserEntity(token = token, type = null))

        val userMeResponse = userApi.usersMe()

        if (!userMeResponse.isSuccessful)
            return Result.failure(Exception(resourceUtils.getString(R.string.backend_error)))

        val type = userMeResponse.body()?.type
            ?: return Result.failure(Exception(resourceUtils.getString(R.string.backend_error)))
        userDao.insertUser(UserEntity(token = token, type = type))

        return Result.success(true)
    }

    override suspend fun getType(): UserType? {
        return userDao.getType()?.let { UserType.fromString(it) }
    }

}