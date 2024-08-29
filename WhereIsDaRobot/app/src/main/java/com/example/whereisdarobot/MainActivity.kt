package com.example.whereisdarobot

import android.os.Bundle
import android.util.Log
import android.widget.Button
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
import com.example.whereisdarobot.ui.theme.WhereIsDaRobotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnHiii= findViewById<Button>(R.id.btnHiii)
        btnHiii.setOnClickListener {
            Log.i("Juancarlo", "Boton pulsado")
        }
        //val pasos= intArrayOf(10, 5, -2)
        //val coordenadasFinales=coordsFinales(pasos)
        //println("Coordenadas finales: (${coordenadasFinales.first}, ${coordenadasFinales.second})")
    }
    private fun coordsFinales(pasos: IntArray): Pair<Int, Int>{
        val direcciones= arrayOf(Pair(0, 1), Pair(-1, 0), Pair(0, -1), Pair(1, 0))
        var direccionActual= 0
        var x= 0
        var y= 0
        pasos.forEach { paso ->
            val direccion = direcciones[direccionActual]
            val movimiento = paso * if (paso >= 0) 1 else -1
            x += direccion.first * movimiento
            y += direccion.second * movimiento
            direccionActual = (direccionActual + 1) % 4
        }
        return Pair(x, y)
    }
}

/*
        enableEdgeToEdge()
        setContent {
            WhereIsDaRobotTheme {
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
    WhereIsDaRobotTheme {
        Greeting("Android")
    }
}

*/