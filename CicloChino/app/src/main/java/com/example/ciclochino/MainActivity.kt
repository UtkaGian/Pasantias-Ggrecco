package com.example.ciclochino

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
import com.example.ciclochino.ui.theme.CicloChinoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val año= 2020
        val resultado= calculadorZodiacal(año)
        println("En el año $año, elelemento es ${resultado.first} y el animal es ${resultado.second}.")
    }
    private fun calculadorZodiacal(año: Int): Pair<String, String>{
        val elementos= listOf("Madera", "Fuego", "Tierra", "Metal", "Agua")
        val animales= listOf("Rata", "Buey", "Tigre", "Conejo", "Dragón", "Serpiente", "Caballo", "Oveja", "Mono", "Gallo", "Perro", "Cerdo")
        val setAño=1984
        val offset= (año-setAño)%60
        val indiceElemental= ((offset/2)%5+5)%5
        val indiceAnimal= ((offset%12)+12)%12
        val elemento= elementos[indiceElemental]
        val animal= animales[indiceAnimal]
        return Pair(elemento, animal)
    }
}
/*

        enableEdgeToEdge()
        setContent {
            CicloChinoTheme {
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
    CicloChinoTheme {
        Greeting("Android")
    }
}

*/