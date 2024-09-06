package com.example.howisdaclimate

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
import androidx.lifecycle.lifecycleScope
import com.example.howisdaclimate.data.RetrofitService
import com.example.howisdaclimate.data.retrofitServiceFactory
import com.example.howisdaclimate.ui.theme.HowIsDaClimateTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service= retrofitServiceFactory.makeRetrofitService()
        lifecycleScope.launch {
            val movies= service.listOfPopularMovies("9b065c50c7dbe055f95d9b08d33558ad", "US")
            println(movies)
        }
        enableEdgeToEdge()
        setContent {
            HowIsDaClimateTheme {
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
    HowIsDaClimateTheme {
        Greeting("Android")
    }
}