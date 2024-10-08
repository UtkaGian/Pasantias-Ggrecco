package com.example.fizzbuzz

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
import com.example.fizzbuzz.ui.theme.FizzBuzzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fizzBuzz()
    }
    private fun fizzBuzz(){
        for(i in 1..100){
            if((i%3)==0&&(i%5)==0){
                println("fizzbuzz")
            }else if((i%3==0)){
                println("fizz")
            }else if((i%5)==0){
                println("buzz")
            }else{
                println("$i")
            }
        }
    }
}
/*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fizzBuzz()
    }
    private fun fizzBuzz(){
        for(i in 1..100){
            if((i%3)==0&&(i%5)==0){
                println("fizzbuzz")
            }else if((i%3==0)){
                println("fizz")
            }else if((i%5)==0){
                println("buzz")
            }else{
                println("$i")
            }
        }
    }
}

        enableEdgeToEdge()
        setContent {
            FizzBuzzTheme {
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
    FizzBuzzTheme {
        Greeting("Android")
    }
}

 */