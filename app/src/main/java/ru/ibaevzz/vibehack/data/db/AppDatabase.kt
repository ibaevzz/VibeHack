package ru.ibaevzz.vibehack.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.ibaevzz.vibehack.data.db.dao.UserDao
import ru.ibaevzz.vibehack.data.db.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}