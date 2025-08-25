package ru.ibaevzz.vibehack.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.ibaevzz.vibehack.data.db.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT token FROM user_table WHERE id = 0")
    suspend fun getToken(): String?

    @Query("DELETE FROM user_table")
    suspend fun clearUser()

    @Query("SELECT type FROM user_table WHERE id = 0")
    suspend fun getType(): String?

}