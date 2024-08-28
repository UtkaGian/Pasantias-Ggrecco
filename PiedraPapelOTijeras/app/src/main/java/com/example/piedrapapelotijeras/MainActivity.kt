package com.example.piedrapapelotijeras

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
import com.example.piedrapapelotijeras.ui.theme.PiedraPapelOTijerasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ativity_main)
        val jugadas1 = arrayOf("R", "S", "P")
        val jugadas2 = arrayOf("P", "P", "R")
        println(piedraPapelOTijera(jugadas1, jugadas2))


    }

    private fun piedraPapelOTijera(pibe1: Array<String>, pibe2: Array<String>): String {
        if (pibe1.size != pibe2.size) {
            return "ambos jugadores deben jugar la misma cantidad de veces"
        }
        var wins1 = 0
        var wins2 = 0
        for (i in pibe1.indices) {
            val jugador1 = pibe1[i]
            val jugador2 = pibe2[i]
            when {
                (jugador1 == "R" && jugador2 == "S") || (jugador1 == "S" && jugador2 == "P") || (jugador1 == "P" && jugador2 == "R") -> wins1++
                (jugador2 == "R" && jugador1 == "S") || (jugador2 == "S" && jugador1 == "P") || (jugador2 == "P" && jugador1 == "R") -> wins2++
            }
        }
        return when {
            wins1 > wins2 -> "Jugador 1"
            wins2 > wins1 -> "Jugador2"
            else -> "Empate"
        }
    }
}
/*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ativity_main)
        val jugadas1=arrayOf("R", "S", "P")
        val jugadas2=arrayOf("P", "P", "R")
        println(piedraPapelOTijera(jugadas1, jugadas2))


    }
    private fun piedraPapelOTijera(pibe1: Array<String>, pibe2: Array<String>): String{
        if(pibe1.size!=pibe2.size){
            return "ambos jugadores deben jugar la misma cantidad de veces"
        }
        var wins1=0
        var wins2=0
        for (i in pibe1.indices){
            val jugador1=pibe1[i]
            val jugador2=pibe2[i]
            when {
                (jugador1=="R" && jugador2=="S")||(jugador1=="S"&&jugador2=="P")||(jugador1=="P"&&jugador2=="R") -> wins1++
                (jugador2=="R" && jugador1=="S")||(jugador2=="S"&&jugador1=="P")||(jugador2=="P"&&jugador1=="R") -> wins2++
            }
        }
        return when {
            wins1>wins2->"Jugador 1"
            wins2>wins1->"Jugador2"
            else->"Empate"
        }
    }

        enableEdgeToEdge()
        setContent {
            PiedraPapelOTijerasTheme {
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
    PiedraPapelOTijerasTheme {
        Greeting("Android")
    }
}

*/