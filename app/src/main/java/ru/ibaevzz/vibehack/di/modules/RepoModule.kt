package ru.ibaevzz.vibehack.di.modules

import dagger.Binds
import dagger.Module
import ru.ibaevzz.vibehack.data.repo.UserRepositoryImpl
import ru.ibaevzz.vibehack.domain.repo.UserRepository

@Module
abstract class RepoModule {

    @Binds
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository

}