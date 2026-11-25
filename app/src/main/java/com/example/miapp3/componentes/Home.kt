package com.example.miapp3.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.miapp3.viewmodels.HomeViewModel

@Composable
fun Home(modifier: Modifier,viewmodel: HomeViewModel){
    val userData= viewmodel.userData.observeAsState()
    Column(modifier=Modifier.fillMaxSize()
    , verticalArrangement = Arrangement.Center
    , horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick={
            viewmodel.getUserData()
        }){
            Text(text = "cargar datos")
        }
        userData.value?.let{
            Text(text="Nombre = ${it?.nombre} edad= ${it?.edad} ")
        }
    }
}





