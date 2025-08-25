package ru.ibaevzz.vibehack.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey val id: Int = 0,
    val token: String,
    val type: String?
)