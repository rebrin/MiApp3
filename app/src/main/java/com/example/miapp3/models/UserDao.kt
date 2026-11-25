package com.example.miapp3.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

//consultas y acciones que realizamos
@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM User WHERE uid=:uid")
    fun getUserByID(uid:Int): Flow<User>

    @Insert
    fun insertaUser(vararg u:User)

    @Update
    fun actualizarUsuario(user: User)

    @Delete
    fun deleteUser(user:User)
}










