package com.example.miapp3.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MiCorrutinaScope(modifier: Modifier){
    var estado_mensaje by remember { mutableStateOf(10)}
    val scope = rememberCoroutineScope()

    Column(modifier= Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "$estado_mensaje")
        Button(onClick = {
            scope.launch {
                var i=0
                while(i<10){
                    estado_mensaje=i++
                    delay(1000)
                }

//                estado_mensaje="procesando solicitud..."
//                delay(2000)
               // estado_mensaje="completado el evento"
            }
        }) {
            Text(
                text = "presiona evento"
            )
        }
    }
}
