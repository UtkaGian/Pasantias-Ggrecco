package com.example.trickortreat

import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlin.random.Random
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.trickortreat.ui.theme.TrickOrTreatTheme

data class Persona(val nombre: String, val edad: Int, val altura: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val personas =listOf(
            Persona("Ana", 8, 120),
            Persona("Julio", 10, 140),
            Persona("Roberto", 12, 130)
        )
        val opcion= "Trick"
        val resultado= trickOrTreat(opcion, personas)
        println("Resultado para $opcion: ${resultado.joinToString(", ")}")
    }
    private fun trickOrTreat(opcion: String, personas: List<Persona>): List<String>{
        val sustos= listOf("Calabaza", "Fantasma", "Calaca", "Araña", "Tela de araña", "Murciélago")
        val dulces= listOf("Chocolate", "Caramelo", "Paleta", "Galletita", "Dona", "Torta")
        val resultado= mutableListOf<String>()
        if (opcion.lowercase()=="Trick"){
            var totalSustos=0
            personas.forEach{persona->
                totalSustos+= persona.nombre.length/2
                if(persona.edad%2==0) totalSustos+=2
            }
            val alturaTotal= personas.sumOf { it.altura }
            totalSustos+= (alturaTotal/100)*3
            repeat(totalSustos){
                resultado.add(sustos.random())
            }
        } else if (opcion.lowercase()=="Treat"){
            var totalCaramelos= 0
            personas.forEach{persona->
                totalCaramelos+= persona.nombre.length
                totalCaramelos+= (persona.edad/3).coerceAtMost(10)
                totalCaramelos+= ((persona.altura/50)*2).coerceAtMost(6)
            }
            repeat(totalCaramelos){
                resultado.add(dulces.random())
            }
        }
        return resultado
    }
}

/*
        enableEdgeToEdge()
        setContent {
            TrickOrTreatTheme {
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
    TrickOrTreatTheme {
        Greeting("Android")
    }
}

*/