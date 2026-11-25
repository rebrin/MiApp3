package com.example.miapp3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.miapp3.componentes.FalloComposable
import com.example.miapp3.componentes.Home
import com.example.miapp3.componentes.MiCorrutinaScope
import com.example.miapp3.componentes.MiErrorMutable
import com.example.miapp3.componentes.PruebaCorrutina
import com.example.miapp3.models.MiDatabase
import com.example.miapp3.models.User
import com.example.miapp3.ui.theme.MiApp3Theme
import com.example.miapp3.viewmodels.HomeViewModel
import com.example.miapp3.viewmodels.UserViewModel
import com.example.miapp3.views.ControlNavegacion
import com.example.miapp3.views.screenInicio

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiApp3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   /* Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
//                    val viewmodel by viewModels<MiErrorMutable>()
//                    FalloComposable(modifier = Modifier.padding(innerPadding),viewmodel)
//                    PruebaCorrutina(modifier = Modifier.padding(innerPadding))
                   // MiCorrutinaScope(modifier = Modifier.padding(innerPadding))
                  //  val homeViewModel= ViewModelProvider(this)[HomeViewModel::class]
                 //   Home(modifier = Modifier.padding(innerPadding),homeViewModel)
                    var context= LocalContext.current
//  corregir esta linea
                    var database=Room.databaseBuilder(context, MiDatabase::class.java,"db-user").build()
                    var userdao=database.UserDao()
                    var userViewModel= UserViewModel(userdao)
                    ControlNavegacion(userViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiApp3Theme {
        Greeting("Android")
    }
}