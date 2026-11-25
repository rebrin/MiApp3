package com.example.miapp3.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.room.util.TableInfo
import com.example.miapp3.viewmodels.UserViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screenInicio(navController: NavController,userViewModel: UserViewModel) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "Nuestra app room", color = Color.White, fontWeight = FontWeight.Bold) }
            , colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ) )
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate("agregar")
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "agregar nota")
        }
    
    }) {
        mainContent(it,navController,userViewModel)
    }
}

@Composable
fun mainContent(paddingValues: PaddingValues
                ,navController: NavController
                ,userViewModel: UserViewModel){

    var state=userViewModel.state
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        LazyColumn{
            items(state){
                OutlinedCard(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Text(text = "${it.uid}")
                    Text(text = "${it.user_name}")
                    Text(text = "${it.last_name}")
                    Row(modifier = Modifier.weight(1f)) {
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(onClick = {
                            userViewModel.eliminarUsuario(it)
                        }) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "eliminar")
                        }
                    }
                }
            }
        }
    }
}