package com.example.miapp3.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun PruebaCorrutina(modifier: Modifier){
    var estado_mensaje by remember { mutableStateOf("cargando ...")}
    Column(modifier= Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        LaunchedEffect(key1 = estado_mensaje) {
            estado_mensaje=llamada_asincrona()
        }
        Text(text = "$estado_mensaje")
    }
}

suspend fun llamada_asincrona(): String{
    delay(5000)
    return "data cargada desde llamada asincrona"
}