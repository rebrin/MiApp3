package com.example.miapp3.componentes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FalloComposable(modifier: Modifier,viewmodel: MiErrorMutable){
    val estado=viewmodel.state
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp),
        ) {
        item{
            Text(text = estado.title, fontSize = 24.sp)
            Spacer(modifier= Modifier.height(16.dp))
        }
        //seccion donde iteramos los valores del estado
        items(estado.items){
            Text(text = it)
        }

        item{
            Button(onClick = {viewmodel.addItem()}
                , modifier = Modifier.fillMaxWidth()) {
                Text(text = "agregar item")
            }
        }
    }

}