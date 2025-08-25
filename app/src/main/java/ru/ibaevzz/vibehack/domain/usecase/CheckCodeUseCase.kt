package ru.ibaevzz.vibehack.domain.usecase

import ru.ibaevzz.vibehack.domain.repo.UserRepository
import javax.inject.Inject

class CheckCodeUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(code: String, phoneNumber: String) =
        repository.checkCode(code = code, phoneNumber = phoneNumber)
}