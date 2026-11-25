package com.example.miapp3.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miapp3.models.User
import com.example.miapp3.models.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//es quien actualiza sus composables
//se encarga de notificar los datos
class UserViewModel(var userDao: UserDao): ViewModel() {
    var state= mutableStateListOf<User>()

    init {
        viewModelScope.launch {
            userDao.getAllUsers().collectLatest {
                state.clear()
                state+=it
            }
        }
    }

    fun traerUnUsuario(id:Int){
      viewModelScope.launch(Dispatchers.IO) {
          userDao.getUserByID(id)
      }
    }

    fun crearUsuario(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            userDao.insertaUser(user)
        }
    }
    fun eliminarUsuario(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            userDao.deleteUser(user)
        }
    }

    fun actualizarUsuario(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            userDao.actualizarUsuario(user)
        }
    }
}











