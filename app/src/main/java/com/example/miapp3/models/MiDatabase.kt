package com.example.miapp3.models

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class MiDatabase: RoomDatabase() {
    abstract fun UserDao(): UserDao
}