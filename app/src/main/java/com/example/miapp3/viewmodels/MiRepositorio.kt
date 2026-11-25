package com.example.miapp3.viewmodels

import com.example.miapp3.models.UserData
import kotlinx.coroutines.delay

class MiRepositorio {
    //corrutina
    suspend fun fetchUserData(): UserData{
        delay(3000)
        return UserData("jhon doe",23)
    }
}