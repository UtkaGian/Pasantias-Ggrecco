package com.example.calculadordearea

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
import com.example.calculadordearea.ui.theme.CalculadorDeAreaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val string1="triángulo"
        val lado1=5.0
        val lado2=8.5
        val area=calculadorArea(string1, lado1, lado2)
        println("El área del polígono es de $area")
    }
    private fun calculadorArea(tipo: String, vararg lados: Double): Double {
        return when(tipo.lowercase()){
            "triángulo"-> {
                if(lados.size!=2){
                    println("Se requieren solo dos argumentos")
                    break
                }
                val base=lados[0]
                val altura=lados[1]
                (base*altura)/2
            }"cuadrado"-> {
                if(lados.size!=1){
                    println("Se requiere un solo argumento")
                    break
                }
                val lado=lados[0]
                lado*lado
            }"rectángulo"-> {
                if(lados.size!=2){
                    println("Se requieren dos argumentos")
                    break
                }
                val base=lados[0]
                val altura=lados[1]
                base*altura
            }
        }
    }
}

/*

abstract class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val string1="triángulo"
        val lado1=5.0
        val lado2=8.5
        val area=calculadorArea(string1, lado1, lado2)
        println("El área del polígono es de $area")
    }
    private fun calculadorArea(tipo: String, vararg lados: Double): Double {
        return when(tipo.lowercase()){
            "triángulo"-> {
                if(lados.size!=2){
                    println("Se requieren solo dos argumentos")
                    break
                }
                val base=lados[0]
                val altura=lados[1]
                (base*altura)/2
            }"cuadrado"-> {
                if(lados.size!=1){
                    println("Se requiere un solo argumento")
                    break
                }
                val lado=lados[0]
                lado*lado
            }"rectángulo"-> {
                if(lados.size!=2){
                    println("Se requieren dos argumentos")
                    break
                }
                val base=lados[0]
                val altura=lados[1]
                base*altura
            }
        }
    }
}


        enableEdgeToEdge()
        setContent {
            CalculadorDeAreaTheme {
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
    CalculadorDeAreaTheme {
        Greeting("Android")
    }
}

 */