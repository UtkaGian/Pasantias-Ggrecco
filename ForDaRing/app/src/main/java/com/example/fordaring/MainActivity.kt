package com.example.fordaring

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
import com.example.fordaring.ui.theme.ForDaRingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    val valoresRazas=mapOf(
        "Peloso" to 1,
        "Sureño bueno" to 2,
        "Enano" to 3,
        "Numenóreo" to 4,
        "Elfo" to 5,
        "Sureño malo" to 2,
        "Orco" to 2,
        "Goblin" to 2,
        "Huargo" to 3,
        "Troll" to 5
    )
    fun determinante(losBuenos: Map<String, Int>, losMaliciosos: Map<String, Int>): String{
        val valorDeLosBuenos=losBuenos.entries.sumOf { (raza, cantidad) ->
            (valoresRazas[raza] ?: 0) * cantidad
        }
        val valorDeLosMalos=losMaliciosos.entries.sumOf { (raza, cantidad) ->
            (valoresRazas[raza] ?: 0) * cantidad
        }
        return when{
            valorDeLosBuenos>valorDeLosMalos -> "El bien gana"
            valorDeLosBuenos<valorDeLosMalos -> "El mal gana"
            else -> "Combate eterno cuz while true en la guerra"
        }

    }
}
/*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    val valoresRazas=mapOf(
        "Peloso" to 1,
        "Sureño bueno" to 2,
        "Enano" to 3,
        "Numenóreo" to 4,
        "Elfo" to 5,
        "Sureño malo" to 2,
        "Orco" to 2,
        "Goblin" to 2,
        "Huargo" to 3,
        "Troll" to 5
    )
    fun determinante(losBuenos: map<String, Int>, losMaliciosos: map<String, Int>): String{
        val valorDeLosBuenos=losBuenos.entires.sumOf { (raza, cantidad) ->
            valoresRazas[raza] ?: 0 * cantidad
        }
        val valorDeLosMalos=losMaliciosos.entires.sumOf { (raza, cantidad) ->
            valoresRazas[raza] ?: 0 * cantidad
        }
        return when{
            valorDeLosBuenos>valorDeLosMalos -> "El bien gana"
            valorDeLosBuenos<valorDeLosMalos -> "El mal gana"
            else -> "Combate eterno cuz while true en la guerra"
        }

    }
}

        enableEdgeToEdge()
        setContent {
            ForDaRingTheme {
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
    ForDaRingTheme {
        Greeting("Android")
    }
}

 */