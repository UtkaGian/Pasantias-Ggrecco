package com.example.calculadoratxt

import android.os.Bundle
import androidx.activity.ComponentActivity
import java.io.File
import java.util.*
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadoratxt.ui.theme.CalculadoraTXTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fileName = "Challenge21.txt"
        val lineas = File(fileName).readLines()
        val numeros = LinkedList<Double>()
        val operaciones = LinkedList<Char>()

        try {
            for (linea in lineas) {
                when {
                    linea.matches("-?\\d+(\\.\\d+)?".toRegex()) -> numeros.add(linea.toDouble())
                    linea.matches("[+\\-*/]".toRegex()) -> operaciones.add(linea[0])
                    else -> throw IllegalArgumentException("El archivo no tiene el formato adecuado.")

                }
            }
            if (numeros.size != operaciones.size + 1) {
                throw IllegalArgumentException("Faltan datos en el archivo.")
            }
            var resultado = numeros.removeFirst()
            while (operaciones.isNotEmpty()) {
                val op = operaciones.removeFirst()
                val siguienteNumero = numeros.removeFirst()
                when (op) {
                    '+' -> resultado += siguienteNumero
                    '-' -> resultado -= siguienteNumero
                    '*' -> resultado *= siguienteNumero
                    '/' -> if (siguienteNumero != 0.0) resultado /= siguienteNumero else throw ArithmeticException(
                        "Dividiendo por cero."
                    )
                }
                println("Resultado: $resultado")
            }
        } catch (e: Exception) {
            println("No se pudo con las operaciones: ${e.message}")
        }
    }
}

/*
        enableEdgeToEdge()
        setContent {
            CalculadoraTXTTheme {
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
    CalculadoraTXTTheme {
        Greeting("Android")
    }
}

 */