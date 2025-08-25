package ru.ibaevzz.vibehack.domain.usecase

import ru.ibaevzz.vibehack.domain.repo.UserRepository
import javax.inject.Inject

class SendCodeUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(phoneNumber: String) =
        repository.sendCode(phoneNumber)
}