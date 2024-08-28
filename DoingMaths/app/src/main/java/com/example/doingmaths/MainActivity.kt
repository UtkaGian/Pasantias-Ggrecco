package com.example.doingmaths

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
import com.example.doingmaths.ui.theme.DoingMathsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val conjunto1=arrayOf(1,2,3,4,5)
        val conjunto2=arrayOf(1,5,8,9,6,3)
        val comunes=conjuntos(conjunto1, conjunto2, true)
        println("Elementos comunes: ${comunes.joinToString(", ")}")
    }
    private fun conjuntos(c1: Array<Int>, c2: Array<Int>, cazadorDeComunes: Boolean): Array<Int>{
        val resultado=mutableListOf<Int>()

        if(cazadorDeComunes) {
            for (componente in c1) {
                for (componente2 in c2) {
                    if (componente == componente2 && componente !in resultado) {
                        resultado.add(componente)
                    }
                }
            }
        }else{
            for(componente in c1){
                if(componente !in c2 && componente !in resultado){
                    resultado.add(componente)
                }
            }
            for(componente in c2){
                if(componente !in c1 && componente !in resultado){
                    resultado.add(componente)
                }
            }
        }
        return resultado.toTypedArray()
    }
}
/*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val conjunto1=arrayOf(1,2,3,4,5)
        val conjunto2=arrayOf(1,5,8,9,6,3)
        val comunes=conjuntos(conjunto1, conjunto2, true)
        println("Elementos comunes: ${comunes.joinToString(", ")}")
    }
    private fun conjuntos(c1: Array<Int>, c2: Array<Int>, cazadorDeComunes: Boolean): Array<Int>{
        val resultado=mutableListOf<Int>()

        if(cazadorDeComunes) {
            for (componente in c1) {
                for (componente2 in c2) {
                    if (componente == componente2 && componente !in resultado) {
                        resultado.add(elemento)
                    }
                }
            }
        }else{
            for(componente in c1){
                if(componente !in c2 && componente !in resultado){
                    resultado.add(componente)
                }
            }
            for(componente in c2){
                if(componente !in c1 && componente !in resultado){
                    resultado.add(componente)
                }
            }
        }
        return resultado.toTypedArray()
    }
}

        enableEdgeToEdge()
        setContent {
            DoingMathsTheme {
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
    DoingMathsTheme {
        Greeting("Android")
    }
}

 */