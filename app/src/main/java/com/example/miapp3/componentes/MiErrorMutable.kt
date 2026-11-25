package com.example.miapp3.componentes

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MiErrorMutable: ViewModel() {
    var state by mutableStateOf(Midata())
        private set

    fun addItem(){
        //state.items.add("Item ${state.items.size+1}")
        state=state.copy(items = state.items+ "Item ${state.items.size+1}")
        Log.d("Evento de cambio","Item ${state.items.size+1}")
    }

}







