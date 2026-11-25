package com.example.miapp3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int?,
    @ColumnInfo(name = "user_name") val user_name: String,
    @ColumnInfo(name = "last_name") val last_name: String,
)