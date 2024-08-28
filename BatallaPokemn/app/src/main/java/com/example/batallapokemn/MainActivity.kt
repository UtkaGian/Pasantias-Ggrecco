package com.example.batallapokemn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.batallapokemn.ui.theme.BatallaPokemónTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tipoAtacante= "Agua"
        var tipoDefensor= "Fuego"
        var ataque= 80
        var defensa= 60
        var efectivo=efectividad(tipoAtacante, tipoDefensor)
        var fuerza= daño(ataque, defensa, efectivo)
        println("El daño del primer turno fue de: $fuerza")
        tipoAtacante= "Fuego"
        tipoDefensor= "Agua"
        ataque= 120
        defensa= 215
        efectivo=efectividad(tipoAtacante, tipoDefensor)
        fuerza= daño(ataque, defensa, efectivo)
        println("El daño del segundo turno fue de: $fuerza")
    }
    private fun efectividad(tipoAtacante: String, tipoDefensor: String): Double{
        return when(tipoAtacante){
            "Agua"-> when(tipoDefensor){
                "Planta"-> 2.0
                "Agua"-> 0.5
                else-> 1.0
            }
            "Planta"-> when(tipoDefensor){
                "Agua"-> 2.0
                "Fuego"-> 0.5
                else-> 1.0
            }
            "Fuego"-> when(tipoDefensor){
                "Planta"-> 2.0
                "Agua"-> 0.5
                else-> 1.0
            }
            "Eléctrico"-> when(tipoDefensor){
                "Agua"-> 2.0
                else-> 1.0
            }
        }
    }
    private fun daño(ataque: Int, defensa: Int, efectividad: Double): Double{
        return 50*(ataque.toDouble()/defensa.toDouble())*efectividad
    }
}


/*
        enableEdgeToEdge()
        setContent {
            BatallaPokemónTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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
    BatallaPokemónTheme {
        Greeting("Android")
    }
}

 */