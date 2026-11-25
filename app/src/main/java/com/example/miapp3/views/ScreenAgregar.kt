package com.example.miapp3.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.miapp3.models.User
import com.example.miapp3.viewmodels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAgregar(navController: NavController, userViewModel: UserViewModel ) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "inicio", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors =
                    TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack() //sacamos de la pila el elemento
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "regresar")
                    }
                })
        },
    ) {
        //contenido principal
        contenidoAgregar(it, navController, userViewModel)
    }
}

@Composable
fun contenidoAgregar(
    it: PaddingValues,
    controller: NavController,
    model: UserViewModel
) {
    var stateNombre by remember { mutableStateOf("") }
    var stateLastName by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(paddingValues = it)
            .padding(30.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            OutlinedTextField(
                value = stateNombre,
                onValueChange = { stateNombre = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .padding(bottom = 30.dp), label = { Text("Nombre") }
            )
            OutlinedTextField(
                value = stateLastName,
                onValueChange = { stateLastName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .padding(bottom = 30.dp), label = { Text("Apellido") }
            )
            Button(onClick = {///todo aqui
                val userInsert= User(uid = null,user_name =stateNombre, last_name = stateLastName )
                model.crearUsuario(userInsert)
                controller.popBackStack()
            }) {
                Text("agregar Usuario")
            }
        }
    }
}