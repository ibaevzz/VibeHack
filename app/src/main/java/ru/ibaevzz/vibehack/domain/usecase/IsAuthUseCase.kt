package ru.ibaevzz.vibehack.domain.usecase

import ru.ibaevzz.vibehack.domain.model.UserType
import ru.ibaevzz.vibehack.domain.repo.UserRepository
import javax.inject.Inject

class GetTypeUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke() : UserType? = userRepository.getType()

}