package com.example.anagramas

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
import com.example.anagramas.ui.theme.AnagramasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var string1="abc"
        var string2="cab"
        var verdad=comparadorDeAnagramas(string1, string2)
        print("$verdad")
        string1="flamenco"
        string2="flamenco"
        verdad=comparadorDeAnagramas(string1, string2)
        print("$verdad")
        string1="skywalker"
        string2="kenobi"
        verdad=comparadorDeAnagramas(string1, string2)
        print("$verdad")
    }
    private fun comparadorDeAnagramas (string1: String, string2: String): Boolean {
        if(string1==string2) {
            return false
        }
        return string1.toCharArray().sorted()==string2.toCharArray().sorted()

    }
}


/*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var string1="abc"
        var string2="cab"
        var verdad=comparadorDeAnagramas(string1, string2)
        print("$verdad")
        string1="flamenco"
        string2="flamenco"
        verdad=comparadorDeAnagramas(string1, string2)
        print("$verdad")
        string1="skywalker"
        string2="kenobi"
        verdad=comparadorDeAnagramas(string1, string2)
        print("$verdad")
    }
    private fun comparadorDeAnagramas (string1: String, string2: String): Boolean {
        if(string1==string2) {
            return false
        }
        return string1.toCharArray().sorted()==string2.toCharArray().sorted()

    }
}

        enableEdgeToEdge()
        setContent {
            AnagramasTheme {
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
    AnagramasTheme {
        Greeting("Android")
    }
}

 */