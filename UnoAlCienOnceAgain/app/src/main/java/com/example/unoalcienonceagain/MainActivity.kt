package com.example.unoalcienonceagain

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
import com.example.unoalcienonceagain.ui.theme.UnoAlCienOnceAgainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contarClassic()
        contarWhile()
        contarDoWhile()
        contarRecursion()
        contarUntil()
        contarRepeatIncrementos()
        contarForEach()
    }
    private fun contarClassic(){
        for(i in 1..100){
            println(i)
        }
    }
    private fun contarWhile(){
        var i = 1
        while(i<=100){
            println(i)
            i++
        }
    }
    private fun contarDoWhile(){
        var i= 1
        do{
            println(i)
            i++
        }while(i<100)
    }
    private fun contarForEach(){
        (1..100).forEach{ i-> println(i)}
    }
    private fun contarRecursion(i: Int= 1){
        if(i>100)return
        println(i)
        contarRecursion(i+1)
    }
    private fun contarUntil(){
        for(i in 1 until 101){
            println(i)
        }
    }
    private fun contarRepeatIncrementos(){
        var i=1
        repeat(100){
            println(i)
            i++
        }
    }
}
/*
        enableEdgeToEdge()
        setContent {
            UnoAlCienOnceAgainTheme {
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
    UnoAlCienOnceAgainTheme {
        Greeting("Android")
    }
}

 */