package com.example.lacarrera

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
import com.example.lacarrera.ui.theme.LaCarreraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val corredor1= arrayOf("run", "jump", "jump", "run", "run")
        val pista="|_||_|"
        val resultado=evaluadorDeRacin(corredor1, pista)
        println("Carrera superada: $resultado")
    }
    fun evaluadorDeRacin(corredor: Array<String>, circuito: String): Boolean{
        val pistaTuneada=circuito.toCharArray()
        var resultadoPisteo=true
        for (i in corredor.indices){
            when(corredor[i]){
                "run"-> {
                    if(pistaTuneada[i]=='|'){
                        pistaTuneada[i]='/'
                        resultadoPisteo=false
                    }
                }"jump"-> {
                if(pistaTuneada[i]=='_'){
                    pistaTuneada[i]='x'
                    resultadoPisteo=false
                }
            }
            }
        }
        println(pistaTuneada.concatToString())
        return resultadoPisteo
    }
}


/*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val corredor1= arrayOf("run", "jump", "jump", "run", "run")
        val pista="|_||_|"
        val resultado=evaluadorDeRacin(corredor1, pista)
        println("Carrera superada: $resultado")
    }
    fun evaluadorDeRacin(corredor: Array<String>, circuito: String): Boolean{
        val pistaTuneada=circuito.toCharArray()
        var resultadoPisteo=true
        for (i in corredor.indices){
            when(corredor[i]){
                "run"-> {
                    if(pistaTuneada[i]=='|'){
                        pistaTuneada[i]='/'
                        resultadoPisteo=false
                    }
                }"jump"-> {
                    if(pistaTuneada[i]=='_'){
                        pistaTuneada[i]='x'
                        resultadoPisteo=false
                    }
                }
            }
        }
        println(pistaTuneada.concatToString())
        return resultadoPisteo
    }
}
        enableEdgeToEdge()
        setContent {
            LaCarreraTheme {
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
    LaCarreraTheme {
        Greeting("Android")
    }
}

 */