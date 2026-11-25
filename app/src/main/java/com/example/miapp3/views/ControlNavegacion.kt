package com.example.miapp3.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.miapp3.viewmodels.UserViewModel

@Composable
fun ControlNavegacion(userViewModel: UserViewModel){
    val navController=rememberNavController()
    NavHost(navController=navController,startDestination="inicio"){
        composable("inicio"){
            //la interfaz de inicio
            screenInicio(navController,userViewModel)
        }

        composable("agregar") {
            //interfaz para insertar
            ScreenAgregar(navController,userViewModel)
        }

        composable("actualizar") {
            //
        }
    }
}








