package ru.ibaevzz.vibehack.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.ibaevzz.vibehack.data.db.AppDatabase
import ru.ibaevzz.vibehack.data.db.dao.UserDao
import ru.ibaevzz.vibehack.utils.DATABASE_NAME
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

}