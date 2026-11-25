package com.example.miapp3.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miapp3.models.UserData
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    var repositorio: MiRepositorio= MiRepositorio()

    private var _userData= MutableLiveData<UserData>()
    var userData: LiveData<UserData> =_userData

    fun getUserData(){
        //corremos una corrutina
        viewModelScope.launch {
            val resultado=repositorio.fetchUserData()
            _userData.postValue(resultado)
        }
    }
}













